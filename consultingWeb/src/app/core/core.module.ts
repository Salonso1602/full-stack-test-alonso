import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { IdTokenInterceptor } from './interceptors/id-token.interceptor';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers : [
    {
    provide: HTTP_INTERCEPTORS,
    useClass: IdTokenInterceptor,
    multi: true
  }
]
})
export class CoreModule { }
