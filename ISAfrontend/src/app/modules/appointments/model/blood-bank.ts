export class BloodBank {
    name: string
    address: string
    rating: number

    public constructor(obj?: any) {
        this.name = obj?.name ?? "";
        this.address = obj?.address ?? '';
        this.rating = obj?.rating ?? -1;
    }
}
