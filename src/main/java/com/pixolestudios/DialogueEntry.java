package main.java.com.pixolestudios;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

/**
 * Each entry in a dialogue must be created as an instance of this linked class
 */
public class DialogueEntry {
    public static int DIdCount = 0;

    private int DId;
    private int parentDId;
    private Dialogue ownerDialogue;
    private ArrayList<DialogueEntry> children = new ArrayList<>();
    private String DContent;
    private boolean isOption = true;

    /**
     * Default constructor for a new dialogue entry
     * @param ownerDialogue The Dialogue object to which this entry belongs
     * @param parent the dialogue entry which this follows on from. In the case this is the first entry in a dialogue
     *               this should be set to -1
     * @param content the content of the dialogue, usually a string of text
     * @param isOption the isOption flag signifies whether this piece of dialogue is one that requires an option from
     *                 the user. Questions or dialogue from the NPC speaker should be flagged as false, whilst options
     *                 in response from the player should be flagged as true e.g.
     *                 "Hello Traveller, what is your name" should be false
     *                 "Steve", "Bob", "Janet" should all be true
     */
    public DialogueEntry(Dialogue ownerDialogue, @Nullable DialogueEntry parent, String content, boolean isOption) {
        DId = ++ DIdCount;
        this.ownerDialogue = ownerDialogue;
        DContent = content;
        if (parent != null){
            parentDId = parent.DId;
            parent.addChild(this);
        } else{
            parentDId = -1;
        }
        this.isOption = isOption;
        ownerDialogue.addEntries(this);
    }

    public DialogueEntry(Dialogue ownerDialogue, int parentId, String content, boolean isOption) {
        this(ownerDialogue, ownerDialogue.getEntryById(parentId), content, isOption);
    }

    public DialogueEntry(Dialogue ownerDialogue, String content, boolean isOption) {
        this(ownerDialogue, null, content, isOption);
    }

    public ArrayList<DialogueEntry> getChildren() {
        return children;
    }

    /**
     * Returns a comma separated list of the ids of the children for the given entry. Where there
     * are no children, an empty string is returned
     * @return comma separated list or empty string
     */
    public String getChildrenAsStringList(){
        String returnStr = "";
        for (DialogueEntry child: children){
            returnStr += child.getId() + ",";
        }
        int len = returnStr.length();
        return len == 0 ? "" : returnStr.substring(0, len - 1);
    }

    public boolean isOption() {
        return isOption;
    }

    public String getContent() {
        return DContent;
    }

    /**
     * Adds the provided DialogueEntry as a child to the instance of the class calling the method
     * @param child the DialogueEntry to be added to the child of the instance of the class calling the method
     */
    public void addChild(DialogueEntry child){
        children.add(child);
    }

    public void addChild(int childId){
        addChild(ownerDialogue.getEntryById(childId));
    }

    public void addChildren(DialogueEntry... children){
        for (DialogueEntry child : children) {
            addChild(child);
        }
    }
    public void addChildren(int... children){
        for (int child : children) {
            addChild(child);
        }
    }

    @Override
    public String toString(){
        return "Id:" + DId + "\nContent:" + DContent +"\nChildren:" + children.size();
    }

    public int getId() {
        return DId;
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


}
