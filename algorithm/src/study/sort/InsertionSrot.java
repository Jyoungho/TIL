package study.sort;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSrot {
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (data.get(j) < data.get(j - 1)) {
                    Collections.swap(data, j, j - 1);
                } else {
                    break;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add((int) (Math.random() * 100));
        }

        System.out.println(arrayList);

        InsertionSrot insertionSrot = new InsertionSrot();
        ArrayList<Integer> sortedList = insertionSrot.sort(arrayList);
        System.out.println(sortedList);
    }
}
