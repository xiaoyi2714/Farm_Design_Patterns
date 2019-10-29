package com.farm.memonto;

import com.farm.Field;

import java.util.List;

public class FieldMemento {
    private List<Field> fieldList;
    public FieldMemento(List<Field> copy) {
        fieldList=copy;
    }
    public List<Field> getMementoList()
    {
        return fieldList;
    }
}
