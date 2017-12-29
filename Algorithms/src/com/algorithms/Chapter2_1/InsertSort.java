package com.algorithms.Chapter2_1;

import com.algorithms.Utils.Utils;

public class InsertSort extends Sort{
	@Override
	void sort(Comparable[] a) {
		Utils.startCalc();
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j >0 && Utils.getInstance().less(a[j], a[j-1]); j--) {
				Utils.getInstance().exch(a, j, j-1);
			}
		}
		Utils.stopAndCalcTime();
		if(a.length < 10000){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
	}
}
