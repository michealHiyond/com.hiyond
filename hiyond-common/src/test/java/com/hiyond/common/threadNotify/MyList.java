package com.hiyond.common.threadNotify;

import java.util.ArrayList;
import java.util.List;

public class MyList {

	private static List<String> list = new ArrayList<String>();
	
	public static void add(String e){
		list.add(e);
	}
	
	public static int size(){
		return list.size();
	}
	
}
