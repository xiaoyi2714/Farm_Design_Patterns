package com.farm.memonto;

import com.farm.Field;

import java.util.List;

public class FieldMementoManager {
    private List<FieldMemento> list;
    private static FieldMementoManager instance;
    public static FieldMementoManager getInstance(){
        if (instance==null){
            instance=new FieldMementoManager();
        }
        return instance;
    }

    public FieldMemento getMemento(int index) {
        if (index>=0 && index<list.size()) {
            return list.get(index);
        }
        else return null;
    }

    public FieldMemento getMemento() {
        if (list.size()!=0)
            return list.get(list.size()-1);
        else return null;
    }

    public int addMemento(FieldMemento newMemento) {
        if (newMemento==null) return -1;

        if (list.add(newMemento)) {
            return list.size()-1;
        }
        else return -1;
    }
    public void showAllMementos()
    {

    }
}
