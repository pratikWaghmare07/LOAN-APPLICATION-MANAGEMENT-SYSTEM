import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  registerObj: any = {
    name: '',
    username: '',
    password: '',
    phoneNumber: ''
  };

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [
        Validators.required,
        Validators.pattern(/^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)
      ]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]]
    });
  }

  ngOnInit(): void {}

  onRegister(): void {
    if (this.registerForm.valid) {
      this.registerObj = this.registerForm.value;
      this.http.post("http://localhost:8080/api/users/register", this.registerObj, { observe: 'response' }).subscribe({
        next: (res: any) => {
          if (res.status === 200) {
            alert("Registered successfully...");
            this.router.navigate(['/login']);
          }
        },
        error: (error: HttpErrorResponse) => {
          if (error.status === 400) {
            alert("Username already in use.");
          } else if (error.status === 401) {
            alert("Unauthorized: Invalid credentials");
          } else {
            alert("An error occurred: " + error.message);
          }
        }
      });
    } else {
      alert("Please fill in all required fields correctly.");
    }
  }

  

  // Getter for easier access to form controls in the template
  get formControls() {
    return this.registerForm.controls;
  }
}
