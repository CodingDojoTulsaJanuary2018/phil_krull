import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { DeerService } from './deer.service';

import { AppComponent } from './app.component';
import { DeerNewComponent } from './deer-new/deer-new.component';
import { DeerListComponent } from './deer-list/deer-list.component';
import { DeerShowComponent } from './deer-show/deer-show.component';
import { DeerEditComponent } from './deer-edit/deer-edit.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    DeerNewComponent,
    DeerListComponent,
    DeerShowComponent,
    DeerEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [DeerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
