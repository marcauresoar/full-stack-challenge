import { Injectable, OnInit } from '@angular/core';

import { Account } from './account.model';
import { Client } from './client.model';
import { Subject } from 'rxjs';

@Injectable()
export class AccountService {
  accountsChanged = new Subject<Account[]>();
  selectedAccountChanged = new Subject<Account>();

  private accounts: Account[] = [
    new Account(11, '1234', '534534543', '8', new Client(111, 'Client 1'), []),
    new Account(22, '4545', '673454355', '9', new Client(222, 'Client 2'), [])
  ];

  constructor() {

  }

  getAccounts() {
    return this.accounts.slice();
  }

  setAccounts(newAccounts: Account[]){
      this.accounts = newAccounts;
      this.accountsChanged.next(this.getAccounts());
  }

}
