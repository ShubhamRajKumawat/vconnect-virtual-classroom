import { Course } from './../models/Course';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }
  getAllCourses(){
    return this.http.get("http://localhost:8080/course/");
  }

  getCourse(id){
    return this.http.get<Course>("http://localhost:8080/course/" + id);
  }

  saveCourse(course){
    return this.http.post("http://localhost:8080/course/", course);
  }

  deleteCourse(id){
    return this.http.delete("http://localhost:8080/course/" + id);
  }
}
