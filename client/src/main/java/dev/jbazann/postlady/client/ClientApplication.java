package dev.jbazann.postlady.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.logging.Logger;

public class ClientApplication {

    public static final Logger logger = Logger.getLogger(ClientApplication.class.getName());

    public static void main(String[] args) {
        Application.launch(UI.class, args);
    }

    public static class UI extends Application {

        @Override
        public void start(Stage stage) {
            WebView view = new WebView();

            StackPane pane = new StackPane(view);
            Scene scene = new Scene(pane, 800, 600);

            scene.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case F2:
                        logger.info("F2: 127.0.0.1:8080");
                        view.getEngine().load("https:// 127.0.0.1:8080");
                        break;
                    case F3:
                        logger.info("F3: jbazann.dev");
                        view.getEngine().load("https://jbazann.dev");
                        break;
                    case F5:
                        logger.info("F5: Reload");
                        view.getEngine().reload();
                        break;
                }
            });

            stage.setTitle("HI I DON'T KNOW WHAT I'M DOING");
            stage.setScene(scene);
            logger.info("Showing stage.");
            stage.show();
        }

    }

}
