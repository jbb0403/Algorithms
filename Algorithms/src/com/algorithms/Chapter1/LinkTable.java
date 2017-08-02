package com.algorithms.Chapter1;

public class LinkTable<T> {
	Node first = null;
	Node last = null;
	int N = 0;
	
	public boolean isEmpty(){ return N==0;}
	public int size(){return N;}
	
	/**
	 * 从链表表头添加
	 */
	public void appendFromFirst(T t){
		if(isEmpty()){
			first = new Node();
			last = first; 
		}else{
			Node oldFirst = first;
			first = new Node();
			first.next = oldFirst;
		}
		first.t = t;
		N++;
	}
	
	/**
	 * 从链表末尾添加
	 */
	public void appendFromLast(T t){
		if(isEmpty()){
			last = new Node();
			first = last; 
		}else{
			Node oldLast = last;
			last = new Node();
			oldLast.next = last;
		}
		last.t = t;
		N++;
	}
	
	
	public T fist(){
		if (isEmpty()) throw new RuntimeException("List is empty");
		return first.t;
	}
	
	public T last(){
		if (isEmpty()) throw new RuntimeException("List is empty");
		return last.t;
	}
	
	public T removeFirst(){
		if (isEmpty()) throw new RuntimeException("List is empty");
		T t = first.t;
		first = first.next;
		N--;
		return t;
	}
	
	public T removeLast(){
		if (isEmpty()) throw new RuntimeException("List is empty");
//		T t = last.t;从最后一个移除，不能简单的写last = null;
		Node cursor = first;
		while(cursor != null){
			if(cursor.next == last){
				T t = last.t;
				cursor.next = null;
				last = cursor;
				N--;
				return t;
			}
			cursor = cursor.next;
		}
		return null;
	}
	
	/**
	 * 删除第K个元素
	 * @param key
	 * @return
	 */
	public T removeTarget(int key){
		if (isEmpty()) throw new RuntimeException("List is empty");
		int k = 0;
		Node cursor = first;
		Node preCursor = null;
		while(cursor != null){
			if(k == key){
				N--;
				T t = cursor.t;
				if(preCursor == null){//如果是第0个元素
					first = cursor.next;
					return t;
				}
				if(cursor.next == null){//如果是最后一个元素
					last = preCursor;
				}
				preCursor.next = cursor.next;
				return t;
			}
			k++;
			preCursor = cursor;
			cursor = cursor.next;
		}
		return null;
	}
	
	/**
	 * 删除含有指定key的元素
	 * @param key
	 * @return
	 */
	public T removeTarget(T key){
		if (isEmpty()) throw new RuntimeException("List is empty");
		Node cursor = first;
		Node preCursor = null;
		while(cursor != null){
			if(cursor.t.equals(key)){
				T t = cursor.t;
				N--;
				if(preCursor == null){//如果是第0个元素
					first = cursor.next;
					return t;
				}
				if(cursor.next == null){//如果是最后一个元素
					last = preCursor;
				}
				preCursor.next = cursor.next;
				
				return t;
			}
			preCursor = cursor;
			cursor = cursor.next;
		}
		return null;
	}
	
	@Override
	public String toString() {
		if (isEmpty()) throw new RuntimeException("List is empty");
		StringBuffer sb = new StringBuffer();
		Node cursor = first;
		do{ 
			sb.append(cursor.t + " ; ");
			cursor = cursor.next;
		}while(cursor != null);
		sb.append(" size:" + N);
		sb.append(" first:" + first.t);
		sb.append(" last:"+last.t);
		return sb.toString();
	}
	
	/**
	 * 正常循环链表查找最大数字
	 * @return
	 */
	public int max(){
		Node cursor = first;
		int maxInt = 0;
		while(cursor != null){
			if(Integer.parseInt(cursor.t.toString()) > maxInt){
				maxInt = Integer.parseInt(cursor.t.toString());
			}
			cursor = cursor.next;
		}
		return maxInt;
	}
	
	/**
	 * 递归实现链表查询操作
	 * @param first
	 * @param maxInt
	 * @return
	 */
	public int max(Node first, int maxInt){
		if(first == null) return maxInt;
		Node cursor = first;
		if(Integer.parseInt(cursor.t.toString()) > maxInt){
			maxInt = Integer.parseInt(cursor.t.toString());
		}
		return max(cursor.next, maxInt);
	}
	
	
	
	
	
	
	
	private class Node{
		T t;
		Node next;
	}
}
