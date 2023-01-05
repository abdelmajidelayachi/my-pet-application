package com.example.mypet.services;

import com.example.mypet.entities.Response;
import com.example.mypet.payload.dao.ResponseResponse;
import com.example.mypet.payload.dto.ResponseRequest;
import com.example.mypet.repositories.ResponseRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseRepository responseRepository;
    private final UserService userService;

    public List<ResponseResponse> findAllResponses(){
        List<ResponseResponse> responseResponses = new ArrayList<>();
        responseRepository.findAll().forEach(
                response -> {
                    responseResponses.add(ResponseResponse.builder()
                            .id(response.getId())
                            .message(response.getContent())
                            .commentId(response.getComment().getId())
                            .userId(response.getUser().getId())
                            .build());
                }
        );
        return responseResponses;
    }

    public ResponseResponse findResponse(Long id){
        Response response =  responseRepository.findById(id).get();
        return ResponseResponse.builder()
                .id(response.getId())
                .message(response.getContent())
                .commentId(response.getComment().getId())
                .userId(response.getUser().getId())
                .build();
    }

    public ResponseResponse saveResponse(ResponseRequest responseRequest){
        if(responseRequest.getMessage() == null || responseRequest.getCommentId() == null){
            throw new RuntimeException("Message, commentId and userId are required");
        }
        Response response = Response.builder()
                .content(responseRequest.getMessage())
                .commentId(responseRequest.getCommentId())
                .userId(userService.findUserByEmail().getId())
                .build();
        responseRepository.save(response);
        return ResponseResponse.builder()
                .id(response.getId())
                .message(response.getContent())
                .commentId(response.getComment().getId())
                .userId(response.getUser().getId())
                .build();
    }

    @Transactional
    public ResponseResponse updateResponse(Long id, ResponseRequest responseRequest) {
        Response response = responseRepository.findById(id).orElseThrow(() -> new RuntimeException("Response not found"));
        if(responseRequest.getMessage() != null){
            response.setContent(responseRequest.getMessage());
        }

        return ResponseResponse.builder()
                .id(response.getId())
                .message(response.getContent())
                .commentId(response.getComment().getId())
                .userId(response.getUser().getId())
                .build();
    }

    public void deleteResponse(Long id){
        responseRepository.deleteById(id);
    }

}
