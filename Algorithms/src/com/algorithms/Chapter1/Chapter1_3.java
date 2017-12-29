package com.algorithms.Chapter1;

import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

public class Chapter1_3 {
	public static void main(String[] args) {
//		String[] arr = {"(", "1", "+", "(" , "(" , "2" , "+" , "3" , ")" , "*" , "(" , "4" , "*" , "5" , ")" , ")" , ")"};
//		Chapter1_3.Dijkstra(arr);
//		String[] arr2 = {"(", "(", "1", "+", "sqrt", "(", "5.0", ")", ")", "/", "2.0", ")"};
//		Chapter1_3.Dijkstra(arr2);
		
//		customArrayStack();
//		customNodeStack();
//		customNodeQueue();
		
//		String[] arr3 = {"[", "(", ")", "]" , "{" , "}", "{" , "[" , "(" , ")" , "(" , ")" , "]" , "(" , ")" , "}"};
//		System.out.println("E1_3_4: " + Chapter1_3.E1_3_4(arr3));
//		String[] arr4 = {"[", "(", ")", "]" , "{" , "}", "{" , "[" , "(" , "]" , "(" , ")" , "]" , "(" , ")" , "}"};
//		System.out.println("E1_3_4: " + Chapter1_3.E1_3_4(arr4));
	
//		String[] arr5 = {"1", "+", "2", ")", "*", "3", "-", "4", ")", "*", "5", "-", "6", ")", ")", ")"};
//		Chapter1_3.E1_3_9(arr5);
		//这个可真是学习了，逆向思维的方法
		
//		String[] arr6 = {"1", "2", "-", "3", "4", "5", "-", "6", "-", "7", "8", "-", "9", "0"};
//		Chapter1_3.E1_3_14(arr6);
		
//		String[] arr7 = {"A", "B", "C", "D", "E", "F", "G"};
//		Chapter1_3.E1_3_19To1_3_26(arr7);
		
		String[] arr8 = {"3", "7", "2", "10", "15", "13", "8"};
		Chapter1_3.E1_3_27To1_3_28(arr8);
	}
	
	public static void E1_3_27To1_3_28(String[] arr){
		LinkTable<String> link = new LinkTable<>();
		for (int i = 0; i < arr.length; i++) {
			link.appendFromFirst(arr[i]);
		}
		
		//E1_3_27
		System.out.println("最大的数为：" + link.max());
		
		//E1_3_28
		System.out.println("递归最大的数为：" + link.max(link.first, 0));
	}
	
	
	
	public static void E1_3_19To1_3_26(String[] arr){
		LinkTable<String> link = new LinkTable<>();
		for (int i = 0; i < arr.length; i++) {
			link.appendFromFirst(arr[i]);
		}
		System.out.println(link.toString());
		System.out.println(link.removeFirst());
		System.out.println(link.toString());
		System.out.println(link.removeLast());
		System.out.println(link.toString());
		System.out.println(link.removeTarget(4));
		System.out.println(link.toString());
		System.out.println(link.removeTarget("F"));
		System.out.println(link.toString());
		
		
		LinkTable<String> link2 = new LinkTable<>();
		for (int i = 0; i < arr.length; i++) {
			link2.appendFromLast(arr[i]);
		}
		System.out.println(link2.toString());
		System.out.println(link2.removeFirst());
		System.out.println(link2.toString());
		System.out.println(link2.removeLast());
		System.out.println(link2.toString());
		System.out.println(link2.removeTarget(4));
		System.out.println(link2.toString());
		System.out.println(link2.removeTarget("F"));
		System.out.println(link2.toString());
	}
	
	public static void E1_3_14(String[] arr){
		CustomArrayQueue<String> queue = new CustomArrayQueue<>();
		for (int i = 0; i < arr.length; i++) {
			String item = arr[i];
			if(!item.equals("-")) queue.enqueue(item);
			else queue.dequeue();
		}
		System.out.print("enqueue、dequeue之后的队列：");
		Iterator<String> it = queue.iterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}
	
