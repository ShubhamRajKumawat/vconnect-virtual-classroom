import { CourseService } from './services/course.service';
import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { courseListComponent } from './course-list/course-list.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddCourseComponent } from './add-course/add-course.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { EditCourseComponent } from './edit-course/edit-course.component';


@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    courseListComponent,
    CourseDetailsComponent,
    AddCourseComponent,
    AddCategoryComponent,
    EditCourseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [CourseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
