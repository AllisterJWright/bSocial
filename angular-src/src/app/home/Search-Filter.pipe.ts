import { PipeTransform, Pipe } from '@angular/core';
import { User } from '../User';

@Pipe({
    name:'SearchFilter'
})
export class SearchFilterPipe implements PipeTransform {
    transform(users : User[], searchText : string) : User[]{
        if (!users || !searchText){ return users;}
        
        return users.filter(User => User.username.toLocaleLowerCase().indexOf(searchText.toLowerCase()) !== -1);
    }
}
