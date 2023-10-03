package com.meowu.commons.doamin.entity;

import java.util.Date;

public interface Updatable{

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
