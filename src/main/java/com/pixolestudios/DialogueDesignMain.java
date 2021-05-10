package main.java.com.pixolestudios;


public  class DialogueDesignMain {
    public static void main(String[] args) {
        DialogueEntry q1 = new DialogueEntry("Welcome Traveller");
        DialogueEntry q1a1 = new DialogueEntry(q1, "Hello");
        DialogueEntry q1a2 = new DialogueEntry(q1, "Goodbye");
        DialogueEntry q1a3 = new DialogueEntry(q1, "Hi there");

        DialogueEntry q2 = new DialogueEntry(q1a1, "Thanks for saying \"Hello\"");
        DialogueEntry q3 = new DialogueEntry(q1a2, "So long");
        DialogueEntry q4 = new DialogueEntry(q1a3, "Hi to you too - do you want to buys something?");
        DialogueEntry q4a1 = new DialogueEntry(q4, "Yes");
        DialogueEntry q4a2 = new DialogueEntry(q4, "No");
        DialogueEntry q4a3 = new DialogueEntry(q4, "Definitely not");


        DialogueEntry.stepThrough(q1);

    }
}
