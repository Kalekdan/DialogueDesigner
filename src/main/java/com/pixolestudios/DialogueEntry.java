package main.java.com.pixolestudios;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DialogueEntry {
    public static int DIdCount = 0;

    private int DId;
    private int parentDId;
    private ArrayList<DialogueEntry> children = new ArrayList<>();
    private String DContent;
    private boolean isOption = true;

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

    public int getId() {
        return DId;
    }

    public int getParentId() {
        return parentDId;
    }

    public ArrayList<DialogueEntry> getChildren() {
        return children;
    }

    private void addChild(DialogueEntry child){
        children.add(child);
    }

    public String getContent() {
        return DContent;
    }

    @Override
    public String toString(){
        return "Id:" + DId + "\nContent:" + DContent +"\nChildren:" + children.size();
    }

    public String getOptions(){
        String response = "";
        for (int counter = 0; counter < children.size(); counter++) {
            response += counter + ": " + children.get(counter).DContent + ", ";
        }
        return response;
    }


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

    public static DialogueEntry selectChild(ArrayList<DialogueEntry> children){
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        int selection= sc.nextInt();
        return children.get(selection);
    }
}
