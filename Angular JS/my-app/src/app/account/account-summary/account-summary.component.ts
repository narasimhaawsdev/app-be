import { Component } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account.model';

@Component({
  selector: 'app-account-summary',
  templateUrl: './account-summary.component.html'
})
export class AccountSummaryComponent {
  accountId = '';
  summary: Account | null = null;

  constructor(private accountService: AccountService) {}

  fetchSummary() {
    this.accountService.getAccountSummary(this.accountId).subscribe(account => {
      this.summary = account;
    });
  }
}
