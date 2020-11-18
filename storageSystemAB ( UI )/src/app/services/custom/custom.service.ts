import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CustomService {
  constructor() {}

  checkEmail(email: string) {
    let newEmail = email.split('@')[0];

    return newEmail + '@gmail.com';
  }

  _success = new Subject<string>();
  _type = new Subject<string>();
  _face = new Subject<string>();

  changeSuccessMessage(message: string, type: string, face: string) {
    this._success.next(message);
    this._type.next(type);
    this._face.next(face);
  }

  resetComponentElement(formGroup: any) {
    Object.keys(formGroup.controls).forEach((key: string) => {
      formGroup.get(key).reset();
    });
  }

  // no special chars ...
  noSpecialChars(value: string): boolean {
    const regexPattern = new RegExp(
      /[~`!#$%\^/&*()+=@.\-\[\]\\';,{}|\\":<>\?]/g
    ); //unacceptable chars
    if (regexPattern.test(value)) {
      return true;
    }
    return false;
  }


}
