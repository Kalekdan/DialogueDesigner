package main.java.com.pixolestudios;


public  class DialogueDesignMain {
    public static void main(String[] args) {
        DialogueEntry q1 = new DialogueEntry("Welcome Traveller", false);

        DialogueEntry q1a1 = new DialogueEntry(q1, "Hello", true);
        DialogueEntry q1a2 = new DialogueEntry(q1, "Goodbye", true);
        DialogueEntry q1a3 = new DialogueEntry(q1, "Hi there", true);

        DialogueEntry q3 = new DialogueEntry(q1a2, "So long", false);
        DialogueEntry q4 = new DialogueEntry(q1a3, "Hi to you too - do you want to buys something?", false);
        q1a1.addChild(q4.getId());

        DialogueEntry q4a1 = new DialogueEntry(q4, "Yes", true);
        DialogueEntry q4a2 = new DialogueEntry(q4, "No", true);
        DialogueEntry q4a3 = new DialogueEntry(q4, "Definitely not", true);
        DialogueEntry q4a4 = new DialogueEntry(q4, "Ask me again", true);
        q4a4.addChild(q4.getId());

        DialogueEntry q5 = new DialogueEntry(q4a1, "What would you like to buy?", false);

        DialogueEntry q5a1 = new DialogueEntry(q5, "Cheese", true);
        DialogueEntry q5a2 = new DialogueEntry(q5, "Sweet Roll", true);
        DialogueEntry q5a3 = new DialogueEntry(q5, "Potion", true);
        DialogueEntry q5a4 = new DialogueEntry(q5, "Sword", true);
        DialogueEntry q5a5 = new DialogueEntry(q5, "Armor", true);

        DialogueEntry.stepThrough(q1);

    }
}
