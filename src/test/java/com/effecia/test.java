package com.effecia;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<Integer> ids=new ArrayList<>();;
		ids.add(1);
		ids.add(12);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		ids.add(13);
		System.out.println(ids.toString().substring(1, ids.toString().length()-1));
	}
}
