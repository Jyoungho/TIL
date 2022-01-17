package study.structure;

import java.util.ArrayList;

public class MyQueue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if (queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public String toString(){
        return queue.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);

        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
