import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {routing} from './app.routing';
import {HttpClientModule} from '@angular/common/http';
import { RegistrationComponent } from './registration/registration.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { TestComponent } from './test/test.component';
import { UserAgentTestComponent } from './user-agent-test/user-agent-test.component';
import { UploadComponent } from './upload/upload.component';
import {DownloadComponent} from './user-agent-test/download/download.component';
import { MonitoringComponent } from './user-agent-test/monitoring/monitoring.component';
import {DataTablesModule} from 'angular-datatables';
import { MonitoringLinComponent } from './monitoring-lin/monitoring-lin.component';
import { TriggerComponent } from './trigger/trigger.component';
import { AddTriggerComponent } from './add-trigger/add-trigger.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegistrationComponent,
    HeaderComponent,
    FooterComponent,
    TestComponent,
    UserAgentTestComponent,
    DownloadComponent,
    UploadComponent,
    MonitoringComponent,
    MonitoringLinComponent,
    TriggerComponent,
    AddTriggerComponent
  ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        routing,
        BrowserAnimationsModule,
        MatToolbarModule,
        MatIconModule,
        MatButtonModule,
        MatProgressBarModule,
        ReactiveFormsModule,
        DataTablesModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
