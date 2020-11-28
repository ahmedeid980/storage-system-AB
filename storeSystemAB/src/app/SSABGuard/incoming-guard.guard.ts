import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { StoreDataService } from '../services/storage/store-data.service';
import { UserService } from '../services/user/user.service';

@Injectable({
  providedIn: 'root'
})
export class IncomingGuardGuard implements CanActivate {

  constructor(private userService: UserService,
    private store: StoreDataService,
    private router: Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if(this.userService.userStatus) {
        return true;
      } else {
        const userStatus_u = this.store.getElementWthoutSecret('SSAB-u-s');
        if(userStatus_u) {
          return true;
        }
      }
      this.router.navigate(['/login']);
      return false;
    }
}
