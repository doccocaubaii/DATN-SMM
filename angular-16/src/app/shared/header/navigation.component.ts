import {AfterViewInit, Component, EventEmitter, Output} from '@angular/core';
import {NgbDropdownModule, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {SessionStorageService} from "../../service/SessionStorageService";
import {Router} from "@angular/router";

declare var $: any;

@Component({
  selector: 'app-navigation',
  standalone: true,
  imports: [NgbDropdownModule],
  templateUrl: './navigation.component.html'
})
export class NavigationComponent implements AfterViewInit {
  @Output() toggleSidebar = new EventEmitter<void>();

  constructor(private modalService: NgbModal,
              private router: Router,
              private sessionService: SessionStorageService) {
  }

  ngAfterViewInit() {
  }

  logout() {
    this.sessionService.clear();
    this.router.navigate(["/login"]);
  }
}
