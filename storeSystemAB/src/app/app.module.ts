import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

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
import { LoginComponent } from './login/login/login.component';
import { IntegrationService } from './services/serviceIntegration/integration.service';
import { CustomService } from './services/custom/custom.service';
import { LoginLayoutComponent } from './SSABLayout/login-layout/login-layout.component';
import { ASEEncryptDecryptService } from './services/security/a-s-e-encrypt-decrypt.service';
import { OutBoundComponent } from './SSABPages/pages/out-bound/out-bound.component';
import { TransferingComponent } from './SSABPages/pages/transfering/transfering.component';
import { BouncedBackComponent } from './SSABPages/pages/bounced-back/bounced-back.component';

@NgModule({
  declarations: [
    AppComponent,LayoutSSABComponent,NavParComponent,FooterParComponent,
    ContentComponent,SliderComponent,IncomingComponent, LoginComponent, LoginLayoutComponent, OutBoundComponent, TransferingComponent, BouncedBackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,ReactiveFormsModule,
    NgbAlertModule , NgbModule,HttpClientModule
  ],
  providers: [IntegrationService, CustomService, ASEEncryptDecryptService],
  bootstrap: [AppComponent]
})
export class AppModule { }
