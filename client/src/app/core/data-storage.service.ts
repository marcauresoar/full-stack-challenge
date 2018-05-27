
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpRequest } from '@angular/common/http';

import { Account } from '../account/account.model';
import { Statement } from '../account/statement.model';

import { AccountService } from '../account/account.service';
import { StatementService } from '../account/statement.service';

@Injectable()
export class DataStorageService {

    private dataStorageEndpoint = 'http://localhost:8080/';

    constructor(private httpClient: HttpClient,
                private accountService: AccountService){

    }

    listAllAccounts() {
        const url = this.dataStorageEndpoint + "account/list";
        this.httpClient.get(
            url, {
                observe: 'body',
                responseType: 'json'
            }
        ).subscribe(
            (data: Account[]) => {
                console.log("Successfully fetched accounts.");
                console.log(data);
                this.accountService.setAccounts(data);
            },
            error => {
                console.log("Error trying to fetch accounts.");
                console.log(error);
            }
        )
    }

    listAccountStatements(accountId: number){
        const url = this.dataStorageEndpoint + "statement/list/" + accountId;
        return this.httpClient.get(
            url, {
                observe: 'body',
                responseType: 'json'
            }
        )
    }



}
