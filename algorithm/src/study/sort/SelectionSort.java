package study.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            int min = data.get(i);
            int minIndex = i;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(j) <= min) {
                    min = data.get(j);
                    minIndex = j;
                }
            }
            Collections.swap(data, i, minIndex);
        }
        return data;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i =0; i < 20; i++) {
            arrayList.add((int) (Math.random() * 100));
        }
        System.out.println(arrayList);

        SelectionSort selectionSort = new SelectionSort();
        ArrayList<Integer> sortedList = selectionSort.sort(arrayList);
        System.out.println(sortedList);
    }
}
