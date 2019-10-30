package com.processing;

public interface Process {
	
    void doProcess(Request request, Response response, FactoryChain chain);
    
}
