import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-borrowerlogin',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './borrowerlogin.component.html',
  styleUrl: './borrowerlogin.component.css',
})
export class BorrowerloginComponent {

  loginObj:any={
    "username":"",
    "password":""
  };
  constructor(private http: HttpClient, private router: Router) {}

  onLogin() {
    this.http.post("http://localhost:8080/api/users/login", this.loginObj, { observe: 'response' }).subscribe({
      next: (res: any) => {
        if (res.status === 200) {
          this.router.navigate(['/borrower-dashboard']);
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
