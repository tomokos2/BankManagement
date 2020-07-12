package main.java.services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Navigator {
    private static Navigator nav = null;

    private Stage stage;
    private FXMLLoader loader;

    private Navigator() {
        loader = new FXMLLoader();
    }

    private static Navigator get() {
        if (nav == null) {
            nav = new Navigator();
        }
        return nav;
    }

    public static void setStage(Stage s) {
        get().stage = s;
    }

    public static void navigate(String filename) {
        if (get().stage == null) {
            System.err.println("Must initialize navigator with a stage");
            System.exit(1);
        }
        try {
            get().loader.setLocation(
                    new URL("file:///C:/Users/tomok/cs/MyProj/BankManagement/src/main/resources/"
                            + filename));
            AnchorPane a = get().loader.<AnchorPane>load();

            Scene scene = new Scene(a);
            get().stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
