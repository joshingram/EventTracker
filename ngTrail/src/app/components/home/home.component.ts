import { Component, OnInit } from '@angular/core';
import { Trail } from 'src/app/models/trail';
import { TrailService } from 'src/app/services/trail.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(
    private trailService: TrailService
  ) { }

trails: Trail[] = [];

  loadTrails(){
this.trailService.index().subscribe({
  next: (trails) =>{
    console.log(trails);
    this.trails = trails;
  },
  error: (oops) => {
    console.error("homeComponent.loadTrails: error getting trails")
  }
})
  }

  ngOnInit(): void {
    this.loadTrails();
  }

}
