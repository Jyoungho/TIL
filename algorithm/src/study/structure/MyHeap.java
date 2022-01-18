package study.structure;

import java.util.ArrayList;
import java.util.Collections;

public class MyHeap {

    private ArrayList<Integer> heapArray = null;

    public MyHeap(int data) {
        this.heapArray = new ArrayList<>();
        this.heapArray.add(null);
        this.heapArray.add(data);
    }

    public boolean insert(int data) {
        int insertedIdx, parentIdx;
        if (this.heapArray == null) {
            this.heapArray = new ArrayList<>();
            this.heapArray.add(null);
            this.heapArray.add(data);
            return true;
        }

        this.heapArray.add(data);
        insertedIdx = this.heapArray.size() - 1;

        while (moveUp(insertedIdx)) {
            parentIdx = insertedIdx / 2;
            Collections.swap(heapArray, insertedIdx, parentIdx);
            insertedIdx = parentIdx;
        }
        return true;
    }

    private boolean moveUp(int insertedIdx) {
        if (insertedIdx <= 1) {
            return false;
        }
        int parentIdx = insertedIdx / 2;
        return this.heapArray.get(insertedIdx) > this.heapArray.get(parentIdx);
    }

    public Integer pop() {
        int returnedData, poppedIdx, leftChildPoppedIdx, rightChildPoppedIdx;

        if (this.heapArray.size() <= 1) {
            return null;
        }

        returnedData = this.heapArray.get(1);
        this.heapArray.set(1, this.heapArray.get(this.heapArray.size() - 1));
        this.heapArray.remove(this.heapArray.size() - 1);
        poppedIdx = 1;

        while (this.moveDown(poppedIdx)) {
            leftChildPoppedIdx = poppedIdx * 2;
            rightChildPoppedIdx = poppedIdx * 2 + 1;

            if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    Collections.swap(this.heapArray, poppedIdx, leftChildPoppedIdx);
                    poppedIdx = leftChildPoppedIdx;
                }
            } else {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                    Collections.swap(this.heapArray, poppedIdx, rightChildPoppedIdx);
                    poppedIdx = rightChildPoppedIdx;
                }
            }
        }
        return returnedData;
    }

    private boolean moveDown(int poppedIdx) {
        int leftChildPoppedIdx, rightChildPoppedIdx;

        leftChildPoppedIdx = poppedIdx * 2;
        rightChildPoppedIdx = poppedIdx * 2 + 1;

        if (leftChildPoppedIdx >= this.heapArray.size()) {
            return false;
        } else if (rightChildPoppedIdx >= this.heapArray.size()) {
            return false;
        } else {
            if (this.heapArray.get(leftChildPoppedIdx) > this.heapArray.get(rightChildPoppedIdx)) {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(leftChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (this.heapArray.get(poppedIdx) < this.heapArray.get(rightChildPoppedIdx)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHeap heap = new MyHeap(1);

        heap.insert(2);
        heap.insert(3);
        heap.insert(5);

        System.out.println(heap.heapArray);

        heap.pop();

        System.out.println(heap.heapArray);

        heap.pop();

        System.out.println(heap.heapArray);

        heap.pop();

        System.out.println(heap.heapArray);

        heap.pop();

        System.out.println(heap.heapArray);

        heap.insert(1);

        System.out.println(heap.heapArray);

    }
}
