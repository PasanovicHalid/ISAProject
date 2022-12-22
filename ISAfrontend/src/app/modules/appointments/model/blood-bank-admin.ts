export class BloodBankAdmin {
    id : number
    startDayWorkTime: string
    endDayWorkTime: string
    numberOfWorkingDaysInWeek: number
  bankID: number;

    public constructor(obj?: any) {
        this.id = obj?.id ?? -1;
        this.startDayWorkTime = obj?.startDayWorkTime ?? "";
        this.endDayWorkTime = obj?.endDayWorkTime ?? '';
        this.numberOfWorkingDaysInWeek = obj?.numberOfWorkingDaysInWeek ?? -1;
    }
}
