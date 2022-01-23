package study.sort;

import java.util.ArrayList;

public class MergeSort {
    /*
    * 병합정렬의 시간복잡도는 O(NlogN)
    * */
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        if (dataList.size() <= 1) {
            return dataList;
        }
        int medium = dataList.size() / 2;

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        leftList = sort(new ArrayList<>(dataList.subList(0, medium)));
        rightList = sort(new ArrayList<>(dataList.subList(medium, dataList.size())));

        return mergeList(leftList, rightList);

    }

    public ArrayList<Integer> mergeList(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftList.size() > leftIndex && rightList.size() > rightIndex) {
            if (leftList.get(leftIndex) > rightList.get(rightIndex)) {
                mergedList.add(rightList.get(rightIndex));
                rightIndex += 1;
            } else {
                mergedList.add(leftList.get(leftIndex));
                leftIndex += 1;
            }
        }

        while (leftList.size() > leftIndex) {
            mergedList.add(leftList.get(leftIndex));
            leftIndex += 1;
        }

        while (rightList.size() > rightIndex) {
            mergedList.add(rightList.get(rightIndex));
            rightIndex += 1;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testDataList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            testDataList.add((int) (Math.random() * 100));
        }

        MergeSort mergeSort = new MergeSort();
        System.out.println(mergeSort.sort(testDataList));
    }
}
