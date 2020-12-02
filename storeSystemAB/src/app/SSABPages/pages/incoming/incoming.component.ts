import { formatDate } from '@angular/common';
import {Component, OnInit, ViewChild} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { IncomingData } from 'src/app/classes/incoming-data';
import { IntegrationService } from 'src/app/services/serviceIntegration/integration.service';
import { StoreDataService } from 'src/app/services/storage/store-data.service';
import { CustomService } from '../../../services/custom/custom.service';

@Component({
  selector: 'app-incoming',
  templateUrl: './incoming.component.html',
  styleUrls: ['./incoming.component.scss']
})
export class IncomingComponent implements OnInit {

  formGroup = new FormGroup({
    'codeGeneration': new FormControl('',[Validators.required]),
    'incomingCompany': new FormControl('',[Validators.required]),
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

    income: IncomingData = new IncomingData;
    date: Date | undefined;
    storeId: any;
  getIncomingDataToUIBean() {
    this.integration.getIncomingDataToUIBean(this.user.user.id, this.user.token).subscribe((IncomingData: any) => {
      if(IncomingData) {
        this.income = IncomingData;
        this.storeId = IncomingData.stores.id;
        console.log(this.storeId);
        this.date = new Date();
      }
    });
  }

  open(incoming: any) {
    this.modalService.open(incoming, { size: 'xl' });
    this.getIncomingDataToUIBean();
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
  ngOnInit(): void {
    this.token = this.store.getStoreElement('SSAB-t');
  }
  
  addIncoming() {
    if(this.lists.length > 0 && this.formGroup.get('incomingCompany')?.value && this.formGroup.get('codeGeneration')?.value) {
      this.formGroup.get('storeId')?.setValue(this.storeId);
      this.formGroup.get('listOfBillCategory')?.setValue(this.lists);
      this.formGroup.get('billType')?.setValue(1);
      console.log(this.formGroup.value);
      this.integration.addIncomingBill(this.formGroup.value, this.token).subscribe(status => {
        console.log(status);
        this.custom.notificationStatus_success_OR_info_OR_error('تم اضافة البيانات بنجاح' , 'أهلا' , 'success');
        this.resetAllFields();
        this.lists = [];
        this.modalService.dismissAll();
      });
    } else {
      this.custom.notificationStatus_success_OR_info_OR_error( 'يجب اداخل جميع الحقول المطلوبة','أهلا', 'info');
    }
  }

  resetAllFields() {
    this.resettableinputs();
    this.custom.resetComponentElement(this.formGroup);
  }

}
export class CategoryList {

  public category?: string;
  public quantity?: number;
  public notes?: string;
  public unit?: string;
  public categoryObj: any;

  constructor(category: string, quantity: number, notes: string, unit: string, categoryObj: any) {

    this.category = category;
    this.quantity = quantity;
    this.notes = notes;
    this.unit = unit;
    this.categoryObj = categoryObj;

  }

}