import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {

    if(this.authService.getAuth() === null){
      console.log('No login')
      this.router.navigateByUrl('/auth/login');
      return new Observable<boolean>(observer => {
        observer.next(false);
      });
    }
    return new Observable<boolean>(observer => {
      observer.next(true);
    });
  }
}