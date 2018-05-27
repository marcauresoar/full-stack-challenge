import { Component, OnInit, OnDestroy } from '@angular/core';
import { Statement } from '../statement.model';
import { StatementService } from '../statement.service';
import { Subscription } from 'rxjs';
import { AccountService } from '../account.service';

@Component({
  selector: 'app-account-statements',
  templateUrl: './account-statements.component.html',
  styleUrls: ['./account-statements.component.css']
})
export class AccountStatementsComponent implements OnInit, OnDestroy {
  statements: Statement[];
  subscription: Subscription;

  constructor(private statementService: StatementService) { }

  ngOnInit() {
    this.subscription = this.statementService.statementsChanged.subscribe(
      (statements: Statement[]) => {
        this.statements = statements;
      }
    );
  }

  ngOnDestroy(){
    this.subscription.unsubscribe();
  }

}
