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
	private int defaultLenth=16;//Ĭ�����鳤��
	private int size;//������Ԫ�ظ���
	private double factor=0.75D;//�������ӣ����߽��������ӡ�
	
	
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
				System.out.print("�±�["+i+"]:");
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
		
		//�ж��Ƿ���Ҫ����
		if(size>defaultLenth*factor)
		{
			resize();
			
		}
		
		
		BinNode<K,V> node=array[index];
		if (node==null) //������������λ����û�д�����ݽڵ�
		{
			array[index]=new BinNode<K,V>(k,v,null);
			size++;
		}
		else
		{
			
		     if(k.equals(node.getKey())&&k==node.getKey())//����ԭ����ֵ
		    	return array[index].setValue(v);//����ֵ�������ؾ�ֵ
		     else //����������
		     {
		    	 array[index]=new BinNode<K,V>(k,v,node);
		    	 size++;
		     }
		       
			
		}
		
		
		return null;
	}

	private void resize() {
		
	
		BinNode<K,V>[] tempArray=new BinNode[defaultLenth<<1];//�൱��defaultLenth*2����ԭ�����ȵ�˫������
		BinNode<K,V> tmpNode=null;
		
		for(int i=0;i<array.length;i++) //��������HashͰ
		{
			tmpNode=array[i];
			while (tmpNode!=null) //������������
			{
				int newIndex=position(tmpNode.getKey(),tempArray.length);//���ݺ�HashͰ��λ��
				BinNode<K,V> next=tmpNode.next;//��ʱ�����������һ���ڵ㣬Ϊ������ǰHashͰ�����к�����������
				tmpNode.next=tempArray[newIndex];//��ԭ����������ڵ��nextָ��ָ���µ�HashͰ�ϵĽڵ�
				tempArray[newIndex]=tmpNode;//���Ѿ����º�Next�ڵ�ľɽ����뵽��HashͰ�ĳ�ʼλ��
				tmpNode=next;//��������ʱ�������һ���ڵ㸳ֵ����ǰ�ڵ㣬Ϊ����ѭ��������������
				
			}
		
		
		}
		
		//�滻�ϵ�����
		array=tempArray;
		defaultLenth=tempArray.length;
	    tempArray=null;
		
		
	}

	private int position(K k,int length) {
		
		int hashCode=k.hashCode();
		int pos=hashCode%(length-1);//ȡģ�㷨
		//int pos=hashCode & (defaultLenth-1);//ȡ���㷨��

		
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
