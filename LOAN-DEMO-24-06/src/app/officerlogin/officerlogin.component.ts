import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-officerlogin',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './officerlogin.component.html',
  styleUrl: './officerlogin.component.css'
})
export class OfficerloginComponent {
  loginObj:any={
    "username":"",
    "password":""
  };
  constructor(private http: HttpClient, private router: Router) {}

  onLogin() {
    this.http.post("http://localhost:8080/loanofficer/login", this.loginObj, { observe: 'response' }).subscribe({
      next: (res: any) => {
        if (res.status === 200) {
          alert("Login sucesssssss");
          this.router.navigate(['/officer-dashboard']);
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
