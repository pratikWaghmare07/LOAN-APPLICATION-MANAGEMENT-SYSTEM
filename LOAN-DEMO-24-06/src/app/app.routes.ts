import { Route } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { BlogComponent } from './blog/blog.component';
import { ServicesComponent } from './services/services.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BorrowerloginComponent } from './borrowerlogin/borrowerlogin.component';
import { OfficerloginComponent } from './officerlogin/officerlogin.component';
import { BorrowerDashboardComponent } from './borrowerlogin/borrower-dashboard/borrower-dashboard.component';
import { OfficerDashboardComponent } from './officerlogin/officer-dashboard/officer-dashboard.component';
import { UserDetailsComponent } from './officerlogin/user-details/user-details.component';
import { EnquiryComponent } from './enquiry/enquiry.component';

export const APP_ROUTE: Route[] = [
  // {path:'',component:MenuComponent,loadChildren: ()=>import('./Menu/menu.route')}

  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'services', component: ServicesComponent },
  { path: 'blog', component: BlogComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'login', component: LoginComponent },
  { path: 'borrowerlogin', component: BorrowerloginComponent },
  { path: 'borrower-dashboard', component: BorrowerDashboardComponent },
  { path: 'officerlogin', component: OfficerloginComponent },
  { path: 'borrower', component: BorrowerloginComponent },
  { path: 'officer', component: OfficerloginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'officer-dashboard', component: OfficerDashboardComponent },
  { path: 'user-details/:id', component: UserDetailsComponent },
  { path: 'enquiry', component: EnquiryComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
  
];
