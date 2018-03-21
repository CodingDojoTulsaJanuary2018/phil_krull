import { DeerEditComponent } from './deer-edit/deer-edit.component';
import { DeerShowComponent } from './deer-show/deer-show.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeerNewComponent } from './deer-new/deer-new.component';
import { DeerListComponent } from './deer-list/deer-list.component';

const routes: Routes = [
  {path: 'addDeer', component: DeerNewComponent},
  {path: 'deer/:id', component: DeerShowComponent},
  {path: 'deer/:id/edit', component: DeerEditComponent},
  {path: 'deer', redirectTo: ''},
  {path: '', component: DeerListComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
