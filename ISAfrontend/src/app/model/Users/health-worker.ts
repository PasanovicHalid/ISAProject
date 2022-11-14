import { User } from "./user";

export class HealthWorker extends User {
    public constructor(obj?: any) {
        super(obj?.user);
    }
}
