import { DeerService } from './../deer.service';
import { Component, OnInit } from '@angular/core';
import { Deer } from '../deer';

@Component({
  selector: 'app-deer-list',
  templateUrl: './deer-list.component.html',
  styleUrls: ['./deer-list.component.css']
})
export class DeerListComponent implements OnInit {
  deers: Deer[];

  constructor(private _dService: DeerService) { }

  ngOnInit() {
    // call the service to retrieve all deers, expect an observable
    this.getDeers();
  }

  getDeers(){
    this._dService.getDeers().subscribe(deers => this.deers = deers as Deer[]);
  }

  deleteDeer(id: String){
    this._dService.deleteDeer(id).subscribe(response => {
      this.getDeers();
    });
  }
}
