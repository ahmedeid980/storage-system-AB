import { formatDate } from '@angular/common';
import {Component, OnInit, ViewChild} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { IncomingData } from 'src/app/classes/incoming-data';
import { IntegrationService } from 'src/app/services/serviceIntegration/integration.service';
import { StoreDataService } from 'src/app/services/storage/store-data.service';

@Component({
  selector: 'app-incoming',
  templateUrl: './incoming.component.html',
  styleUrls: ['./incoming.component.scss']
})
export class IncomingComponent implements OnInit {

  formGroup = new FormGroup({
    'codeGeneration': new FormControl('',[Validators.required]),
    'incomingCompany': new FormControl('',[Validators.required]),
    'store': new FormControl('',[Validators.required]),
    'billType': new FormControl('',[Validators.required]),
    'project': new FormControl('',[Validators.required]),
    'quantity': new FormControl('',[Validators.required]),
    'notes': new FormControl(''),
    'category': new FormControl('',[Validators.required]),
    'bill': new FormControl('',[Validators.required])
    
  });

  closeResult = '';
  user: any;
  constructor(private modalService: NgbModal,
    private integration: IntegrationService,
    private store: StoreDataService) {

      this.user = this.store.getStoreElement('SSAB-u');
    }

    income: IncomingData = new IncomingData;
    date: Date | undefined;
  getIncomingDataToUIBean() {
    this.integration.getIncomingDataToUIBean(this.user.user.id, this.user.token).subscribe((IncomingData: any) => {
      if(IncomingData) {
        this.income = IncomingData;
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
    if(this.formGroup.get('quantity')?.value &&
    this.formGroup.get('category')?.value) {

      const newRow = new CategoryList(this.categoryName,this.formGroup.get('quantity')?.value,
      this.formGroup.get('notes')?.value,this.unit, this.formGroup.get('category')?.value);
      this.lists.push(newRow);
      this.resettableinputs();
    } else {
      alert('يجب اداخل جميع الحقول المطلوبة');
    }
  }

  resettableinputs() {
    this.formGroup.get('category')?.setValue(null);
    this.formGroup.get('quantity')?.setValue(null);
    this.formGroup.get('notes')?.setValue(null);
  }

  removeDTRow(index: any) {
    this.lists.splice(index,1);
  }

  rowToUpdate: any;
  getTDToUpdate(index: any) {
    this.rowToUpdate = this.lists[index];
    this.formGroup.get('category')?.setValue(this.rowToUpdate.categoryObj);
    this.formGroup.get('quantity')?.setValue(this.rowToUpdate.quantity);
    this.formGroup.get('notes')?.setValue(this.rowToUpdate.notes);
    this.lists.splice(index,1);
  }

  ngOnInit(): void {
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