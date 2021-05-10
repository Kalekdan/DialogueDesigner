package main.java.com.pixolestudios;


public  class DialogueDesignMain {
    public static void main(String[] args) {
        DialogueEntry q1 = new DialogueEntry("Welcome Traveller", false);
        DialogueEntry q1a1 = new DialogueEntry(q1, "Hello", true);
        DialogueEntry q1a2 = new DialogueEntry(q1, "Goodbye", true);
        DialogueEntry q1a3 = new DialogueEntry(q1, "Hi there", true);

        DialogueEntry q2 = new DialogueEntry(q1a1, "Thanks for saying \"Hello\"", false);
        DialogueEntry q3 = new DialogueEntry(q1a2, "So long", false);
        DialogueEntry q4 = new DialogueEntry(q1a3, "Hi to you too - do you want to buys something?", false);
        DialogueEntry q4a1 = new DialogueEntry(q4, "Yes", true);
        DialogueEntry q4a2 = new DialogueEntry(q4, "No", true);
        DialogueEntry q4a3 = new DialogueEntry(q4, "Definitely not", true);


        DialogueEntry.stepThrough(q1);

    }
}
