import { Component, OnInit } from '@angular/core';
import { Trail } from 'src/app/models/trail';
import { TrailService } from 'src/app/services/trail.service';

@Component({
  selector: 'app-trail-list',
  templateUrl: './trail-list.component.html',
  styleUrls: ['./trail-list.component.css']
})
export class TrailListComponent implements OnInit {

  constructor(private trailService: TrailService) { }

  ngOnInit(): void {
     this.reload()
  }
trails: Trail[] = [];

selected: Trail | null = null;
newTrail: Trail | null = new Trail();
editTrail: Trail | null = null;

displayTrail(trail: Trail): void {
  this.selected = trail;
}

displayTable(): void {
  this.selected = null;
}

reload(){
  this.trailService.index().subscribe({
    next: (data) => {
      this.trails = data;
    },
    error: (fail) => {
      console.error('TrailListComponent.reload: error getting trails');
      console.error(fail);
    }
  });
}

addTrail(trail: Trail) {
  this.trailService.create(trail).subscribe({
    next: (result: any) => {
      this.reload();
      this.newTrail = new Trail();

    },
    error: (nojoy: any) => {
      console.error('TrailListComponent.addTodo(): error creating trail');
      console.error(nojoy);
    },
  }
  )
}

setEditTrail(): void {
  this.editTrail = Object.assign({}, this.selected);
}

updateTrail(id: number, trail: Trail, goToDetail = true): void {
  // if (trail.completed){
  //   trail.completeDate = this.datePipe.transform(Date.now(), 'shortDate');
  //   }
  this.trailService.update(id, trail).subscribe({
    next: (data: any) => {
      if (goToDetail){
        this.selected = data;
      } else {
        this.selected = null;
      }
      this.reload();
     // this.selected = todo;
      this.editTrail = null;
    },
    error: (fail: any) => {
      console.error(
        'TrailListHttpComponent.updateTrail(): error updating trail:'
      );
      console.error(fail);
    },
  });
}

deleteTrail(trailId: number) {
  this.trailService.destroy(trailId).subscribe({
    next: (data: any) => {
      this.reload();
    },
    error: (fail: any) => {
      console.error('TodoListComponent.deleteTodo(): error deleting todo:');
      console.error(fail);
    },
  });
}

}

