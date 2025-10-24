package claxton;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static PrimaryController primaryController;
    private static SecondaryController secondaryController;

    @Override
    public void start(Stage stage) throws IOException {
        primaryController = new PrimaryController();
        secondaryController = new SecondaryController();

        scene = new Scene(createPrimaryView(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String viewName) throws IOException {
        scene.setRoot(viewName.equals("primary") ? createPrimaryView() : createSecondaryView());
    }

    private static Parent createPrimaryView() {
        return new PrimaryView(primaryController);
    }

    private static Parent createSecondaryView() {
        return new SecondaryView(secondaryController);
    }

    public static void main(String[] args) {
        launch();
    }

}