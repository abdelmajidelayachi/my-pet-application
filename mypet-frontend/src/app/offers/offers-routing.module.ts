import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OffersComponent } from './offers.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'offers' },
  { path: 'offers', component: OffersComponent },
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OffersRoutingModule { }
