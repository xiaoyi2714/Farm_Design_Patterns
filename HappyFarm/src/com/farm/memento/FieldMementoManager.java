package com.farm.memento;

import com.farm.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.*;
import java.util.ListIterator;

public class FieldMementoManager {
    private List<FieldMemento> list;
    private static FieldMementoManager instance;
    //私有构造函数
    private FieldMementoManager(){
        list = new ArrayList<FieldMemento>();
    }
    //单实例
    public static FieldMementoManager getInstance(){
        if (instance==null){
            instance=new FieldMementoManager();
        }
        return instance;
    }
    //取得第index个备忘录实例
    public FieldMemento getMemento(int index) {
        if (index>=0 && index<list.size()) {
            return list.get(index);
        }
        else return null;
    }
    //重载，取得最后一个备忘录
    public FieldMemento getMemento() {
        if (list.size()!=0)
            return list.get(list.size()-1);
        else return null;
    }
    //添加备忘录
    public int addMemento(FieldMemento newMemento) {
        if (newMemento==null) return -1;

        if (list.add(newMemento)) {
            return list.size()-1;
        }
        else return -1;
    }
    //展示所有备忘录
    public void showAllMementos()
    {
        System.out.println();
        System.out.println();
        System.out.println("Start to show all mementos.");
        int n = list.size();
        if (n==0){
            System.out.println("Empty set.");
            return;
        }

        for (int i = 0; i < n; i++) {
            List<Field> fl = list.get(i).getMementoFieldList();
            System.out.println();
            System.out.println("No." + i + " memento: ");

            int count=0;
            for (Field f : fl) {
                Plant p = f.getPlant();
                if (p==null){
                    continue;
                }
                count++;
                System.out.println("No." + f.getIndex() + " field: "
                        + p.getName() + ". Growth point: "
                        + p.getPresentGrowth() + "/"
                        + p.getMaxGrowth() + ".");
            }

            if (count == 0) {
                System.out.println("Empty.");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("All showed.");
        System.out.println();
    }
}
