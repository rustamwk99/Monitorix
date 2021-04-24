import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {TriggerServiceService} from '../service/trigger-service/trigger-service.service';

@Component({
  selector: 'app-add-trigger',
  templateUrl: './add-trigger.component.html',
  styleUrls: ['./add-trigger.component.css']
})
export class AddTriggerComponent implements OnInit {
  agent = window.navigator.appVersion;
  os: string;
  constructor(private formBuilder: FormBuilder, private router: Router, private triggerService: TriggerServiceService) { }

  addForm: FormGroup;

  ngOnInit() {
    if (this.agent.indexOf('Win') !== -1) {this.os = 'Windows'; }
    if (this.agent.indexOf('Linux') !== -1) {this.os = 'Linux'; }
    if (this.agent.indexOf('Mac') !== -1) {this.os = 'MacOS'; }
    this.addForm = this.formBuilder.group({
      id: [],
      trigger: ['', Validators.required],
      login: [sessionStorage.getItem('login')],
      os: [this.os],
    });

  }

  onSubmit() {
    this.triggerService.addTrigger(this.addForm.value)
      .subscribe(data => {
        this.router.navigate(['user_agent/triggers']);
        console.log(this.addForm.value);
      });
  }

}
