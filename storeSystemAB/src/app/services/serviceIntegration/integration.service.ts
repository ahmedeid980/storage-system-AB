import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IntegrationService {

  constructor(private http: HttpClient) { }

  URI = 'http://localhost:7172';
  URLIntegration = 'http://localhost:7172';

  login(loginRequest: any) { // loginRequest
    const headerDict = {
      'content-type': 'application/json; charset=utf-8'
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.post(this.URI+'/storageSystem/userlogin', loginRequest, requestOptions);
  }

  // register admin user
  reigsterUserAdmin(user: any, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.post(this.URI+'registerUserAdmin', user, requestOptions);
  }

  getIncomingDataToUIBean(userId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/storageSystem/userlogin/getIncomingDataToUIBean/'+userId, requestOptions);
  }

  addIncomingBill(bill: any, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    // const a = [bill];
    return this.http.post(this.URI+'/bill/addIncoming/',bill , requestOptions);
  }

  getListOfBills(billType: number, storeId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/bill/billsByBillType/'+billType+'/'+storeId, requestOptions);
  }

  getBillProductByBillId(token: string, billId: number) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/bill/getBillProductByBillId/'+billId+'/', requestOptions);
  }

  getOutBoundDataToUIBean(userId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/storageSystem/userlogin/getOutBoundDataToUIBean/'+userId, requestOptions);
  }

  checkAvilability(categoryId: number, storeId: number,quantity: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/category/checkAvilability/'+categoryId+'/'+storeId+'/'+quantity, requestOptions);
  }

  addOutboundBill(bill: any, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    // const a = [bill];
    return this.http.post(this.URI+'/bill/addOutbound/',bill , requestOptions);
  }

  getTransterDataToUIBean(userId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/storageSystem/userlogin/getTransterDataToUIBean/'+userId, requestOptions);
  }

  addTransferBill(bill: any, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    // const a = [bill];
    return this.http.post(this.URI+'/bill/addTransfer/',bill , requestOptions);
  }

  getStoreByUserId(userId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };

    return this.http.get(this.URI+'/store/getStoreByUserId/'+userId, requestOptions);
  }

  getBouncedBackDataToUIBean(userId: number, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.get(this.URI+'/storageSystem/userlogin/getBouncedBackDataToUIBean/'+userId, requestOptions);
  }

  addBouncedBackBill(bill: any, token: string) {
    const headerDict = {
      'Authorization': 'ahmbas '+token
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    // const a = [bill];
    return this.http.post(this.URI+'/bill/addBouncedBack/',bill , requestOptions);
  }
}
