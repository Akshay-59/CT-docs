import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HooksdemoComponent } from './hooksdemo.component';

describe('HooksdemoComponent', () => {
  let component: HooksdemoComponent;
  let fixture: ComponentFixture<HooksdemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HooksdemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HooksdemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
