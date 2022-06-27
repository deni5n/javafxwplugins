package org.domcats.core;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;


public class BasicService extends Application implements Plugin {



    @Override
    public void doJob() {
        launch();
    }

    @Override
    public String name() {
        return "core";
    }

    private void load(Stage stage, URL url){
        try {
            Parent root = FXMLLoader.load(url);
            Scene scene1 = new Scene(root, 700, 400);
            scene1.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            stage.setTitle("JavaFX and Gradle");
            stage.setScene(scene1);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
            Platform.exit();
        }
    }

    private void exit(){
        System.out.println("exit");
        Platform.exit();
    }

    @Override
    public void start(Stage stage) {
        URL resource = getClass().getResource("base_scene.fxml");
        Optional<URL> optionalURL = Optional.ofNullable(resource);
        optionalURL.ifPresentOrElse(url -> load(stage,url), new Thread(this::exit));

    }
}
