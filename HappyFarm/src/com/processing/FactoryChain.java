package com.processing;

import java.util.ArrayList;
import java.util.List;
import com.shop.repository.*;

public class FactoryChain implements Process {

    private int index;
    private List<AbstractProcessingFactory> chains;

    public FactoryChain() {
        chains = new ArrayList<>();
    }

    @Override
    public void doProcess(Request request, Response response, FactoryChain chain) {
        //index??????0,filters.size()?3?????????return????
        if(index == chains.size()){
            return;
        }
        //???????????????index????1
        AbstractProcessingFactory f = chains.get(index);
        index++;
        //????????????????????????????????��???
        f.doProcess(request, response, this);
    }

    public boolean addFactory(AbstractProcessingFactory newFactory){
        if(newFactory!=null){
            chains.add(newFactory);
            return true;
        }
        else return false;
    }

    public boolean removeFactory(int index){
        if(index<chains.size()){
            chains.remove(index);
            return true;
        }
        else return false;
    }
}