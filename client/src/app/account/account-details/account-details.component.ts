import { Component, OnInit, OnDestroy } from '@angular/core';

import { Account } from '../account.model';
import { AccountService } from '../account.service';
import { Subscription, Subject } from 'rxjs';

@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.css']
})
export class AccountDetailsComponent implements OnInit, OnDestroy {
  accounts: Account[];
  selectedAccount: Account;
  subscription: Subscription;

  constructor(private accountService: AccountService) { }

  ngOnInit() {
    this.subscription = this.accountService.accountsChanged.subscribe(
      (accounts: Account[]) => {
        this.accounts = accounts;
        this.selectedAccount = this.accounts[0];
        this.accountService.selectedAccountChanged.next(this.selectedAccount);
      }
    );
    this.accounts = this.accountService.getAccounts();
    this.selectedAccount = this.accounts[0];
  }

  onChange(value){
    if(this.accounts[value] !== undefined){
      this.selectedAccount = this.accounts[value];
      this.accountService.selectedAccountChanged.next(this.selectedAccount);
    }
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
