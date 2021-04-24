import { Component, OnInit } from '@angular/core';
import {MonitoringService} from '../../service/monitoring-service/monitoring.service';
import {Observable, Subject} from 'rxjs';
import {Winlog} from '../../model/winlog';
import {Router} from '@angular/router';



@Component({
  selector: 'app-monitoring',
  templateUrl: './monitoring.component.html',
  styleUrls: ['./monitoring.component.css']
})
export class MonitoringComponent implements OnInit {
  fileContent: string | ArrayBuffer;
  fileLoad: string;
  fileFrom: string;
  lines: any;
  logs: Observable<Winlog>;
  log: Winlog = new Winlog();
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  isupdated = false;
  constructor(private monitoringService: MonitoringService, private router: Router) { }
  ngOnInit(): void {
    this.isupdated = false;
    this.dtOptions = {
      paging: true,
      pagingType: 'full_numbers',
      pageLength: 10,
      stateSave: true,
      lengthMenu: [[10, 15, 20, -1], [10, 15, 20, 'All']],
      processing: true
    };
    this.monitoringService.getLogs().subscribe(data => {
    this.logs = data;
    this.dtTrigger.next();
    });
  }

  public onChange(fileList: FileList): void {
    const file = fileList[0];
    const fileReader: FileReader = new FileReader();
    const self = this;
    // tslint:disable-next-line:only-arrow-functions
    fileReader.onloadend = function(x) {
      self.fileContent = fileReader.result.toString();
      self.lines = fileReader.result.toString().split('\n');
      // tslint:disable-next-line:prefer-for-of
      // for (let line = 0; line < lines.length; line++){
      //   console.log(lines[line]);
      // }
    };
    fileReader.readAsText(file);
  }
  public onPress(){
    this.router.navigate(['user_agent/triggers']);
  }

}
