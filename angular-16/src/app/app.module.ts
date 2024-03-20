import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CommonModule, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {FullComponent} from './layouts/full/full.component';


import {NavigationComponent} from './shared/header/navigation.component';
import {SidebarComponent} from './shared/sidebar/sidebar.component';

import {Approutes} from './app-routing.module';
import {AppComponent} from './app.component';
import {SpinnerComponent} from './shared/spinner.component';
import {LoginComponent} from './pages/login/login.component';
import {ToastrModule} from "ngx-toastr";
import {HttpInterceptorService} from "./service/HttpInterceptorService";
import { ProfileComponent } from './pages/profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    SpinnerComponent,
    LoginComponent,
    ProfileComponent,
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(),
    RouterModule.forRoot(Approutes, {useHash: false}),
    FullComponent,
    NavigationComponent,
    SidebarComponent,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    },
    {
      provide: LocationStrategy,
      useClass: PathLocationStrategy
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
