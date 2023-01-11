import { Component, OnInit } from '@angular/core';
import { UiService } from 'src/app/services/ui.service';

@Component({
  selector: 'app-add-offer-modal',
  templateUrl: './add-offer-modal.component.html',
  styleUrls: ['./add-offer-modal.component.css']
})
export class AddOfferModalComponent implements OnInit {

  constructor(private uiService: UiService) { }

  ngOnInit(): void {
  }

  onCloseModal(){
    this.uiService.onCloseAddOfferModal();
  }

}
