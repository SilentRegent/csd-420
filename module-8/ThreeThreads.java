/*
Zachary Anderson
M8 Three Threads Assignment
11/29/25
This JavaFX application creates three threads that append random letters, digits, and symbols

*/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;


public class ThreeThreads extends Application {

    public static final int OUTPUT_COUNT = 10000;

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        VBox root = new VBox(textArea);
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start three threads
        Thread lettersThread = new Thread(() -> appendRandomLetters(textArea));
        Thread digitsThread = new Thread(() -> appendRandomDigits(textArea));
        Thread symbolsThread = new Thread(() -> appendRandomSymbols(textArea));

        lettersThread.start();
        digitsThread.start();
        symbolsThread.start();
    }

    private void appendRandomLetters(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char letter = (char) ('a' + rand.nextInt(26));
            appendToTextArea(textArea, letter);
        }
    }

    private void appendRandomDigits(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char digit = (char) ('0' + rand.nextInt(10));
            appendToTextArea(textArea, digit);
        }
    }

    private void appendRandomSymbols(TextArea textArea) {
        Random rand = new Random();
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        for (int i = 0; i < OUTPUT_COUNT; i++) {
            char symbol = symbols[rand.nextInt(symbols.length)];
            appendToTextArea(textArea, symbol);
        }
    }

    // Append characters safely on JavaFX Application Thread
    private void appendToTextArea(TextArea textArea, char c) {
        Platform.runLater(() -> textArea.appendText(String.valueOf(c)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
