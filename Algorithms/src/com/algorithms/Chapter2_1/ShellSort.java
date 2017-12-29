package com.algorithms.Chapter2_1;

import com.algorithms.Utils.Utils;

public class ShellSort extends Sort {
	/**
	 * 希尔排序的最后一趟就是插入排序，但却比插入排序快很多
	 * 所以前面之前的n次排序就是为了最后一次排序之前的数据为基本有序
	 * 容易么
	 * 
	 * 用算法第四版书中的增量n*3+1系列比单纯的a.length/2系列递减要快呢
	 */
	@Override
	void sort(Comparable[] a) {
		Utils.startCalc();
		
		int N = a.length;
		int h = 1;
		while(h < N/3) h = h * 3 + 1;
//		h = N /2;
		while(h >= 1){
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && Utils.getInstance().less(a[j], a[j-h]); j -= h) {
						Utils.getInstance().exch(a, j, j-h);
				}
			}
			h = h /3;
//			h = h /2;
		}
		
		Utils.stopAndCalcTime();
		if(a.length < 10000){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
	}
}
