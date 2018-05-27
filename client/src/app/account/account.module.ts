import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AccountComponent } from './account.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { AccountStatementsComponent } from './account-statements/account-statements.component';
import { AccountService } from './account.service';
import { StatementService } from './statement.service';
import { DatePipe } from './date.pipe';
import { CurrencyPipe } from './currency.pipe';

@NgModule({
  declarations: [
    AccountComponent,
    AccountDetailsComponent,
    AccountStatementsComponent,
    DatePipe,
    CurrencyPipe
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    DatePipe,
    CurrencyPipe
  ],
  providers: [
    AccountService,
    StatementService
  ]
})
export class AccountModule {}
