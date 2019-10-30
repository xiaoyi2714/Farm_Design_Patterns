package com.farm.memento;

import com.farm.*;

import java.util.ArrayList;
import java.util.List;

//用于备份田地FieldManager的list
public class FieldMemento {
    private List<Field> fieldList;
    //构造函数
    public FieldMemento(List<Field> copy) {
        fieldList=new ArrayList<Field>();
        for(int i=0;i<copy.size();i++){
            //不会出错
            Plant p=copy.get(i).getPlant();
            fieldList.add(i, new Field(i, p));
        }
    }
    //取得备份list
    public List<Field> getMementoFieldList()
    {
        return fieldList;
    }
}
