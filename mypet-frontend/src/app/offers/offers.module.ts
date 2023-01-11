import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OffersPostsComponent } from './offers-posts/offers-posts.component';
import { OfferDetailsComponent } from './offer-details/offer-details.component';
import { OffersRoutingModule } from './offers-routing.module';
import { HeaderComponent } from '../components/header/header.component';
import { FooterComponent } from '../components/footer/footer.component';
import { OffersComponent } from './offers.component';
import { OfferComponent } from '../components/offer/offer.component';
import { AddOfferModalComponent } from '../components/add-offer-modal/add-offer-modal.component';




@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    OffersComponent,
    OffersPostsComponent,
    OfferDetailsComponent,
    OfferComponent,
    AddOfferModalComponent
  ],
  imports: [
    CommonModule,
    OffersRoutingModule
  ],
  bootstrap: [OffersModule]
})
export class OffersModule { }
