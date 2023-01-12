import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { OffersService } from 'src/app/services/offers.service';
import { UiService } from 'src/app/services/ui.service';

@Component({
  selector: 'app-add-offer-modal',
  templateUrl: './add-offer-modal.component.html',
  styleUrls: ['./add-offer-modal.component.css'],
})
export class AddOfferModalComponent implements OnInit {
  constructor(
    private uiService: UiService,
    private fb: FormBuilder,
    private offersService: OffersService
  ) {}
  files: File[] = [];

  addOfferForm!: FormGroup;

  onSelect(event: { addedFiles: any }) {
    console.log(event);
    this.files.push(...event.addedFiles);
  }

  onRemove(event: any) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
  }
  onCloseModal() {
    this.uiService.onCloseAddOfferModal();
  }

  ngOnInit(): void {
    this.addOfferForm = this.fb.group({
      offer_title: ['', [Validators.required]],
      animal_type: ['', [Validators.required]],
      offer_description: [
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(250),
        ],
      ],
      animal_description: [
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(250),
        ],
      ],
      offer_price: ['', [Validators.required]],
      days_of_adoption: ['', [Validators.required]],
      contact: ['', [Validators.required]],
      city: ['', [Validators.required]],
    });
  }

  get offer_title() {
    return this.addOfferForm.get('offer_title');
  }

  get animal_type() {
    return this.addOfferForm.get('animal_type');
  }

  get offer_description() {
    return this.addOfferForm.get('offer_description');
  }

  get animal_description() {
    return this.addOfferForm.get('animal_description');
  }

  get offer_price() {
    return this.addOfferForm.get('offer_price');
  }

  get days_of_adoption() {
    return this.addOfferForm.get('days_of_adoption');
  }

  get contact() {
    return this.addOfferForm.get('contact');
  }

  get city() {
    return this.addOfferForm.get('city');
  }

  onSubmitAddOffer() {
    this.offersService
      .saveOffer(this.addOfferForm.value, this.files)
      .subscribe((res: any) => {
        console.log(res);
      });
  }
}
