import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-details',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.css'
})
export class UserDetailsComponent implements OnInit{
// Array to hold loan applications
loanApplication: any;

constructor(private http: HttpClient, private route: ActivatedRoute) {}

ngOnInit(): void {
  // Get the ID from the route parameters and fetch the loan application details
  const id = this.route.snapshot.paramMap.get('id');
  if (id) {
    this.fetchLoanApplicationById(id);
  }
}

fetchLoanApplicationById(id: string): void {
  this.http.get<any>(`http://localhost:8080/api/loanApplications/${id}`).subscribe({
    next: (data) => {
      this.loanApplication = data; // Assign fetched data to loanApplication
    },
    error: (error: HttpErrorResponse) => {
      console.error('Error fetching loan application:', error);
      // Handle error fetching loan application
    }
  });
}

  printDetails(): void {
    window.print();
  }

}
