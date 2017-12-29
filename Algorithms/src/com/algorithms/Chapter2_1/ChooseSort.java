package com.algorithms.Chapter2_1;

import com.algorithms.Utils.Utils;

/**
 * 选择排序 比较次数为N(N-1)/2 交换次数为N次
 * @author hxm
 *
 */
public class ChooseSort extends Sort{
	
	public void sort(Comparable[] a){
		Utils.startCalc();
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if(Utils.getInstance().less(a[j], a[min])){
					min = j;
				}
			}
			Utils.getInstance().exch(a, i, min);
		}
		Utils.stopAndCalcTime();
		if(a.length < 10000){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
		
	}
	
	
	
	
}
