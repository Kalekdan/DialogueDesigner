package main.java.com.pixolestudios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dialogue {

    private String dialogueName;
    private ArrayList<DialogueEntry> DEntries =  new ArrayList<>();

    public Dialogue(String name){
        dialogueName = name;
    }

    public void addEntries(DialogueEntry entry){
        DEntries.add(entry);
    }

    public void setDialogueName(String name){
        this.dialogueName = name;
    }

    /**
     * Main function to step through a dialogue tree, allowing the user to select responses
     * @param startPoint The DialogueEntry where the dialogue should begin
     */
    public void stepThrough(DialogueEntry startPoint){
        if (startPoint.getChildren().size() == 0) return;
        if (!startPoint.isOption()){System.out.println(startPoint.getContent());};
        if (startPoint.getChildren().get(0).isOption()){
            System.out.println(startPoint.getOptions());
            DialogueEntry selectedChild = selectChild(startPoint.getChildren());
            stepThrough(selectedChild);
        } else {
            DialogueEntry selectedChild = startPoint.getChildren().get(0);
            stepThrough(selectedChild);
        }
    }

    /**
     * Calls stepThrough(DialogueEntry) with the entry found from the id provided
     * @param startId the id for the entry to start the dialogue
     */
    public void stepThrough(int startId){
        stepThrough(getEntryById(startId));
    }

    /**
     * Takes the users input from the console to select a specific DialogueEntry from an ArrayList provided
     * @param children the ArrayList<DialogueEntry> that the selection is to be made from
     * @return the selected DialogueEntry
     */
    public DialogueEntry selectChild(ArrayList<DialogueEntry> children){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        int selection= sc.nextInt();
        return children.get(selection);
    }

    /**
     * Connects the entries together in parent child relationships based on the adjacency list provided
     * @param adjacencyList An ArrayList of AdjacencyEntry objects to form an adjacency list
     */
    public void buildTreeFromAdjacencyList(ArrayList<AdjacencyEntry> adjacencyList){
        for (AdjacencyEntry x : adjacencyList){
            getEntryById(x.getIndex()).addChildren(x.getValsArr());
        }
    }

    /**
     * Get the DialogueEntry object which has the provided id
     * @param EntryId the id to lookup
     * @return DialogueEntry with the matching id, or null if not present
     */
    public DialogueEntry getEntryById(int EntryId) {
        for (DialogueEntry dEntry : DEntries) {
            if (dEntry.getId() == EntryId) {
                return dEntry;
            }
        }
        return null;
    }

    /**
     * Exports the dialogue to 2 files, one with an adjacency list showing parent child relationships, and one showing
     * the content of the dialogue entry
     */
    public void exportDialogue(){
        try {
            FileWriter adjacencyFile = new FileWriter(this.dialogueName + "_adjacencyList.txt");
            FileWriter entryDetailsFile = new FileWriter(this.dialogueName + "_entryDetails.txt");
            adjacencyFile.write("id,children\n");
            entryDetailsFile.write("id,content,isOption\n");
            for (DialogueEntry entry : DEntries){
                String childList = entry.getChildrenAsStringList();
                if (!childList.equals("")){
                    adjacencyFile.write(entry.getId() + "," + childList + "\n");
                }
                entryDetailsFile.write(entry.getId() + ",\"" + entry.getContent() + "\"," + entry.isOption() + "\n");
            }
            adjacencyFile.close();
            entryDetailsFile.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}