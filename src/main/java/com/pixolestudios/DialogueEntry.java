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

    public DialogueEntry(@Nullable DialogueEntry parent, String content) {
        DId = ++ DIdCount;
        DContent = content;
        if (parent != null){
            parentDId = parent.DId;
            parent.addChild(this);
        } else{
            parentDId = -1;
        }
    }

    public DialogueEntry() {
        this(null, "Default Content");
    }

    public DialogueEntry(String content) {
        this(null, content);
    }

    public DialogueEntry(DialogueEntry parent) {
        this(parent, "Default Content");
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
        System.out.println(startPoint.DContent);
        System.out.println(startPoint.getOptions());
        DialogueEntry selectedChild = selectChild(startPoint.children);
        stepThrough(selectedChild);
    }

    public static DialogueEntry selectChild(ArrayList<DialogueEntry> children){
        if (children.size() == 1) {return children.get(0);}
        Scanner sc = new Scanner(System.in);    //System.in is a standard input stream
        int selection= sc.nextInt();
        return children.get(selection);
    }
}
