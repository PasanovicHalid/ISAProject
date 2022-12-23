export class Questionnaire {
    id: string = "-1";
    customerId : string = "-1";
    donated: boolean;
    denied: boolean;
    healthy: boolean;
    eaten: boolean;
    dangerousJob: boolean;
    takingMedicine: boolean;
    secondState: boolean;
    menstruating: boolean;
    pregnant: boolean;
    donorNumber: string = '';
    fillDate: Date = new Date();

    public constructor(obj?: any) {
        this.id = obj?.id ?? "-1";
        this.customerId = obj?.customerId ?? "-1";
        this.donated = obj?.donated
        this.denied = obj?.denied
        this.healthy = obj?.healthy
        this.eaten = obj?.eaten
        this.dangerousJob = obj?.dangerousJob
        this.takingMedicine = obj?.takingMedicine
        this.secondState = obj?.secondState
        this.menstruating = obj?.menstruating
        this.pregnant = obj?.pregnant
        this.donorNumber = obj?.donorNumber ?? '';
        this.fillDate = obj?.fillDate ?? new Date();
    }
}
