package com.chenbin.test.maptest;

import java.util.HashMap;

public class Test {

	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap test=null;
		BinMap<String,String> binMap=new BinHashMap<String,String>();
		binMap.put("001∫≈", "001");
		binMap.put("002∫≈", "002");
		binMap.put("003∫≈", "003");
		binMap.put("004∫≈", "004");
		binMap.put("005∫≈", "005");
		binMap.put("006∫≈", "006");
		binMap.put("007∫≈", "007");
		binMap.put("008∫≈", "008");
		binMap.put("009∫≈", "009");
		binMap.put("010∫≈", "010");
		binMap.put("011∫≈", "011");
		binMap.put("012∫≈", "012");
		
		binMap.put("013∫≈", "013");
		binMap.put("014∫≈", "014");
		binMap.put("015∫≈", "015");
		binMap.put("016∫≈", "016");
		binMap.put("017∫≈", "017");
		binMap.put("018∫≈", "018");
		binMap.put("019∫≈", "019");
		binMap.put("020∫≈", "020");
		binMap.put("021∫≈", "021");
		binMap.put("022∫≈", "022");
		binMap.put("023∫≈", "023");
		binMap.put("024∫≈", "024");
		
		binMap.put("025∫≈", "025");
		binMap.put("026∫≈", "026");
		binMap.put("027∫≈", "027");
		binMap.put("028∫≈", "028");
		binMap.put("029∫≈", "029");
		binMap.put("030∫≈", "030");
		binMap.put("031∫≈", "031");
		binMap.put("032∫≈", "032");
		binMap.put("033∫≈", "033");
		binMap.put("034∫≈", "034");
		binMap.put("035∫≈", "035");
		binMap.put("036∫≈", "036");
		binMap.printAll();
		System.out.println("001∫≈Hash÷µ£∫"+"001∫≈".hashCode()%15);
		System.out.println("001∫≈Hash÷µ£∫"+("001∫≈".hashCode() & 15));
		
		System.out.println("================>028∫≈÷µ£∫"+binMap.get("028∫≈"));
		

	}
	
}
