import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { NgbAlertModule , NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LayoutSSABComponent } from './SSABLayout/layout-s-s-a-b/layout-s-s-a-b.component';
import { NavParComponent } from './SSABPages/nav/nav-par/nav-par.component';
import { FooterParComponent } from './SSABPages/footer/footer-par/footer-par.component';
import { ContentComponent } from './SSABPages/contents/content/content.component';
import { SliderComponent } from './SSABPages/slider/slider/slider.component';
import { IncomingComponent } from './SSABPages/pages/incoming/incoming.component';

@NgModule({
  declarations: [
    AppComponent,LayoutSSABComponent,NavParComponent,FooterParComponent,
    ContentComponent,SliderComponent,IncomingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,ReactiveFormsModule,
    NgbAlertModule , NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
