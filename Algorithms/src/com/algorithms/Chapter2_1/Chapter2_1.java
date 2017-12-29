package com.algorithms.Chapter2_1;

import com.algorithms.Utils.Utils;

public class Chapter2_1 {
	public static void main(String[] args){
		Comparable[] a = Utils.createYiweiShuzu(15);
//		new ChooseSort().sort(a.clone());
//		new InsertSort().sort(a.clone());
		new ShellSort().sort(a.clone());
		new MergeSort().sort(a.clone());
	}
}
