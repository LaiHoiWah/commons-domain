package com.meowu.commons.doamin.entity;

import com.meowu.commons.doamin.utils.GsonUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Identity<T>{

    private T id;

    @Override
    public boolean equals(Object compare){
        if(this == compare){
            return true;
        }
        if(compare == null){
            return false;
        }
        if(this.getClass() != compare.getClass()){
            return false;
        }

        Identity convert = (Identity) compare;
        return (this.id != null && this.id.equals(convert.id));
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public String toString(){
        return GsonUtils.toJson(this);
    }
}
