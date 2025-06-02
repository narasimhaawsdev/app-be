import { Component } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-fees',
  templateUrl: './account-fees.component.html'
})
export class AccountFeesComponent {
  accountId = '';
  fee: number | null = null;

  constructor(private accountService: AccountService) {}

  getFees() {
    this.accountService.getAccountFees(this.accountId).subscribe(f => {
      this.fee = f;
    });
  }
}
