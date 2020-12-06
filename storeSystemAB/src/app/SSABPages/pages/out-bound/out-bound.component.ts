import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { IncomingData } from 'src/app/classes/incoming-data';
import { CustomService } from 'src/app/services/custom/custom.service';
import { IntegrationService } from 'src/app/services/serviceIntegration/integration.service';
import { StoreDataService } from 'src/app/services/storage/store-data.service';
import { CategoryList } from '../incoming/incoming.component';

@Component({
  selector: 'app-out-bound',
  templateUrl: './out-bound.component.html',
  styleUrls: ['./out-bound.component.scss']
})
export class OutBoundComponent implements OnInit {

  
  formGroup = new FormGroup({
    'codeGeneration': new FormControl('',[Validators.required]),
    'storeId': new FormControl('',[Validators.required]),
    'billType': new FormControl('',[Validators.required]),
    'project': new FormControl('',[Validators.required]),
    'bill': new FormControl('',[Validators.required]),
    'listOfBillCategory': new FormControl('')
    
  });

  tableFormGroup = new FormGroup({
    'quantity': new FormControl('',[Validators.required]),
    'notes': new FormControl(''),
    'category': new FormControl('',[Validators.required]),
  });

  closeResult = '';
  user: any;
  constructor(private modalService: NgbModal,
    private integration: IntegrationService,
    private store: StoreDataService,
    private custom: CustomService) {

      this.user = this.store.getStoreElement('SSAB-u');
    }

    outbound: IncomingData = new IncomingData;
    date: Date | undefined;
    storeId: any;
    getOutBoundDataToUIBean() {
    this.integration.getOutBoundDataToUIBean(this.user.user.id, this.user.token).subscribe((outboundData: any) => {
      if(outboundData) {
        this.outbound = outboundData;
        this.storeId = outboundData.stores.id;
        this.date = new Date();
      }
    }, error => {
      if(error) {
        this.custom.notificationStatus_success_OR_info_OR_error('حدث خطأ في النظام' , 'خطأ' , 'error');
      }
    });
  }

  open(incoming: any) {
    this.modalService.open(incoming, { size: 'xl' });
    this.getOutBoundDataToUIBean();
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  categoryList: CategoryList | undefined;
  selectedName: any;
  categoryName: any;
  lists =[] as Array<CategoryList>;
  unit: any;
  selectOption() {
    this.categoryName = this.selectedName.decription;
    this.unit = this.selectedName.unit.decription;
  }
  
  addCategories() {
    if(this.tableFormGroup.get('quantity')?.value &&
    this.tableFormGroup.get('category')?.value) {

      const newRow = new CategoryList(this.categoryName,this.tableFormGroup.get('quantity')?.value,
      this.tableFormGroup.get('notes')?.value,this.unit, this.tableFormGroup.get('category')?.value);
      this.lists.push(newRow);
      this.resettableinputs();
    } else {
      this.custom.notificationStatus_success_OR_info_OR_error( 'يجب اداخل جميع الحقول المطلوبة','أهلا', 'info');
    }
  }

  resettableinputs() {
    this.tableFormGroup.get('category')?.setValue(null);
    this.tableFormGroup.get('quantity')?.setValue(null);
    this.tableFormGroup.get('notes')?.setValue(null);
  }

  removeDTRow(index: any) {
    this.lists.splice(index,1);
  }

  rowToUpdate: any;
  getTDToUpdate(index: any) {
    this.rowToUpdate = this.lists[index];
    this.tableFormGroup.get('category')?.setValue(this.rowToUpdate.categoryObj);
    this.tableFormGroup.get('quantity')?.setValue(this.rowToUpdate.quantity);
    this.tableFormGroup.get('notes')?.setValue(this.rowToUpdate.notes);
    this.lists.splice(index,1);
  }
  token: any;
  bill: any;
  ngOnInit(): void {
    this.token = this.store.getStoreElement('SSAB-t');
    this.getListOfBills();
  }

  getListOfBills() {
    this.integration.getListOfBills(this.token).subscribe((bills: any) => {
      if(bills) {
        this.bill = bills;
        this.store.storeElementWthoutSecret('SSAB-i-l', this.bill.length);
      }
    },error => {
      if(error) {
        this.custom.notificationStatus_success_OR_info_OR_error('حدث خطأ في النظام' , 'خطأ' , 'error');
      }
    });
  }

  billProductList: any;
  getIncomToDetails(index: number) {
    this.rowToUpdate = this.bill[index];
    this.integration.getBillProductByBillId(this.token, this.rowToUpdate.id).subscribe(billProducts => {
      if(billProducts) {
        this.billProductList = billProducts;
      }
    });
  }
  
  addIncoming() {
    if(this.lists.length > 0 && this.formGroup.get('incomingCompany')?.value && this.formGroup.get('codeGeneration')?.value) {
      this.formGroup.get('storeId')?.setValue(this.storeId);
      this.formGroup.get('listOfBillCategory')?.setValue(this.lists);
      this.formGroup.get('billType')?.setValue(1);
      this.integration.addIncomingBill(this.formGroup.value, this.token).subscribe(status => {
        this.custom.notificationStatus_success_OR_info_OR_error('تم اضافة البيانات بنجاح' , 'أهلا' , 'success');
        this.resetAllFields();
        this.lists = [];
        this.modalService.dismissAll();
        this.getListOfBills();
      }, error => {
        this.custom.notificationStatus_success_OR_info_OR_error('حدث خطا عند اضافة البيانات' , 'خطأ' , 'error');
      });
    } else {
      this.custom.notificationStatus_success_OR_info_OR_error( 'يجب اداخل جميع الحقول المطلوبة','أهلا', 'info');
    }
  }

  resetAllFields() {
    this.resettableinputs();
    this.custom.resetComponentElement(this.formGroup);
  }

  openDetails(incomingDetails: any, index: number) {
    this.modalService.open(incomingDetails, { size: 'xl' });
    this.getIncomToDetails(index);
  }

  private getDismissReasonDetails(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
