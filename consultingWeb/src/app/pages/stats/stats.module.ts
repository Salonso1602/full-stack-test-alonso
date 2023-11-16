import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { StatsRoutingModule } from './stats-routing.module';
import { ViewStatsComponent } from './pages/view-stats/view-stats.component';
import { CoreModule } from 'src/app/core/core.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  declarations: [
    ViewStatsComponent
  ],
  imports: [
    CommonModule,
    StatsRoutingModule,
    CoreModule,
    SharedModule,
    MatToolbarModule,
    MatIconModule
  ]
})
export class StatsModule { }
