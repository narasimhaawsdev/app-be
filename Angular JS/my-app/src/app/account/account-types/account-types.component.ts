import { Component, OnInit } from '@angular/core';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-types',
  templateUrl: './account-types.component.html'
})
export class AccountTypesComponent implements OnInit {
  accountTypes: string[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit() {
    this.accountService.getAccountTypes().subscribe(types => {
      this.accountTypes = types;
    });
  }
}
