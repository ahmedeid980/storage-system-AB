import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { IncomingGuardGuard } from './SSABGuard/incoming-guard.guard';
import { LayoutSSABComponent } from './SSABLayout/layout-s-s-a-b/layout-s-s-a-b.component';
import { LoginLayoutComponent } from './SSABLayout/login-layout/login-layout.component';
import { BouncedBackComponent } from './SSABPages/pages/bounced-back/bounced-back.component';
import { IncomingComponent } from './SSABPages/pages/incoming/incoming.component';
import { OutBoundComponent } from './SSABPages/pages/out-bound/out-bound.component';
import { TransferingComponent } from './SSABPages/pages/transfering/transfering.component';

const routes: Routes = [
  { path: '',   redirectTo: '/login', pathMatch: 'full' },
  {
    path: '',
    component: LoginLayoutComponent,
    children: [
      {
        path: 'login',
        component: LoginComponent
      }
    ]
  },
  {
    path: '',
    component: LayoutSSABComponent,
    children: [
      {
        path: 'incoming',
        component: IncomingComponent,
        canActivate: [IncomingGuardGuard]
      },
      {
        path: 'outbound',
        component: OutBoundComponent
      },
      {
        path: 'transfer',
        component: TransferingComponent
      },
      {
        path: 'bouncedBack',
        component: BouncedBackComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
