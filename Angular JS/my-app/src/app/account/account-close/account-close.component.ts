import { Component } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-close',
  templateUrl: './account-close.component.html'
})
export class AccountCloseComponent {
  accountId = '';

  constructor(private accountService: AccountService) {}

  closeAccount() {
    this.accountService.closeAccount(this.accountId).subscribe(() => {
      alert('Account closed!');
    });
  }
}
