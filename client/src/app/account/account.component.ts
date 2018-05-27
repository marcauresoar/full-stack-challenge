import { Component, OnInit } from '@angular/core';
import { DataStorageService } from '../core/data-storage.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  subscription: Subscription;

  constructor(private dataStorageService: DataStorageService) { }

  ngOnInit() {
    this.dataStorageService.listAllAccounts();
  }

}
