import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSpecComponent } from './edit-spec.component';

describe('EditSpecComponent', () => {
  let component: EditSpecComponent;
  let fixture: ComponentFixture<EditSpecComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditSpecComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSpecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
