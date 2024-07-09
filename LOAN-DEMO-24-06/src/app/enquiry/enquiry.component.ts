import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-enquiry',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, ReactiveFormsModule],
  templateUrl: './enquiry.component.html',
  styleUrl: './enquiry.component.css'
})
export class EnquiryComponent implements OnInit{
  EnquiryForm: FormGroup;
  EnquiryObj: any = {
    name: '',
    address: '',
    loanPurpose: '',
    loanAmount: '',
    email:'',
    phoneNumber:'',
    pancard:''
  };

  constructor(private fb: FormBuilder, private http: HttpClient, private router: Router) {
    this.EnquiryForm = this.fb.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      loanPurpose: ['', Validators.required],
      loanAmount: ['', [Validators.required, Validators.pattern(/^\d+(\.\d{1,2})?$/)]],
      email: ['', [Validators.required, Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      pancard: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  onEnquiry(): void {
    if (this.EnquiryForm.valid) {
      this.EnquiryObj = this.EnquiryForm.value;
      this.http.post("http://localhost:8080/api/enquiries", this.EnquiryObj, { observe: 'response' }).subscribe({
        next: (res: any) => {
          if (res.status === 200) {
            alert("Submitted successfully...");
            this.router.navigate(['/home']);
          }
        },
        error: (error: HttpErrorResponse) => {
          if (error.status === 400) {
            alert("Bad Request: Please check your input fields.");
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
    return this.EnquiryForm.controls;
  }
}