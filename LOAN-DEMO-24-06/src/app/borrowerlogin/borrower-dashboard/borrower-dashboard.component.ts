import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-borrower-dashboard',
  standalone: true,
  imports: [CommonModule,FormsModule, HttpClientModule],
  templateUrl: './borrower-dashboard.component.html',
  styleUrls: ['./borrower-dashboard.component.css']
})
export class BorrowerDashboardComponent {

  formObj: any = {
    fullName: "",
    dateOfBirth: null,
    gender: "",
    maritalStatus: "",
    emailAddress: "",
    phoneNumber: "",
    streetAddress: "",
    city: "",
    state: "",
    zipCode: "",
    panNumber: "",
    aadhaarNumber: "",
    employmentStatus: "",
    employerName: "",
    employerStreetAddress: "",
    employerCity: "",
    employerState: "",
    employerZipCode: "",
    jobTitle: "",
    annualIncome: null,
    workExperience: null,
    loanAmount: null,
    loanPurpose: "",
    loanTenure: null,
    bankName: "",
    accountNumber: "",
    ifscCode: ""
  };

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
    if (this.isValidForm()) {
      this.http.post("http://localhost:8080/api/loanApplications", this.formObj, { observe: 'response' }).subscribe({
        next: (res: any) => {
          if (res.status === 200) {
            alert("Applied successfully.......");
            this.router.navigate(['/home']);
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
    } else {
      alert("Please fill out all required fields correctly.");
    }
  }

  isValidForm() {
    // Add your form validation logic here
    // Check for required fields, valid email, phone number format, etc.
    return this.formObj.fullName &&
           this.formObj.dateOfBirth &&
           this.formObj.gender &&
           this.formObj.maritalStatus &&
           this.formObj.emailAddress &&
           this.formObj.phoneNumber &&
           this.formObj.streetAddress &&
           this.formObj.city &&
           this.formObj.state &&
           this.formObj.zipCode &&
           this.formObj.panNumber &&
           this.formObj.aadhaarNumber &&
           this.formObj.employmentStatus &&
           this.formObj.employerName &&
           this.formObj.employerStreetAddress &&
           this.formObj.employerCity &&
           this.formObj.employerState &&
           this.formObj.employerZipCode &&
           this.formObj.jobTitle &&
           this.formObj.annualIncome !== null &&
           this.formObj.workExperience !== null &&
           this.formObj.loanAmount !== null &&
           this.formObj.loanPurpose &&
           this.formObj.loanTenure !== null &&
           this.formObj.bankName &&
           this.formObj.accountNumber &&
           this.formObj.ifscCode;
  }

}
