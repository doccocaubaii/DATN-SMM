import {Component} from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";
import {SessionStorageService} from "../../service/SessionStorageService";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginDto: any = {
    username: '',
    email: '',
    password: '',
    role: 'SALE'
  }


  constructor(private toast: ToastrService,
              private loginService: LoginService,
              private sessionService: SessionStorageService,
              private router: Router) {
  }


  signIn(): void {
    if (this.validate()) {
      this.loginService.signIn(this.loginDto).subscribe(
        res => {
          // this.toast.success(res.message);
          this.sessionService.setItem('principle', res.data);
          this.router.navigate(['/dashboard']);
        }
      );
    }
  }

  validate(): boolean {
    if (!this.loginDto.username) {
      this.toast.error("Username không được để trống");
      return false;
    }

    if (this.loginDto.username.length > 30 || this.loginDto.username.length < 4) {
      this.toast.error("Username phải từ 4-30 ký tự");
      return false;
    }

    if (!this.loginDto.password) {
      this.toast.error("Password không được để trống");
      return false;
    }

    if (this.loginDto.password.length > 30 || this.loginDto.password.length < 4) {
      this.toast.error("Password phải từ 4-30 ký tự");
      return false;
    }
    return true;
  }

  signUp() {
    if (this.validate()) {
      this.loginService.signUp(this.loginDto).subscribe(
        (res) => {
          sessionStorage.setItem('principle', res.data);
          this.toast.success(res.message);
        }
      );
    }
  }
}
