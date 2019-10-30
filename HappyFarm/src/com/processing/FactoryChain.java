package com.processing;

import java.util.ArrayList;
import java.util.List;
import com.shop.repository.*;
//��װ�������Request
class Request {
	
    private String requestStr;
    private int num;
    private RepositoryProxy repositoryProxy;
 
    public String getRequest() {
        return requestStr;
    }
 
    public void setRequest(String request) {
        this.requestStr = request;
    }
    public int getNum() {
		return num;
	}
    public void setNum(int num) {
		this.num = num;
	}
    public RepositoryProxy getRepositoryProxy() {
		return repositoryProxy;
	}
    public void setRepositoryProxy(RepositoryProxy repositoryProxy) {
		this.repositoryProxy = repositoryProxy;
	}
    
}

//��װ��Ӧ��Ϣ����Response
class Response {
	
    private String responseStr;
 
    public String getResponse() {
        return responseStr;
    }
 
    public void setResponse(String response) {
        this.responseStr = response;
    }
     
}

public class FactoryChain implements Process {
	
	private int index;
	private List<AbstractProcessingFactory> chains;
	
	public FactoryChain() {
		chains = new ArrayList<>();
	}
	
    @Override
	public void doProcess(Request request, Response response, FactoryChain chain) {
	    //index��ʼ��Ϊ0,filters.size()Ϊ3������ִ��return����
	    if(index == chains.size()){
            return;
        }
        //ÿ���һ�����˹���index����1
        AbstractProcessingFactory f = chains.get(index);
        index++;
        //��������ֵ��ȡ��Ӧ�Ĺ��ɹ�����ַ������д���
        f.doProcess(request, response, chain);
	}
}