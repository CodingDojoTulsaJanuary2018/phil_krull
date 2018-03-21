import { ActivatedRoute, Params, Router } from '@angular/router';
import { DeerService } from './../deer.service';
import { Component, OnInit } from '@angular/core';
import { Deer } from '../deer';


@Component({
  selector: 'app-deer-edit',
  templateUrl: './deer-edit.component.html',
  styleUrls: ['./deer-edit.component.css']
})
export class DeerEditComponent implements OnInit {
  deer: Deer;

  constructor(private _dService: DeerService, private _aRouter: ActivatedRoute, private _router: Router) { }

  ngOnInit() {
    this._aRouter.params.subscribe((params: Params) => {
      console.log(params['id']);
      this._dService.getOneDeer(params['id']).subscribe((deer) => {
        console.log(deer['deer']);
        this.deer = deer['deer'];
      });
    });
  }

  updateDeer(id: String){
    this._dService.updateDeer(id, this.deer).subscribe((deer) => {
      console.log(deer);
      this._router.navigate(['/deer', id]);
    });
  }

}
