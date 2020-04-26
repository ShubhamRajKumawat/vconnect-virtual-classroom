import { CategoryService } from './../services/category.service';
import { CourseService } from './../services/course.service';
import { Course } from '../models/Course';
import { Component, OnInit } from '@angular/core';
import { Category } from '../models/Category';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  public courseName: string;
  public courseInstructorName: string;
  public courseDuration;
  public courseRating;
  public coursePrice;
  public course : Course;
  public category;
  public categories;

  constructor(private courseService:CourseService, private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.categoryService.getAllCategory().subscribe(data => this.categories = data);
  }

  save(){
    this.course = new Course();
    this.course.name = this.courseName;
    this.course.instructorName = this.courseInstructorName;
    this.course.duration = this.courseDuration;
    this.course.rating = this.courseRating;
    this.course.price = this.coursePrice;
    this.course.catagory = new Category();
    this.course.catagory.id = this.category;
    console.log(this.course);
    let flag;
    this.courseService.saveCourse(this.course).subscribe(data=>{
      if( data == true){
        alert("Successfully Added");
        location.reload();
      }
      else
        alert("Failed to add");
    });
    
  }

}
