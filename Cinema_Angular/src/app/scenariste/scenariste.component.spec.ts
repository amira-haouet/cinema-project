import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScenaristeComponent } from './scenariste.component';

describe('ScenaristeComponent', () => {
  let component: ScenaristeComponent;
  let fixture: ComponentFixture<ScenaristeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ScenaristeComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ScenaristeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
