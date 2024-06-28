import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
   
  registerObj:any={
    "name":"",
    "username":"",
    "password":"",
    "phoneNumber":""

  };
  constructor(private http: HttpClient, private router: Router) {}

  onRegister() {
    this.http.post("http://localhost:8080/api/users/register", this.registerObj, { observe: 'response' }).subscribe({
      next: (res: any) => {
        if (res.status === 200) {
          alert("Registered successfully...");
          this.router.navigate(['/login']);
        }
      },
      error: (error: HttpErrorResponse) => {
        if (error.status === 401) {
          alert("Invalid credentials");
        } else {
          alert("An error occurred: " + error.message);
        }
      }
    });
  }

}