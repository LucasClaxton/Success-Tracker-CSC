package claxton;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SecondaryView extends VBox {
    private final Button secondaryButton;
    private final SecondaryController controller;

    public SecondaryView(SecondaryController controller) {
        this.controller = controller;

        // Configure VBox
        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0));

        // Create components
        Label label = new Label("Secondary View");
        secondaryButton = new Button("Switch to Primary View");
        secondaryButton.setOnAction(e -> {
            try {
                controller.switchToPrimary();
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Navigation Error");
                alert.setContentText("Could not switch to primary view: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Add children to VBox
        getChildren().addAll(label, secondaryButton);
    }

    public Button getSecondaryButton() {
        return secondaryButton;
    }
}