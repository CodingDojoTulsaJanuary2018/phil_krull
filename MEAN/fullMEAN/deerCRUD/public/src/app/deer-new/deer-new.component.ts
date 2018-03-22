import { DeerService } from './../deer.service';
import { Deer } from './../deer';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deer-new',
  templateUrl: './deer-new.component.html',
  styleUrls: ['./deer-new.component.css']
})
export class DeerNewComponent implements OnInit {
  deer: Deer = new Deer();
  errors: String[];
  // or
  err: Array<String>;

  constructor(private _dService: DeerService, private _router: Router) { }

  ngOnInit() {
  }

  addDeer() {
    // send data to the deer sevice
    this._dService.addDeer(this.deer).subscribe((result) => {
      if (result['message'] === 'success') {
        this.deer = new Deer();
        this._router.navigate(['deer']);
      } else {
        this.errors = result['errors'];
        console.log(result['errors']);
      }
    });
    // redirect to the root route
  }

}
