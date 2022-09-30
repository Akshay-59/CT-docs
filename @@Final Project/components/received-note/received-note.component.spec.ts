import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceivedNoteComponent } from './received-note.component';

describe('ReceivedNoteComponent', () => {
  let component: ReceivedNoteComponent;
  let fixture: ComponentFixture<ReceivedNoteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReceivedNoteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceivedNoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
