package com.algorithms.Chapter2_1;

import com.algorithms.Utils.Utils;

public class MergeSort extends Sort {
	private Comparable[] aux;
	@Override
	void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		Utils.startCalc();
		sort(a, 0, a.length -1);
		Utils.stopAndCalcTime();
		if(a.length < 10000){
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + "\t");
			}
		}
	}
	
	private void sort(Comparable[] a, int lo, int hi) {
		//将数组a[lo..hi]排序
		if(hi <= lo) return;
		int mid = lo + (hi -lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		
		merge(a, lo, mid, hi);
	}
	private void merge(Comparable[] a, int lo, int mid, int hi) {
		//将a[lo..mid] 和 a[mid+1..hi]归并
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		for (int k = lo; k <= hi; k++) {
			if 		(i > mid) a[k] = aux[j++];
			else if	(j > hi) a[k] = aux[i++];
			else if (Utils.getInstance().less(aux[j], aux[i])) a[k] = aux[j++];
			else 			a[k] = aux[i++];
		}
	}

}
