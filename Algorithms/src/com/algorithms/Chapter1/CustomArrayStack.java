package com.algorithms.Chapter1;

import java.util.Iterator;

/**
 * 数组实现的后进先出栈，可以存放任意类型数据T
 * 使用迭代器模式，可自由迭代对象
 * @param <T>
 */
public class CustomArrayStack<T> implements Iterable<T> {

	private T[] a = (T[])new Object[2];
	private int n = 0;
	
	public boolean isEmpty(){ return n==0; }
	public int size(){ return n; }
	public void push(T t){
		if(n == a.length){
			resize(2 * a.length);
		}
		a[n++] = t;
	}
	public T pop(){
		if(n == 0){
			return null;
		}
		T t = a[--n];
		return t;
	}
	
	//暂时只能扩大不能缩小
	public void resize(int newLength){
		T[] aa = (T[]) new Object[newLength];
		for (int i = 0; i < a.length; i++) {
			aa[i] = a[i];
		}
		a = aa;
		System.out.println("resize a.length:" + a.length);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ResizingStackIterator();
	}
	
	private class ResizingStackIterator implements Iterator<T>{
		//后进先出的迭代
		int i = n;
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return a[--i];
		}

		@Override
		public void remove() {
			
		}
	}
	
}
