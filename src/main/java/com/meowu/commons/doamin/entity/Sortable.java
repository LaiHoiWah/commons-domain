package com.meowu.commons.doamin.entity;

public interface Sortable extends Comparable<Sortable>{

    Long getSequence();

    void setSequence(Long sequence);

    @Override
    default int compareTo(Sortable compareTo){
        return desc(compareTo);
    }

    default int asc(Sortable compareTo){
        if(getSequence() == compareTo.getSequence()){
            return 0;
        }

        if(getSequence() != null){
            if(compareTo.getSequence() == null){
                return -1;
            }else if(getSequence().equals(compareTo.getSequence())){
                return 0;
            }else if(getSequence() > compareTo.getSequence()){
                return 1;
            }else if(getSequence() < compareTo.getSequence()){
                return -1;
            }
        }

        return 1;
    }

    default int desc(Sortable compareTo){
        if(getSequence() == compareTo.getSequence()){
            return 0;
        }

        if(getSequence() != null){
            if(compareTo.getSequence() == null){
                return -1;
            }else if(getSequence().equals(compareTo.getSequence())){
                return 0;
            }else if(getSequence() > compareTo.getSequence()){
                return -1;
            }else if(getSequence() < compareTo.getSequence()){
                return 1;
            }
        }

        return 1;
    }
}
