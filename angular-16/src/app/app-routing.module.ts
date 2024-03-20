import {Routes} from '@angular/router';

import {FullComponent} from './layouts/full/full.component';
import {LoginComponent} from "./pages/login/login.component";
import {ProfileComponent} from "./pages/profile/profile.component";

export const Approutes: Routes = [
  {
    path: '',
    component: FullComponent,
    children: [
      {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
      {
        path: 'profile',
        component: ProfileComponent,
      },
      {
        path: 'dashboard',
        loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule)
      },
      {
        path: 'about',
        loadChildren: () => import('./about/about.module').then(m => m.AboutModule)
      },
      {
        path: 'component',
        loadChildren: () => import('./component/component.module').then(m => m.ComponentsModule)
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '**',
    redirectTo: '/starter'
  }
];
