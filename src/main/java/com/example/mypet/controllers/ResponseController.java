package com.example.mypet.controllers;


import com.example.mypet.payload.dto.ResponseRequest;
import com.example.mypet.services.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/response")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllResponses(){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", responseService.findAllResponses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getResponseById(@PathVariable Long id){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", responseService.findResponse(id)));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createResponse(@RequestBody ResponseRequest responseRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", responseService.saveResponse(responseRequest)));
    }

    @PutMapping("{id}")
    public ResponseEntity<Map<String, Object>> updateResponse(@PathVariable Long id, @RequestBody ResponseRequest responseRequest){
        return ResponseEntity.ok().body(Map.of("status", "success", "data", responseService.updateResponse(id, responseRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deleteResponse(@PathVariable Long id){
        responseService.deleteResponse(id);
        return ResponseEntity.ok().body(Map.of("status", "success", "data", "Response deleted successfully"));
    }
}
