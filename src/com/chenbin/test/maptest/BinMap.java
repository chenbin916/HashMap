package com.chenbin.test.maptest;

public interface BinMap<K,V> {
	
	
	public V put(K k,V v);
	public V get(K k);
	//获取集合元素的个数
	public int size();
	
	public void printAll(); //非JDK方法，自定义的。
	
	interface Entry<K,V>
	{
		 V setValue(V v);
		 K getKey();
		 V getValue();
	}
	

}
