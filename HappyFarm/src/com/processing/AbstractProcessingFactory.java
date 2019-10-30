package com.processing;
/**
 * ���󹤳�, �۲���ģʽ�ĵ������ģ�����Stateģʽ�Ļ�����,��Ԫģʽ������
 * @author linyi
 *
 */
public interface AbstractProcessingFactory {
	
	//���ӻ���
	void addMachine();
	//�Ƴ�����
	void removeMachine(int index);
	//��ȡ������״̬
	void getMachinesState();
	//�趨����
	void setEnvironment(Environment environment);
	//������绷�������ƹ�������
	void handle();
	//
	void doProcess(Request request, Response response, FactoryChain chain);
}
