package com.chenbin.test.maptest;

public interface BinMap<K,V> {
	
	
	public V put(K k,V v);
	public V get(K k);
	//��ȡ����Ԫ�صĸ���
	public int size();
	
	public void printAll(); //��JDK�������Զ���ġ�
	
	interface Entry<K,V>
	{
		 V setValue(V v);
		 K getKey();
		 V getValue();
	}
	

}