	public static void E1_3_9(String[] arr){
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			String item = arr[i];
			switch (item) {
			case "(":
				break;
			case "+":
				ops.push(item);
				break;
			case "-":
				ops.push(item);
				break;
			case "*":
				ops.push(item);
				break;
			case "/":
				ops.push(item);
				break;
			case ")":
				String op = ops.pop();
				String v  = vals.pop();
				String tmp = String.format("(%s %s %s)",vals.pop(), op, v);
				vals.push(tmp);
				break;
			default:
				vals.push(item);
				break;
			}
		}
		System.out.print("加上左括号的表达式为: ");
		Iterator<String> a = vals.iterator();
		if(a.hasNext()){
			System.out.print(a.next());
		}
	}

	public static boolean E1_3_4(String[] arr){
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < arr.length; i++) {
			String item = arr[i];
			switch (item) {
			case "(":
				stack.push(item);
				break;
			case "[":
				stack.push(item);
				break;
			case "{":
				stack.push(item);
				break;
			case ")":
				String last = stack.pop();
				if(!"(".equals(last)){
					return false;
				}
				break;
			case "]":
				String last2 = stack.pop();
				if(!"[".equals(last2)){
					return false;
				}
				break;
			case "}":
				String last3 = stack.pop();
				if(!"{".equals(last3)){
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	
	}
	
	private static void customNodeQueue() {
		String[] arr = {"to", "be", "number", "1", "-", "-", "pi", "ke"};
		CustomNodeQueue<String> queue = new CustomNodeQueue<String>();
		for (int i = 0; i < arr.length; i++) {
			String item = arr[i];
			if(!item.equals("-"))queue.enqueue(item);
			else if(!queue.isEmpty()) System.out.println(queue.dequeue());
		}
		System.out.println("stack size: " + queue.size());
	}
	
	private static void customNodeStack() {
		String[] arr = {"to", "be", "number", "1", "-", "-", "pi", "ke"};
		CustomNodeStack<String> stack = new CustomNodeStack<String>();
		for (int i = 0; i < arr.length; i++) {
			String item = arr[i];
			if(!item.equals("-"))stack.push(item);
			else if(!stack.isEmpty()) System.out.println(stack.pop());
		}
		System.out.println("stack size: " + stack.size());
	}

	//自定义后进先出栈，可存放任意数据
	private static void customArrayStack() {
		CustomArrayStack<String> aa = new CustomArrayStack<String>();
		for (int i = 0; i < 10; i++) {
			aa.push("t" + i);
		}
		aa.resize(40);
		Iterator<String> ia = aa.iterator();
		while(ia.hasNext()){
			//因为是后进先出，所以先打印最上层数据
			System.out.println(ia.next());
		}
	}

	/**
	 * 这种双栈算数表达式好厉害，不用多个for循环，一个for循环即可解决问题
	 * 根据判定")"来将stack中最后两项的数做四则运算求值 
	 * 这种方式好巧
	 */
	public static void Dijkstra(String[] arr){
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals= new Stack<Double>();
		
		for (int i = 0; i < arr.length; i++) {
			String s = arr[i];
			switch (s) {
			case "(":
				break;
			case "+":
				ops.push(s);
				break;
			case "-":
				ops.push(s);
				break;
			case "*":
				ops.push(s);
				break;
			case "/":
				ops.push(s);
				break;
			case "sqrt":
				ops.push(s);
				break;
			case ")"://如果字符为"}",弹出运算符和操作符，并将计算结果压入栈
				String op = ops.pop();
				double v = vals.pop();
				switch (op) {
				case "+":
					v = vals.pop() + v;
					break;
				case "-":
					v = vals.pop() - v;
					break;
				case "*":
					v = vals.pop() * v;
					break;
				case "/":
					v = vals.pop() / v;
					break;
				case "sqrt":
					v = Math.sqrt(v);
					break;
				default:
					break;
				}
				vals.push(v);
				break;
			default:
				vals.push(Double.parseDouble(s));
				break;
			}
		}
		System.out.println(vals.pop());
	}
}
