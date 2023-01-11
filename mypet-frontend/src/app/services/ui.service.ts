import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UiService {

  constructor() { }
  showAddOfferModal = false;
  private subject = new Subject<any>();

  onCloseAddOfferModal():void {
    this.showAddOfferModal = false;
    this.subject.next(this.showAddOfferModal);
  }

  onOpenAddOfferModal():void {
    this.showAddOfferModal = true;
    this.subject.next(this.showAddOfferModal);
  }

  getStateAddModal():Observable<any>{
    return this.subject.asObservable();
  }
}
