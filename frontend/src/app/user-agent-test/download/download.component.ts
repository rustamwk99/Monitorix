import { Component, OnInit } from '@angular/core';
import {DownloadService} from '../../service/download-service/download.service';
import * as fileSaver from 'file-saver';
import {UserAgentService} from '../../service/user-agent-service/user-agent.service';

@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {

  constructor(private userAgentService: UserAgentService) { }

  ngOnInit(): void {
  }
  download() {
    this.userAgentService.downloadFile().subscribe((response: any) => {
      const blob: any = new Blob([response], { type: 'text/sh; charset=utf-8' });
      const url = window.URL.createObjectURL(blob);
      fileSaver.saveAs(blob, 'logs.sh');
    }), (error: any) => console.log('Error downloading the file'),
      () => console.info('File downloaded successfully');
  }

}
