package com.algorithms.Chapter1;

import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Chapter1_1 {
	public static void main(String[] args){
//		Chapter1_1.E1_1_6();
		
		
//		System.out.println("10进制转2进制: " + Chapter1_1.E1_1_9(10));
		
//		Chapter1_1.E1_1_1To1_1_8();
		//转置二维数组
//		Chapter1.E1_1_13(Chapter1.createErweiShuzu(3, 1));
		
		//不大于log2N的最大整数
//		System.out.println(Math.log(16)/Math.log(2));
//		System.out.println(E1_1_14(16));
		
//		System.out.println(E1_1_16(6));
		//调用函数13次，每次n的值：6 3 0 1 -2 -1 4 1 -2 -1 2 -1 0
		//最后结果: A-3-A-1-A-1-3-6-A-1-A-1-4-A-2-A-2-4-6
	
		//斐波那契数列
//		System.out.println(E1_1_19(5));

		
	}
	
	
	
	public static int E1_1_19(int n){
		System.out.println("n="+n);
		if(n == 0) return 0;
		if(n == 1) return 1;
		return E1_1_19(n-1) + E1_1_19(n-2);
	}
	
	public static String E1_1_16(int n){
		System.out.printf(n + " ");
		if(n <= 0) return "A";
		return E1_1_16(n-3) +"-"+ n +"-"+ E1_1_16(n-2) +"-"+ n;
	}
	
	
	/**
	 * 小于Log2N的最小整数
	 * @param n
	 */
	public static int E1_1_14(int n){
		int count = 0;
		double dn = (double)n;
		while(dn >= 2){
			dn /= 2;
			count++;
		}
		return count;
	}
	
	
	
	/**
	 * 转置二维数组
	 */
	public static void E1_1_13(int[][] dataArr) {
		int newLie = dataArr.length;
		int newHang  = dataArr[0].length;
		int[][] newArr = new int[newHang][newLie]; 
		for (int i = 0; i < dataArr.length; i++) {
			for (int j = 0; j < dataArr[i].length; j++) {
				newArr[j][i] = dataArr[i][j];
			}
		}
		
		// 遍历打印
		System.out.println("=======生成的随机数组=======");
		for (int i = 0, j = newArr.length; i < j; i++) {
			for (int h = 0, k = newArr[i].length; h < k; h++) {
				System.out.print(newArr[i][h] + "\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 生成二维数组
	 * @return
	 */
	public static int[][] createErweiShuzu(int hang, int lie) {
		int[][] randomArr = new int[hang][lie];
		for (int i = 0; i < hang; i++) {
			for (int j = 0; j < lie; j++) {
				randomArr[i][j] = new Random().nextInt(100);
			}
		}
		// 遍历打印
		System.out.println("=======生成的随机数组=======");
		for (int i = 0, j = randomArr.length; i < j; i++) {
			for (int h = 0, k = randomArr[i].length; h < k; h++) {
				System.out.print(randomArr[i][h] + "\t");
			}
			System.out.println();
		}
		return randomArr;
	}
	
	/**
	 * 练习1.1.1-1.1.8
	 */
	public static void E1_1_1To1_1_8(){
		System.out.println("-14%3:" + -14%3);
		System.out.println("14%-3:" + 14%-3);
		System.out.println("-14%-3:" + -14%-3);
	
		System.out.println(true && false || true && true);
		System.out.println((1+2.236)/2);
		System.out.println(1 + 2 + 3 + 4.0);
		System.out.println(4.1 >= 4);
		System.out.println(1 + 2 + "3");
		
		System.out.println('a' + 'c');
		System.out.println((char)('a' + 4));
		
	}
	
	public static String E1_1_9(int N){
		String s = "";
		while(N > 0){
			s = N%2 + s;
			N /= 2;
		}
		return s;
	}
	
	public static void E1_1_6(){
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			System.out.println("f:" + f);
			f = f + g;
			g = f - g;
		}
	}
}
