package claxton;

import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrimaryView extends VBox {
    private final Button primaryButton;
    private final PrimaryController controller;

    public PrimaryView(PrimaryController controller) {
        this.controller = controller;

        // Configure VBox
        setAlignment(Pos.CENTER);
        setSpacing(20.0);
        setPadding(new Insets(20.0));

        // Create components
        Label label = new Label("Primary View");
        primaryButton = new Button("Switch to Secondary View");
        primaryButton.setOnAction(e -> {
            try {
                controller.switchToSecondary();
            } catch (IOException ex) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Navigation Error");
                alert.setContentText("Could not switch to secondary view: " + ex.getMessage());
                alert.showAndWait();
            }
        });

        // Add children to VBox
        getChildren().addAll(label, primaryButton);
    }

    public Button getPrimaryButton() {
        return primaryButton;
    }
}