import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  isModelOpen = false;

  showModal(){
    this.isModelOpen = !this.isModelOpen;
  }

  ngOnInit(): void {
  }

  
}
