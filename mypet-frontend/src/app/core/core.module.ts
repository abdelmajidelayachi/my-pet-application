import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthGuard } from './guards/auth.guard';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HeaderInterceptor } from './interceptors/headers.interceptor';
import { ErrorInterceptor } from './interceptors/error.interceptor';
import { GuestGuard } from './guards/guest.guard';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,

  ],
  providers:[
    AuthGuard,
    GuestGuard,
    {
      provide : HTTP_INTERCEPTORS, useClass: HeaderInterceptor, multi: true
    },
    {
      provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true
    }
  ]
})
export class CoreModule { }
