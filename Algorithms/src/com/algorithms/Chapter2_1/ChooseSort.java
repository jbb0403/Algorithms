package com.algorithms.Chapter2_1;

/**
 * 选择排序 比较次数为N(N-1)/2 交换次数为N次
 * @author hxm
 *
 */
public class ChooseSort {
	
	public static void sort(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if(less(a[j], a[min])){
					min = j;
				}
			}
			exch(a, i, min);
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public static void exch(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i = 0; i < a.length; i++) {
			if(less(a[i], a[i-1])) return false;
		}
		return true;
	}
	
	
}
