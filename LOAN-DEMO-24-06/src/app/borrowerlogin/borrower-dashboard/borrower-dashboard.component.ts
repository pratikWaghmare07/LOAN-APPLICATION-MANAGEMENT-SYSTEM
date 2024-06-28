import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-borrower-dashboard',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './borrower-dashboard.component.html',
  styleUrl: './borrower-dashboard.component.css'
})
export class BorrowerDashboardComponent {

  formObj: any = {
    fullName: "",
    dateOfBirth: null, // assuming you'll handle dates appropriately
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
  }

}
