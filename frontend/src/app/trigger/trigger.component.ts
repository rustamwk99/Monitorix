import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {TriggerServiceService} from '../service/trigger-service/trigger-service.service';
import {Trigger} from '../model/trigger';

@Component({
  selector: 'app-trigger',
  templateUrl: './trigger.component.html',
  styleUrls: ['./trigger.component.css']
})
export class TriggerComponent implements OnInit {
  triggers: Trigger[];
  login: string;

  constructor(private router: Router, private triggerService: TriggerServiceService) { }
  ngOnInit(): void {
      this.getTriggers();
  }
  getTriggers() {
    this.triggerService.getTriggers().subscribe(data => {
      this.triggers = data;
    });
  }

  addTrigger(): void {
    this.router.navigate(['user_agent/add'])
      .then((e) => {
        if (e) {
          console.log('');
        } else {
          console.log('');
        }
      });
  }
  deleteTrigger(id: bigint){
    this.triggerService.deleteTrigger(id);
  }


}
