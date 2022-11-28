import { DataSource } from '@angular/cdk/table';
import { CollectionViewer } from '@angular/cdk/collections';
import { Observable, BehaviorSubject, of } from "rxjs";
import { catchError, finalize } from "rxjs/operators";
import { BloodBank } from 'src/app/model/blood-bank.model';
import { BloodBankService } from '../services/blood-bank.service';
import { PagableRequest } from '../model/pagable-request';

export class BloodBankSource implements DataSource<BloodBank> {

    private bloodBankSubject = new BehaviorSubject<BloodBank[]>([]);
    private loadingSubject = new BehaviorSubject<boolean>(false);

    public loading$ = this.loadingSubject.asObservable();

    constructor(private bloodBankService: BloodBankService) { }


    connect(collectionViewer: CollectionViewer): Observable<readonly BloodBank[]> {
        return this.bloodBankSubject.asObservable()
    }
    
    disconnect(collectionViewer: CollectionViewer): void {
        this.bloodBankSubject.complete();
        this.loadingSubject.complete();
    }

    loadBloodBanks(request: PagableRequest = new PagableRequest()) {
        this.loadingSubject.next(true)
        this.bloodBankService.getBloodBanksPagable(request)
          .pipe(
            catchError(() => of([])),
            finalize(() => this.loadingSubject.next(false))
          )
          .subscribe((result: BloodBank[]) => {
            this.bloodBankSubject.next(result);
        })
    }
}
