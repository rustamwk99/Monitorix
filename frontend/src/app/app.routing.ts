import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import {RegistrationComponent} from './registration/registration.component';
import {TestComponent} from './test/test.component';
import {UserAgentTestComponent} from './user-agent-test/user-agent-test.component';
import {DownloadComponent} from './user-agent-test/download/download.component';
import {UploadComponent} from './upload/upload.component';
import {MonitoringComponent} from './user-agent-test/monitoring/monitoring.component';
import {MonitoringLinComponent} from './monitoring-lin/monitoring-lin.component';
import {TriggerComponent} from './trigger/trigger.component';
import {AddTriggerComponent} from './add-trigger/add-trigger.component';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'test', component: TestComponent },
  { path: 'user_agent/download', component: DownloadComponent },
  { path: 'test/upload', component: UploadComponent },
  { path: 'user_agent', component: UserAgentTestComponent },
  { path: 'monitoring', component: MonitoringComponent },
  { path: 'monitoringLin', component: MonitoringLinComponent},
  { path: 'user_agent/triggers', component: TriggerComponent },
  { path: 'user_agent/add', component: AddTriggerComponent },
  { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
