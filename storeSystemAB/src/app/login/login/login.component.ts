import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CustomService } from 'src/app/services/custom/custom.service';
import { IntegrationService } from 'src/app/services/serviceIntegration/integration.service';
import { StoreDataService } from 'src/app/services/storage/store-data.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss', 'util.css']
})
export class LoginComponent implements OnInit {

  constructor(private integration: IntegrationService, 
    private userService: UserService,
    private router: Router,
    private custom: CustomService,
    private store: StoreDataService) { }

  formGroup = new FormGroup( {
    'username': new FormControl("", [Validators.required]),
    'password': new FormControl("", [Validators.required]),
  });

  user: any;
  message: string | undefined;
  login() {
    if(this.formGroup.valid) {
      this.integration.login(this.formGroup.value).subscribe( (userLogin: any) => {
        this.userService.changeUserStatus(userLogin);
        this.user = userLogin;
        this.userService.userStatus = true;
        
        if (userLogin) {
          this.router.navigate(['/incoming']);
          this.store.storeElementWthoutSecret('SSAB-u-s',this.userService.userStatus);
          this.store.storeElement('SSAB-u',userLogin);
        } 
      }, (error) => {
        this.message = 'خطأ في اسم المستخدم او كلمة المرور';
      });
    }
  }

  ngOnInit(): void {
  }

}
