package com.algorithms.Chapter1;

import java.util.Iterator;

/**
 * 后进先出的链表栈
 * @param <T>
 */
public class CustomNodeStack<T> implements Iterable<T>{
	private Node first;// 栈顶元素
	private int N;//栈内元素数量
	private class Node{
		T t;
		Node next;
	}
	
	public boolean isEmpty(){ return N == 0;}
	public int size(){return N;};
	public void push(T t){
		Node oldFirst = first;
		first = new Node();
		first.t = t;
		first.next = oldFirst;
		N++;
	}
	public T pop(){
		T t = first.t;
		first = first.next;
		N--;
		return t;
	}
	@Override
	public Iterator<T> iterator() {
		return null;
	}
	
	private class CustomNodeStackIterator implements Iterator<T>{
		int cursor = N;
		@Override
		public boolean hasNext() {
			return cursor == 0;
		}

		@Override
		public T next() {
			//具体算法请见1.4，还没整呢
			return null;
		}

		@Override
		public void remove() {
		}
		
	}
}
