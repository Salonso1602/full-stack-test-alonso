import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomePageRoutingModule } from './home-page-routing.module';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { MatToolbarModule } from '@angular/material/toolbar'
import { MatCardModule } from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon'
 


@NgModule({
  declarations: [
    HomePageComponent
  ],
  imports: [
    CommonModule,
    HomePageRoutingModule,
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule
  ]
})
export class HomePageModule { }
