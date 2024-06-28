import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  selectedRole: string = '';

  constructor(private router: Router) {}

  onLogin() {
    if (this.selectedRole === 'borrower') {
      this.router.navigate(['/borrower']);
    } else if (this.selectedRole === 'officer') {
      this.router.navigate(['/officer']);
    }
  }
}
