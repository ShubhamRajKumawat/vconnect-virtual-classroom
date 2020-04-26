import { EditCourseComponent } from './edit-course/edit-course.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { courseListComponent } from './course-list/course-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {path : '', component : courseListComponent},
  {path : 'course/add', component : AddCourseComponent},
  {path : 'course/edit/:id', component : EditCourseComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
