package main.java.com.pixolestudios;

import java.util.ArrayList;

/**
 * A entry in an adjacency list, with an index and array of values relating to that index
 * In terms of a dialogue, the index is the dialogue entry, and the vals are the options
 */
public class AdjacencyEntry {
    private int index;
    private ArrayList<Integer> vals = new ArrayList<>();

    /**
     * Constructor for an adjacency entry by specifying the dialogue entries by their unique id
     * @param index id of the dialogue entry to be the index of the adjacency list entry
     * @param vals tuple of ids of dialogue entries
     */
    public AdjacencyEntry(int index, int... vals){
        this.index = index;
        for (int val: vals){
            this.vals.add(val);
        }
    }

    /**
     * Constructor for an adjacency entry by specifying the dialogue entries, converted to ids internally
     * @param entry dialogue entry as the index
     * @param children tuple list of entries for children
     */
    public AdjacencyEntry(DialogueEntry entry, DialogueEntry... children){
        this.index = entry.getId();
        for (DialogueEntry d : children){
            this.vals.add(d.getId());
        }
    }

    public int getIndex() {
        return index;
    }

    /**
     * Returns an integer array of the values in the adjacency list entry
     * @return int[] array of ids
     */
    public int[] getValsArr() {
        int[] arr = new int[vals.size()];
        for (int counter = 0; counter < vals.size(); counter++) {
            arr[counter] = vals.get(counter);
        }
        return arr;
    }

    /**
     * Returns an array of dialogue entries of the values in the adjacency list entry
     * @param dialogue the dialogue to which the entries belong
     * @return DialogueEntry[] array of entries
     */
    public DialogueEntry[] getEntriesArr(Dialogue dialogue) {
        DialogueEntry[] arr = new DialogueEntry[vals.size()];
        for (int counter = 0; counter < vals.size(); counter++) {
            arr[counter] = dialogue.getEntryById(vals.get(counter));
        }
        return arr;
    }

    public void addVal(int val) {
        this.vals.add(val);
    }
}
