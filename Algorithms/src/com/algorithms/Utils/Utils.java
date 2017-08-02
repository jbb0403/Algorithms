package com.algorithms.Utils;

import java.util.Random;

public class Utils {
	/**
	 * 生成一维数组
	 * @return
	 */
	public static Comparable[] createYiweiShuzu(int lie) {
		Comparable[] randomArr = new Comparable[lie];
		for (int i = 0; i < lie; i++) {
				randomArr[i] = new Random().nextInt(100);
		}
		// 遍历打印
		System.out.println("=======生成的随机数组=======");
		for (int i = 0, j = randomArr.length; i < j; i++) {
			System.out.print(randomArr[i] + "\t");
		}
		System.out.println();
		return randomArr;
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
}
