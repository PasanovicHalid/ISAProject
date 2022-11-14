import { User } from "./user";
import { Role } from "./role";

export class HeadAdmin extends User {
    public constructor(obj?: any) {
        super(obj?.user);
        this.role = Role.HEADADMIN;
    }
}
