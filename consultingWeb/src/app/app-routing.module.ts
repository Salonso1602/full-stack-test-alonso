import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo : "/home", pathMatch : "full" },
  { path: 'home', loadChildren: () => import('./pages/home-page/home-page.module').then(m => m.HomePageModule) },
  { path: 'stats', loadChildren: () => import('./pages/stats/stats.module').then(m => m.StatsModule) },
  { path: 'logIn', loadChildren: () => import('./pages/login-page/login-page.module').then(m => m.LoginPageModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
