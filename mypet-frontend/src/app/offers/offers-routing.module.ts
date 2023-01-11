import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OfferDetailsComponent } from './offer-details/offer-details.component';
import { OffersPostsComponent } from './offers-posts/offers-posts.component';
import { OffersComponent } from './offers.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'offers' },
  { path: 'offers', component: OffersComponent, children: [
    { path: '', component: OffersPostsComponent },
    { path: ':id', component: OfferDetailsComponent },
  ]}
 
  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [
    RouterModule
  ]
})
export class OffersRoutingModule { }
