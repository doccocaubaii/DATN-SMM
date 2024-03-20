import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SessionStorageService {

  constructor() {
  }

  // Lưu dữ liệu vào session storage
  setItem(key: string, value: any): void {
    sessionStorage.setItem(key, JSON.stringify(value));
  }

  // Lấy dữ liệu từ session storage
  getItem(key: string): any {
    const item = sessionStorage.getItem(key);
    return item ? JSON.parse(item) : null;
  }

  // Xóa dữ liệu từ session storage
  removeItem(key: string): void {
    sessionStorage.removeItem(key);
  }
}
