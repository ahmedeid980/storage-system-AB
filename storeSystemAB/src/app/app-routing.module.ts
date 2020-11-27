import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutSSABComponent } from './SSABLayout/layout-s-s-a-b/layout-s-s-a-b.component';
import { IncomingComponent } from './SSABPages/pages/incoming/incoming.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutSSABComponent,
    children: [
      {
        path: 'incoming',
        component: IncomingComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
