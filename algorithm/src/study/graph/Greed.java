package study.graph;

import java.util.ArrayList;
import java.util.Collections;

public class Greed {

    public ArrayList<Action> greedy(ArrayList<Action> list) {
        int time = 0;
        ArrayList<Action> ans = new ArrayList<Action>();

        for (Action act : list) {
            if (time <= act.startTime) {
                time = act.endTime;
                ans.add(act);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Action> list = new ArrayList<>();
        list.add(new Action("A", 7, 8));
        list.add(new Action("B", 5, 7));
        list.add(new Action("C", 3, 6));
        list.add(new Action("D", 1, 2));
        list.add(new Action("E", 6, 9));
        list.add(new Action("F", 10, 11));

        Collections.sort(list);
        System.out.println(list);

        ArrayList<Action> ans = new Greed().greedy(list);
        System.out.println(ans);

    }

    static class Action implements Comparable<Action> {
        String name;
        int startTime;
        int endTime;

        public Action(String name, int startTime, int endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Action action) {
            return this.endTime - action.endTime;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}
