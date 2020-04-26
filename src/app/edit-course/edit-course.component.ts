import { Component, OnInit } from '@angular/core';
import { Course } from '../models/Course';
import { CourseService } from '../services/course.service';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/Category';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-course',
  templateUrl: './edit-course.component.html',
  styleUrls: ['./edit-course.component.css']
})
export class EditCourseComponent implements OnInit {

  public id;
  public courseName: string;
  public courseInstructorName: string;
  public courseDuration;
  public courseRating;
  public coursePrice;
  public course : Course;
  public category;
  public categories;

  constructor(private courseService:CourseService, private categoryService:CategoryService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;
    this.categoryService.getAllCategory().subscribe(data => this.categories = data);
    this.courseService.getCourse(this.id).subscribe(data => {
      this.course = data;
      this.courseName = this.course.name;
      this.courseInstructorName = this.course.instructorName;
      this.courseDuration = this.course.duration;
      this.courseRating = this.course.rating;
      this.coursePrice = this.course.price;
      this.category = this.course.catagory.id;
    });
  }

  save(){
    this.course = new Course();
    this.course.id = this.id;
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
        alert("Successfully Updated");
      }
      else
        alert("Failed to update");
    });
    
  }
}