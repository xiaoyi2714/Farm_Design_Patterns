package com.processing;

import java.util.ArrayList;
import java.util.List;
import com.shop.repository.*;
//封装请求的类Request
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

//封装响应信息的类Response
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
	    //index初始化为0,filters.size()为3，不会执行return操作
	    if(index == chains.size()){
            return;
        }
        //每添加一个过滤规则，index自增1
        AbstractProcessingFactory f = chains.get(index);
        index++;
        //根据索引值获取对应的规律规则对字符串进行处理
        f.doProcess(request, response, chain);
	}
}