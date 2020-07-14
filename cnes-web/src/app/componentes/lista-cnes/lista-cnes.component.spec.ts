import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCNESComponent } from './lista-cnes.component';

describe('ListaCNESComponent', () => {
  let component: ListaCNESComponent;
  let fixture: ComponentFixture<ListaCNESComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaCNESComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaCNESComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
