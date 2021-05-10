package main.java.com.pixolestudios;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Each entry in a dialogue must be created as an instance of this linked class
 */
public class DialogueEntry {
    public static int DIdCount = 0;

    private int DId;
    private int parentDId;
    private ArrayList<DialogueEntry> children = new ArrayList<>();
    private String DContent;
    private boolean isOption = true;

    /**
     * Default constructor for a new dialogue entry
     * @param parent the dialogue entry which this follows on from. In the case this is the first entry in a dialogue
     *               this should be set to -1
     * @param content the content of the dialogue, usually a string of text
     * @param isOption the isOption flag signifies whether this piece of dialogue is one that requires an option from
     *                 the user. Questions or dialogue from the NPC speaker should be flagged as false, whilst options
     *                 in response from the player should be flagged as true e.g.
     *                 "Hello Traveller, what is youre name" should be false
     *                 "Steve", "Bob", "Janet" should all be true
     */
    public DialogueEntry(@Nullable DialogueEntry parent, String content, boolean isOption) {
        DId = ++ DIdCount;
        DContent = content;
        if (parent != null){
            parentDId = parent.DId;
            parent.addChild(this);
        } else{
            parentDId = -1;
        }
        this.isOption = isOption;
    }

    public DialogueEntry() {
        this(null, "Default Content", true);
    }

    public DialogueEntry(String content) {
        this(null, content, true);
    }

    public DialogueEntry(DialogueEntry parent) {
        this(parent, "Default Content", true);
    }

    public DialogueEntry(String content, boolean isOption) {
        this(null, content, isOption);
    }

    /**
     * Adds the provided DialogueEntry as a child to the instance of the class calling the method
     * @param child the DialogueEntry to be added to the child of the instance of the class calling the method
     */
    private void addChild(DialogueEntry child){
        children.add(child);
    }

    @Override
    public String toString(){
        return "Id:" + DId + "\nContent:" + DContent +"\nChildren:" + children.size();
    }

    /**
     * Returns the content of all the children of a given DialogueEntry
     * @return the options as a string, with the position labelled
     */
    public String getOptions(){
        String response = "";
        for (int counter = 0; counter < children.size(); counter++) {
            response += counter + ": " + children.get(counter).DContent + ", ";
        }
        return response;
    }

    /**
     * Main function to step through a dialogue tree, allowing the user to select responses
     * @param startPoint The DialogueEntry where the dialogue should begin
     */
    public static void stepThrough(DialogueEntry startPoint){
        if (startPoint.children.size() == 0) return;
        if (!startPoint.isOption){System.out.println(startPoint.DContent);};
        if (startPoint.children.get(0).isOption){
            System.out.println(startPoint.getOptions());
            DialogueEntry selectedChild = selectChild(startPoint.children);
            stepThrough(selectedChild);
        } else {
            DialogueEntry selectedChild = startPoint.children.get(0);
            stepThrough(selectedChild);
        }
    }

    /**
     * Takes the users input from the console to select a specific DialogueEntry from an ArrayList provided
     * @param children the ArrayList<DialogueEntry> that the selection is to be made from
     * @return the selected DialogueEntry
     */
    public static DialogueEntry selectChild(ArrayList<DialogueEntry> children){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        int selection= sc.nextInt();
        return children.get(selection);
    }
}
