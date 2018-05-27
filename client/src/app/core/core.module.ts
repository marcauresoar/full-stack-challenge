import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from '../app-routing.module';
import { DataStorageService } from './data-storage.service';

@NgModule({
  declarations: [
    HeaderComponent,
    HomeComponent
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule
  ],
  exports: [
    AppRoutingModule,
    HeaderComponent
  ],
  providers: [
    DataStorageService
  ]
})
export class CoreModule {}
