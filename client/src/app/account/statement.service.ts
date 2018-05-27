import { Injectable, OnInit, OnDestroy } from '@angular/core';

import { Statement } from './statement.model';
import { Subject, Subscription } from 'rxjs';
import { AccountService } from './account.service';
import { Account } from './account.model';
import { DataStorageService } from '../core/data-storage.service';

@Injectable()
export class StatementService implements OnDestroy {
  statementsChanged = new Subject<Statement[]>();
  subscription: Subscription;
  statementsSubscription: Subscription;

  private statements: Statement[] = [
    new Statement(11, '2010-10-10', 'Saque', 123.22, 4352.00)
  ];

  constructor(private accountService: AccountService,
              private dataStorageService: DataStorageService) {
    this.subscription = this.accountService.selectedAccountChanged.subscribe(
      (account: Account) => {
        console.log("Selected account of id " + account.id + ".");
        this.statementsSubscription = this.dataStorageService.listAccountStatements(account.id).subscribe(
          (data: Statement[]) => {
            console.log("Successfully fetched statements from account " + account.id + ".");
            console.log(data);
            this.setStatements(data);
          }
        );
      }
    )
  }

  getStatements() {
    return this.statements.slice();
  }

  setStatements(newStatements: Statement[]){
      this.statements = newStatements;
      this.statementsChanged.next(this.getStatements());
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
    this.statementsSubscription.unsubscribe();
  }

}
