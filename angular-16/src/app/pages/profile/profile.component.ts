import {Component, OnInit} from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {ProfileService} from "./profile.service";
import {SessionStorageService} from "../../service/SessionStorageService";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  years: number[] = [];

  infoAccout = {
    fullname: '',
    gender: 'MALE',
    accountNumber: '',
    balance: 0,
    role: 'SALE'
  }

  constructor(private toastr: ToastrService,
              private profileService: ProfileService,
              private sessionStorage: SessionStorageService,
  ) {
  }

  ngOnInit(): void {
    this.getProfile();
  }

  getProfile() {
    this.profileService.getInfo().subscribe(
      res => {
        this.infoAccout = res.data;
        this.infoAccout.balance = this.sessionStorage.getItem('principle').balance;
      }
    )
  }

  save() {
    if (this.validate()) {
      this.profileService.editInfo(this.infoAccout).subscribe(
        res => {
          this.toastr.success(res.message);
        }
      )
    }
  }

  validate(): boolean {
    if (!this.infoAccout.fullname) {
      this.toastr.error("Full name is required");
      return false;
    }
    if (!this.infoAccout.accountNumber) {
      this.toastr.error("Account number is required");
      return false;
    }
    return true;
  }
}
