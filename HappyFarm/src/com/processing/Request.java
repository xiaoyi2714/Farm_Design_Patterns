package com.processing;

import com.shop.repository.RepositoryProxy;

public class Request {

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
