import { CourseService } from './../services/course.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class courseListComponent {
  public courses: any = [];
  constructor(private courseService: CourseService) { }

  ngOnInit() {
    this.courseService.getAllCourses().subscribe(data => this.courses = data);
  }

  deleteCourse(id){
    this.courseService.deleteCourse(id).subscribe(data => {
      if(data == true)
      {
        alert("Deleted");
        location.reload();
      }
      else
      {
        alert("Failed to delete");
      }
    });
  }

  subscribeCourse(){}

}