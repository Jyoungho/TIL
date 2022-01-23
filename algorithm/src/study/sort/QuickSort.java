package study.sort;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        // 만약 dataList 의 사이즈가 1이면, pivot 을 List 로 반환해주면 된다.
        if (dataList.size() <= 1) {
            return dataList;
        }

        int pivot = dataList.get(0);

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < dataList.size(); i++) {
            if (dataList.get(i) < pivot) {
                leftList.add(dataList.get(i));
            } else {
                rightList.add(dataList.get(i));
            }
        }

        result.addAll(sort(leftList));
        result.addAll(Collections.singletonList(pivot));
        result.addAll(sort(rightList));

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataList.add((int) (Math.random() * 100));
        }
        System.out.println("======start=====");
        System.out.println(dataList);

        QuickSort quickSort = new QuickSort();
        ArrayList<Integer> result = quickSort.sort(dataList);

        System.out.println("======result=====");
        System.out.println(result);
    }
}
