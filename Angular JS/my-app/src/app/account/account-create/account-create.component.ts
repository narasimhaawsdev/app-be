import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';
import { Account } from '../account.model';

@Component({
  selector: 'app-account-create',
  templateUrl: './account-create.component.html'
})
export class AccountCreateComponent implements OnInit {
  account: Account = { id: '', customerId: '', balance: 0, type: '', closed: false };
  accountTypes: string[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit() {
    this.accountService.getAccountTypes().subscribe(types => this.accountTypes = types);
  }

  create() {
    this.accountService.createAccount(this.account).subscribe(res => {
      alert('Account created!');
    });
  }
}
