import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Injectable()
export class HeaderInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const headers = req.headers;
    const token = this.authService.getAuth();
    headers.set('Content-Type', 'application/json');
    
    if(token != null){
      headers.set('Authorization', `Bearer ${token}`);
    }

    const authReq = req.clone({ headers });
    return next.handle(authReq);
  }
}