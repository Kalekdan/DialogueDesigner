package main.java.com.pixolestudios;

import java.util.ArrayList;

public class AdjacencyEntry {
    private int index;
    private ArrayList<Integer> vals = new ArrayList<>();

    public AdjacencyEntry(int index, int... vals){
        this.index = index;
        for (int val: vals){
            this.vals.add(val);
        }
    }

    public int getIndex() {
        return index;
    }

    public int[] getValsArr() {
        int[] arr = new int[vals.size()];
        for (int counter = 0; counter < vals.size(); counter++) {
            arr[counter] = vals.get(counter);
        }
        return arr;
    }

    public void addVal(int val) {
        this.vals.add(val);
    }
}
