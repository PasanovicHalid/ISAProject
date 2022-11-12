export class Admin {
    name: string = '';
    surname: string = '';
    email: string = '';

    public constructor(obj?: any) {
        if (obj){
            this.name = obj.name;
            this.surname = obj.surname;
            this.email = obj.email;
        }
    }
}

