import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

import { AccountCreateComponent } from './account/account-create/account-create.component';
import { AccountSummaryComponent } from './account/account-summary/account-summary.component';
import { AccountCloseComponent } from './account/account-close/account-close.component';
import { AccountFeesComponent } from './account/account-fees/account-fees.component';
import { AccountTypesComponent } from './account/account-types/account-types.component';

const routes: Routes = [
  { path: 'accounts/create', component: AccountCreateComponent },
  { path: 'accounts/summary', component: AccountSummaryComponent },
  { path: 'accounts/close', component: AccountCloseComponent },
  { path: 'accounts/fees', component: AccountFeesComponent },
  { path: 'accounts/types', component: AccountTypesComponent },
  { path: '', redirectTo: 'accounts/create', pathMatch: 'full' },  // default redirect
  { path: '**', redirectTo: 'accounts/create' } // wildcard route for 404
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),  
    AppComponent,
    BrowserModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

