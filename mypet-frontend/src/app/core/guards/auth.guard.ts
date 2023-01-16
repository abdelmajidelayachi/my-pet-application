import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  authSubscription !: Subscription;
  isAuthenticated !: boolean;
  constructor(private authService: AuthService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

    this.authSubscription = this.authService.getAuth().subscribe(
      (res: any) => {
        console.log(res);
        if(!res.isValid){
          this.router.navigateByUrl('/auth/login');
          this.isAuthenticated = false;
        }
        else{
          this.isAuthenticated = true;
        }
      }
    )
      
    return this.isAuthenticated;


    // console.log(this.authService.getAuth());
    // if(!this.authService.getAuth()){
    //   console.log('No login')
    //   this.router.navigateByUrl('/auth/login');
    //   return new Observable<boolean>(observer => {
    //     observer.next(false);
    //   });
    // }
    // return new Observable<boolean>(observer => {
    //   observer.next(true);
    // });
  }
}