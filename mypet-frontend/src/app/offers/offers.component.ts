import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { UiService } from '../services/ui.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  subscription !: Subscription;
  
  constructor(private uiService: UiService) {
    this.subscription = this.uiService.getStateAddModal().subscribe((state) => {
      this.modelAddModalState = state;
    });
   }

  modelAddModalState = false;
  

  ngOnInit(): void {
  }

}
