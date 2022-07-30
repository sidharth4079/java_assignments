import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { SalesPersonListComponent } from './sales-person-list.component';

describe('SalesPersonListComponent', () => {
  let component: SalesPersonListComponent;
  let fixture: ComponentFixture<SalesPersonListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalesPersonListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SalesPersonListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
  declarations: [
    FormsModule,
    SalesPersonListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ]
})

export class AppModule { }