import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-officer-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './officer-dashboard.component.html',
  styleUrls: ['./officer-dashboard.component.css']
})
export class OfficerDashboardComponent implements OnInit {

  loanApplications: any[] = []; // Initialize as an empty array


  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    // Call method to fetch loan applications when component initializes
    this.fetchLoanApplications();
  }

  fetchLoanApplications(): void {
    // Replace with your API endpoint
    this.http.get<any[]>('http://localhost:8080/api/loanApplications').subscribe({
      next: (data) => {
        this.loanApplications = data; // Assign fetched data to loanApplications
      },
      error: (error: HttpErrorResponse) => {
        console.error('Error fetching loan applications:', error);
        // Handle error fetching loan applications
      }
    });
  }

  viewUserDetails(id: string): void {
    this.router.navigate(['/user-details', id]);
  }

}
