import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/guards/auth.guard';
import { GuestGuard } from './core/guards/guest.guard';

const routes: Routes = [
  {
    path: '', 
    loadChildren: () => import('./offers/offers.module').then(m => m.OffersModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'auth',  
    loadChildren: () => import('./authentication/authentication.module').then(m => m.AuthenticationModule),
    // canActivate: [GuestGuard]
  },
  {
    path: 'account',
    loadChildren: () => import('./account/account.module').then(m => m.AccountModule),
    canActivate: [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
