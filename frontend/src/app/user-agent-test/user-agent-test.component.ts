import { Component, OnInit } from '@angular/core';
import {TestService} from '../service/test.service';
import {System} from '../model/system';
import {UserAgentService} from '../service/user-agent-service/user-agent.service';
import * as fileSaver from 'file-saver';


@Component({
  selector: 'app-user-agent-test',
  templateUrl: './user-agent-test.component.html',
  styleUrls: ['./user-agent-test.component.css']
})
export class UserAgentTestComponent implements OnInit {
  system = new System();
  agent = window.navigator.appVersion;
  os: string;

  constructor(private userAgentService: UserAgentService) {
    this.userAgentService.path = this.os;
  }
  ngOnInit(): void {
    this.userAgentService.userAgent().subscribe(data => {
      this.system = data;
    });
    if (this.agent.indexOf('Win') !== -1) {this.os = 'Windows'; }
    if (this.agent.indexOf('Linux') !== -1) {this.os = 'Linux'; }
    if (this.agent.indexOf('Mac') !== -1) {this.os = 'MacOS'; }
    this.userAgentService.path = this.os;

  }
  download(os: string) {
    this.userAgentService.path = os;
    this.userAgentService.downloadFile().subscribe((response: any) => {
      const blob: any = new Blob([response], { type: 'text/sh; charset=utf-8' });
      const url = window.URL.createObjectURL(blob);
      if (os === 'Linux'){
        fileSaver.saveAs(blob, this.userAgentService.path + 'logs.sh');
      }
      if (os === 'Windows'){
        fileSaver.saveAs(blob, this.userAgentService.path + 'logs.rar');
      }
      if (os === 'MacOs'){
        fileSaver.saveAs(blob, this.userAgentService.path + 'logs.rar');
      }
    }), (error: any) => console.log('Error downloading the file'),
      () => console.info('File downloaded successfully');
  }

  isWindows(){
    if (this.os === 'Windows'){
      return true;
    } else {
      return false;
    }
  }
  isLinux(){
    if (this.os === 'Linux'){
      return true;
    } else {
      return false;
    }
  }
  isMacOs(){
    if (this.os === 'MacOs'){
      return true;
    } else {
      return false;
    }
  }

}
