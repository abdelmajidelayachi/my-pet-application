import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OffersPostsComponent } from './offers-posts.component';

describe('OffersPostsComponent', () => {
  let component: OffersPostsComponent;
  let fixture: ComponentFixture<OffersPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OffersPostsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OffersPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
