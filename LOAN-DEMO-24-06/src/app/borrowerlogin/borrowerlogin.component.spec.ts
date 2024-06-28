import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrowerloginComponent } from './borrowerlogin.component';

describe('BorrowerloginComponent', () => {
  let component: BorrowerloginComponent;
  let fixture: ComponentFixture<BorrowerloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BorrowerloginComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BorrowerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
