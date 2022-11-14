import { User } from "./user";

export class Customer extends User {
    public constructor(obj?: any) {
        super(obj?.user);
    }
}
