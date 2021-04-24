import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  agent = window.navigator.appVersion;
  os: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
    if (this.agent.indexOf('Win') !== -1) {this.os = 'Windows'; }
    if (this.agent.indexOf('Linux') !== -1) {this.os = 'Linux'; }
    if (this.agent.indexOf('Mac') !== -1) {this.os = 'MacOS'; }
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
  toBot(){
    this.router.navigateByUrl('https://t.me/SunEclipseBot');

  }

}
