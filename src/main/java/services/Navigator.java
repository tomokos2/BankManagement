package main.java.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Singleton that switches the scenes of the stage
 */
public class Navigator {

    // Lazy instantiation
    private static Navigator nav = null;

    // The base stage of the application
    private Stage stage;

    private FXMLLoader loader;

    // Disable constructor
    private Navigator() {
        loader = new FXMLLoader();
    }

    // Return the current instance
    private static Navigator get() {
        if (nav == null) {
            nav = new Navigator();
        }
        return nav;
    }

    /**
     * Initialize the navigator with the base stage
     * Must be called before the navigator can function
     * @param s the Javafx stage that is shown
     */
    public static void setStage(Stage s) {
        get().stage = s;
    }

    /**
     * Switches the scenes of the stage
     * Navigates to a new scene
     * The base must be an AnchorPane
     * @param filename the name of the fxml file that holds the scene - /src/main/resources/
     */
    public static void navigate(String filename) {

        // The navigator must first be initialized
        if (get().stage == null) {
            System.err.println("Must initialize navigator with a stage");
            System.exit(1);
        }

        try {
            // Find the fxml file in the resources folder
            get().loader.setLocation(
                    new URL("file:///C:/Users/tomok/cs/MyProj/BankManagement/src/main/resources/"
                            + filename));

            // Load the file as an AnchorPane
            AnchorPane a = get().loader.<AnchorPane>load();

            // Create a scene from the pane
            Scene scene = new Scene(a);

            // Switch the current scene to the new file scene
            get().stage.setScene(scene);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
