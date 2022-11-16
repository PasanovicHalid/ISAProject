import { User } from '../edit-user/model/user';

export class Questionnaire {
  id: number = -1;
  user: User = new User();
  donated: boolean = false;
  public constructor(obj?: any) {
    //?? kaze da ako je undefined ili null onda daje
    //vrednost desno od ??
    //u sustini ako mu damo prazan konstruktor, on
    //ce objekat popuniti sa svim podacima desno od ??
    this.id = obj?.id ?? -1;
    this.user = obj?.user ?? new User();
    this.donated = obj?.donated ?? false;
  }
}
