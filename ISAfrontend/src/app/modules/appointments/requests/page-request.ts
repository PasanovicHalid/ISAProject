export class PageRequest {
    startDate: string;
    startTime: string;
    sortColumn: string;
    sortDirection: string;
    pageIndex: number
    pageSize: number

    public constructor(obj?: any) {
        this.startDate = obj?.startDate ?? "";
        this.startTime = obj?.startTime ?? "";
        this.sortDirection = obj?.sortDirection ?? "";
        this.sortColumn = obj?.sortColumn ?? "";
        this.pageIndex = obj?.pageIndex ?? 0;
        this.pageSize = obj?.pageSize ?? 5;
    }
}
