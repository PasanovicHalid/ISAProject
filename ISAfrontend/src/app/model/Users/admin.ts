import { User } from "./user";
import { BloodBank } from "../blood-bank.model";
import { Role } from "./role";
import {Address} from "../address.model"

export class Admin extends User {
    bloodBank: BloodBank = new BloodBank;
    public constructor(obj?: any) {
        super(obj.user);
        this.role = Role.ADMIN;
        this.bloodBank = obj.bloodBank;
    }
}
