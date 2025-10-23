/*
 * Zachary Anderson
 * M1 Programming Assignment
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomCardsDisplay extends Application {

    private final String CARD_PATH = "C:\\csd\\csd-420\\module-1\\cards\\";
 // Folder containing card images
    private ImageView[] cardViews = new ImageView[4];

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        HBox cardBox = new HBox(10);

        // Initialize ImageViews
        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(100);
            cardViews[i].setFitHeight(150);
            cardBox.getChildren().add(cardViews[i]);
        }

        Button refreshButton = new Button("Refresh Cards");

        // Lambda Expression for button click
        refreshButton.setOnAction(e -> displayRandomCards());

        root.getChildren().addAll(cardBox, refreshButton);

        displayRandomCards(); // Initial display

        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Random Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRandomCards() {
        try {
            // Create a list of card numbers 1-52
            List<Integer> cardNumbers = new ArrayList<>();
            for (int i = 1; i <= 52; i++) {
                cardNumbers.add(i);
            }

            // Shuffle and pick first 4 cards
            Collections.shuffle(cardNumbers);

            for (int i = 0; i < 4; i++) {
                String imagePath = CARD_PATH + cardNumbers.get(i) + ".png";
                cardViews[i].setImage(new Image(new FileInputStream(imagePath)));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}