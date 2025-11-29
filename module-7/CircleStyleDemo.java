import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Four circles
        Circle c1 = new Circle(50);
        Circle c2 = new Circle(50);
        Circle c3 = new Circle(50);
        Circle c4 = new Circle(50);

        // Apply style class to two circles
        c1.getStyleClass().add("whiteBlackStroke");
        c2.getStyleClass().add("whiteBlackStroke");

        // Add dashed border stroke class to some circles
        c1.getStyleClass().add("circleborder");
        c3.getStyleClass().add("circleborder");
        c4.getStyleClass().add("circleborder");

        // Apply IDs to two circles
        c3.setId("redCircle");
        c4.setId("greenCircle");

        // Create a container ONLY for the first circle with the border
        VBox rectangleBox = new VBox(c1);
        rectangleBox.setAlignment(Pos.CENTER);
        rectangleBox.setPadding(new Insets(80, 30, 80, 30)); // Increased vertical padding
        rectangleBox.getStyleClass().add("border");

        // Create an HBox for all circles in a row
        HBox root = new HBox(20, rectangleBox, c2, c3, c4);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 500, 250);

        // Load external stylesheet
        String css = (getClass().getResource("circles.css") != null)
                ? getClass().getResource("circles.css").toExternalForm()
                : new java.io.File("circles.css").toURI().toString();
        scene.getStylesheets().add(css);

        primaryStage.setTitle("Circle Styling Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}