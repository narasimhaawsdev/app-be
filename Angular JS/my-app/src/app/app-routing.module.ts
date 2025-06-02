import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountCreateComponent } from './account/account-create/account-create.component';
import { AccountCloseComponent } from './account/account-close/account-close.component';
import { AccountSummaryComponent } from './account/account-summary/account-summary.component';
import { AccountFeesComponent } from './account/account-fees/account-fees.component';
import { AccountTypesComponent } from './account/account-types/account-types.component';

const routes: Routes = [
  { path: 'accounts/create', component: AccountCreateComponent },
  { path: 'accounts/:id/close', component: AccountCloseComponent },
  { path: 'accounts/:id/summary', component: AccountSummaryComponent },
  { path: 'accounts/types', component: AccountTypesComponent },
  { path: 'accounts/:id/fees', component: AccountFeesComponent },
  { path: '', redirectTo: '/accounts/create', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]  // ✅ Required
})
export class AppRoutingModule {}
