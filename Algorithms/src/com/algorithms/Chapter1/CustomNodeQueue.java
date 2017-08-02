package com.algorithms.Chapter1;

/**
 * 先进先出的队列Queue
 * @param <T>
 */
public class CustomNodeQueue<T>{
	private Node first;// 链表表头元素
	private Node last;// 链表表尾元素
	private int N;//栈内元素数量
	private class Node{
		T t;
		Node next;
	}
	
	public boolean isEmpty(){ return N == 0;}
	public int size(){return N;};
	public void enqueue(T t){
		Node oldLast = last;
		last = new Node();
		last.t = t;
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}
	
	//他这种写法有个前提条件：里面一定有数据，如果上来就没数据，那么就报错了
	public T dequeue(){
		T t = first.t;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return t;
	}
}
