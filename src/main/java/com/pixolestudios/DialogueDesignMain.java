package main.java.com.pixolestudios;


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public  class DialogueDesignMain {
    public static void main(String[] args) {
//        DialogueEntry q1 = new DialogueEntry("Welcome Traveller", false);             #1
//
//        DialogueEntry q1a1 = new DialogueEntry(q1, "Hello", true);            #2
//        DialogueEntry q1a2 = new DialogueEntry(q1, "Goodbye", true);            #3
//        DialogueEntry q1a3 = new DialogueEntry(q1, "Hi there", true);            #4
//
//        DialogueEntry q3 = new DialogueEntry(q1a2, "So long", false);            #5
//        DialogueEntry q4 = new DialogueEntry(q1a3, "Hi to you too - do you want to buys something?", false);            #6
//        q1a1.addChild(q4.getId());
//
//        DialogueEntry q4a1 = new DialogueEntry(q4, "Yes", true);            #7
//        DialogueEntry q4a2 = new DialogueEntry(q4, "No", true);            #8
//        DialogueEntry q4a3 = new DialogueEntry(q4, "Definitely not", true);            #9
//        DialogueEntry q4a4 = new DialogueEntry(q4, "Ask me again", true);            #10
//        q4a4.addChild(q4.getId());
//
//        DialogueEntry q5 = new DialogueEntry(q4a1, "What would you like to buy?", false);            #11
//
//        DialogueEntry q5a1 = new DialogueEntry(q5, "Cheese", true);            #12
//        DialogueEntry q5a2 = new DialogueEntry(q5, "Sweet Roll", true);            #13
//        DialogueEntry q5a3 = new DialogueEntry(q5, "Potion", true);            #14
//        DialogueEntry q5a4 = new DialogueEntry(q5, "Sword", true);            #15
//        DialogueEntry q5a5 = new DialogueEntry(q5, "Armor", true);            #16

        ArrayList<AdjacencyEntry> adjacencyList = new ArrayList<AdjacencyEntry>();
        adjacencyList.add(new AdjacencyEntry(1, 2,3,4));
        adjacencyList.add(new AdjacencyEntry(2, 6));
        adjacencyList.add(new AdjacencyEntry(3, 5));
        adjacencyList.add(new AdjacencyEntry(4, 6));
        adjacencyList.add(new AdjacencyEntry(6, 7,8,9,10));
        adjacencyList.add(new AdjacencyEntry(7, 11));
        adjacencyList.add(new AdjacencyEntry(10, 6));
        adjacencyList.add(new AdjacencyEntry(11, 12,13,14,15,16));

        Dialogue dialogue = new Dialogue("Demo Dialog 1");

        DialogueEntry q1 = new DialogueEntry(dialogue, "Welcome Traveller", false);

        DialogueEntry q1a1 = new DialogueEntry(dialogue, "Hello", true);
        DialogueEntry q1a2 = new DialogueEntry(dialogue, "Goodbye", true);
        DialogueEntry q1a3 = new DialogueEntry(dialogue, "Hi there", true);

        DialogueEntry q3 = new DialogueEntry(dialogue, "So long", false);
        DialogueEntry q4 = new DialogueEntry(dialogue, "Hi to you too - do you want to buys something?", false);

        DialogueEntry q4a1 = new DialogueEntry(dialogue, "Yes", true);
        DialogueEntry q4a2 = new DialogueEntry(dialogue, "No", true);
        DialogueEntry q4a3 = new DialogueEntry(dialogue, "Definitely not", true);
        DialogueEntry q4a4 = new DialogueEntry(dialogue, "Ask me again", true);

        DialogueEntry q5 = new DialogueEntry(dialogue, "What would you like to buy?", false);

        DialogueEntry q5a1 = new DialogueEntry(dialogue, "Cheese", true);
        DialogueEntry q5a2 = new DialogueEntry(dialogue, "Sweet Roll", true);
        DialogueEntry q5a3 = new DialogueEntry(dialogue, "Potion", true);
        DialogueEntry q5a4 = new DialogueEntry(dialogue, "Sword", true);
        DialogueEntry q5a5 = new DialogueEntry(dialogue, "Armor", true);

        dialogue.buildTreeFromAdjacencyList(adjacencyList);
        //dialogue.stepThrough(q1);

        dialogue.exportDialogue();
    }
}
