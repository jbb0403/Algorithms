package com.algorithms.Chapter1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 原理都是一样的，我就不自己写了,但是他这个有问题
 * 我把内部迭代器类Iterator中的i=0改为i = first 否则打印时报空
 */
public class CustomArrayQueue<Item> implements Iterable<Item> {
    private Item[] q;             
    private int N = 0;            
    private int first = 0;        
    private int last  = 0;        

    public CustomArrayQueue() {
        q = (Item[]) new Object[2];
    }

    public boolean isEmpty() { return N == 0;    }
    public int size()        { return N;         }

    private void resize(int max) {
        assert max >= N;
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) temp[i] = q[(first + i) % q.length];
        q = temp;
        first = 0;
        last  = N;
    }


    public void enqueue(Item item) {
        if (N == q.length) resize(2*q.length);    
        q[last++] = item;                        
        if (last == q.length) last = 0;//入栈时判断first，出栈时判断last         
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue underflow");
        Item item = q[first];
        q[first] = null;                             
        N--;
        first++;
        if (first == q.length) first = 0;//入栈时判断first，出栈时判断last     
        return item;
    }

    public Iterator<Item> iterator() { return new QueueIterator(); }

    private class QueueIterator implements Iterator<Item> {
        private int i = first;//这是我自己改的，否则之前dequeue过了，从0开始会null，不科学
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[i % q.length];
            i++;
            return item;
        }
    }
}
