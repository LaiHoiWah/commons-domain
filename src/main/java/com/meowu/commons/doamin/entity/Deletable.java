package com.meowu.commons.doamin.entity;

import java.util.Date;

public interface Deletable{

    Boolean getDelete();

    void setDelete(Boolean delete);

    Date getDeleteTime();

    void setDeleteTime(Date deleteTime);
}
