import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {System} from '../model/system';
import {TestService} from '../service/test.service';
import {FormControl} from '@angular/forms';
import {DownloadService} from '../service/download-service/download.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  system = new System();
  name = new FormControl('');
  constructor(private testService: TestService, private downloadService: DownloadService) { }

  ngOnInit(): void {
    this.testService.findAll().subscribe(data => {
      this.system = data;
    });
  }



}
