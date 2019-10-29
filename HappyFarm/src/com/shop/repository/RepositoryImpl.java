package com.shop.repository;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RepositoryImpl implements Repository {
    public void add(Class cls, Integer value){
        String type = cls.getSimpleName();
        if (!storageList.containsKey(type)){
            storageList.put(type, value);
        }else{
            storageList.put(type, value + storageList.get(type));
        }
        System.out.printf("仓库中的%s项添加了%d，目前库存%d\n", type, value, storageList.get(type));

    }

    public void add(Map<Class, Integer> map){
        for (Map.Entry<Class, Integer> entry : map.entrySet()){
            this.add(entry.getKey(), entry.getValue());
        }

    }

    public boolean ask(Class cls, Integer value){
        String type = cls.getSimpleName();
        if(storageList.containsKey(type) && storageList.get(type) >= value){
            this.consume(type, value);
            return true;
        }
        return false;
    }

    public boolean ask(Map<Class, Integer> map){
        boolean result = true;
        //与add不同，当一个请求中有一项要求无法满足，则应当拒绝执行该请求的所有要求
        for (Map.Entry<Class, Integer> entry : map.entrySet()){
            String type = entry.getKey().getSimpleName();
            result = storageList.containsKey(type) && storageList.get(type) >= entry.getValue();
            if (!result){
                return false;
            }
        }
        //先确保所有要求可以满足，再进行消耗
        for (Map.Entry<Class, Integer> entry : map.entrySet()){
            this.consume(entry.getKey().getSimpleName(),entry.getValue());
        }
        return true;
    }

    public Integer checkItemNum(Class cls){
        return storageList.get(cls.getSimpleName());
    }

    protected RepositoryImpl(){

    }

    public void showAllItems(){
        Iterator<Map.Entry<String, Integer>> iterator = storageList.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.printf("仓库中%s项的库存为%d\n", entry.getKey(), entry.getValue());
        }
    }

    public Integer getTotalValue(){
        Integer total = 0;
        Iterator<Map.Entry<String, Integer>> iterator = storageList.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            total = total + entry.getValue();
        }
        return total;
    }

    //保存仓库库存字典
    private Map<String, Integer> storageList = new HashMap<>();

    //消耗
    private void consume(String type, Integer value){
        storageList.put(type, storageList.get(type) - value);
        System.out.printf("仓库中的%s项消耗了%d，目前库存%d\n", type, value, storageList.get(type));
    }




}
