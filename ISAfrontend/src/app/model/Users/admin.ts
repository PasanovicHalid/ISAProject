import { User } from "./user";

export class Admin extends User {
    bloodBankID: number = -1;
    public constructor(obj?: any) {
        super(obj.user);
        this.bloodBankID = obj.bloodBankID;
    }
}
