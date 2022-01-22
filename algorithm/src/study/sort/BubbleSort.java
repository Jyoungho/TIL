package study.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        for (int i = 0; i < data.size() - 1 ; i++) {
            boolean swaped = false;
            for (int j = 0; j < data.size() - 1 - i; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    Collections.swap(data, j, j + 1);
                    swaped = true;
                }
            }
            if (!swaped) break;
        }
        return data;
    }

    public static void main(String[] args) {
        /* Test */
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add((int) (Math.random() * 100));
        }

        System.out.println(arrayList);

        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Integer> sortedList = bubbleSort.sort(arrayList);
        System.out.println(sortedList);
    }
}
