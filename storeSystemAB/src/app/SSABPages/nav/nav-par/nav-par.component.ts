import { Component, OnInit } from '@angular/core';
import { StoreDataService } from 'src/app/services/storage/store-data.service';

@Component({
  selector: 'app-nav-par',
  templateUrl: './nav-par.component.html',
  styleUrls: ['./nav-par.component.scss']
})
export class NavParComponent implements OnInit {

  constructor(private store: StoreDataService) { }

  incomingBillLength: any;
  ngOnInit(): void {
    this.incomingBillLength = this.store.getElementWthoutSecret('SSAB-i-l');
  }

}
