import { Component, OnInit } from '@angular/core';
import { OffersService } from 'src/app/services/offers.service';
import { UiService } from 'src/app/services/ui.service';
import { FaIconLibrary } from '@fortawesome/angular-fontawesome';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fas } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private offersService: OffersService, private uiService: UiService, library: FaIconLibrary) {

    library.addIconPacks(fas, far);
   }

  isModelOpen = false;



  showModal(){
    this.isModelOpen = !this.isModelOpen;
  }

  onOpenAddModal() {
    console.log('onOpenAddModal');
    this.uiService.onOpenAddOfferModal();
  }

  ngOnInit(): void {
  }

  
}
