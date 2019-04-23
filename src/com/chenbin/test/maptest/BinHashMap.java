package com.chenbin.test.maptest;

public class BinHashMap<K,V> implements BinMap<K, V> {
	
	/**
	 * author:chenbin
	 * time:20180912
	 * 
	 * 
	 * 
	 * 
	 */
	
	private BinNode<K,V>[] array=null;
	private int defaultLenth=16;//默认数组长度
	private int size;//集合中元素个数
	private double factor=0.75D;//加载因子，或者叫扩容因子。
	
	
	@Override
	public void printAll() 
	{
		
		if(array==null)
			System.out.println("this binHasMap is null.....");
		else 
		{
			BinNode <K,V>tempNode=null;
			for(int i=0;i<array.length;i++) 
			{
				tempNode=array[i];
				System.out.print("下标["+i+"]:");
				while(tempNode!=null) 
				{
					System.out.print("["+tempNode.getKey()+":"+tempNode.getValue()+"]");
					if(tempNode.next!=null)
					 {
						tempNode=tempNode.next;
					 }
					else
						tempNode=null;
					
					
				}
				System.out.println();
				
			}
			
		}
		
		
	}

	@Override
	public V put(K k, V v) {
		if (array==null)
		{
			array=new BinNode[defaultLenth];
		}
		int index =position(k,defaultLenth);
		
		//判断是否需要扩容
		if(size>defaultLenth*factor)
		{
			resize();
			
		}
		
		
		BinNode<K,V> node=array[index];
		if (node==null) //假如这个数组该位置上没有存放数据节点
		{
			array[index]=new BinNode<K,V>(k,v,null);
			size++;
		}
		else
		{
			
		     if(k.equals(node.getKey())&&k==node.getKey())//更新原来的值
		    	return array[index].setValue(v);//更新值，并返回旧值
		     else //插入新数据
		     {
		    	 array[index]=new BinNode<K,V>(k,v,node);
		    	 size++;
		     }
		       
			
		}
		
		
		return null;
	}

	private void resize() {
		
	
		BinNode<K,V>[] tempArray=new BinNode[defaultLenth<<1];//相当于defaultLenth*2，即原来长度的双倍扩容
		BinNode<K,V> tmpNode=null;
		
		for(int i=0;i<array.length;i++) //遍历纵向Hash桶
		{
			tmpNode=array[i];
			while (tmpNode!=null) //遍历横向链表
			{
				int newIndex=position(tmpNode.getKey(),tempArray.length);//扩容后Hash桶的位置
				BinNode<K,V> next=tmpNode.next;//临时保存旧链表下一个节点，为遍历当前Hash桶中所有横向链表数据
				tmpNode.next=tempArray[newIndex];//把原来横向链表节点的next指针指向新的Hash桶上的节点
				tempArray[newIndex]=tmpNode;//把已经更新好Next节点的旧结点插入到新Hash桶的初始位置
				tmpNode=next;//把上面临时保存的下一个节点赋值给当前节点，为继续循环遍历横向链表。
				
			}
		
		
		}
		
		//替换老的数组
		array=tempArray;
		defaultLenth=tempArray.length;
	    tempArray=null;
		
		
	}

	private int position(K k,int length) {
		
		int hashCode=k.hashCode();
		int pos=hashCode%(length-1);//取模算法
		//int pos=hashCode & (defaultLenth-1);//取与算法。

		
		return pos;
	}

	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		if(array!=null)
		{
			int tmpIndex=position(k,defaultLenth);
            BinNode<K,V> tmpNode=array[tmpIndex];
            while(tmpNode!=null)
            {
            	
            	if(tmpNode.getKey()==k)
            	{
            		return tmpNode.getValue();
            	}
            	else
            	{
            		tmpNode=tmpNode.next;
            	}
            }
            
			
		}
		
		
		return null;
	}

	@Override
	public int size() {
		return this.size;
	}

	
	class BinNode<K,V> implements Entry<K,V>
	{

		K key;
		V value;
		BinNode<K,V> next;
		public BinNode(K k, V v, BinNode<K,V> next) {
			
			this.key=k;
			this.value=v;
			this.next=next;
			
		}

		@Override
		public V setValue(V v) {
			V oldValue=this.value;
			this.value=v;
			return oldValue;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
		
		
	}

}
