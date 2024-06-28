import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OfficerloginComponent } from './officerlogin.component';

describe('OfficerloginComponent', () => {
  let component: OfficerloginComponent;
  let fixture: ComponentFixture<OfficerloginComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OfficerloginComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(OfficerloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
