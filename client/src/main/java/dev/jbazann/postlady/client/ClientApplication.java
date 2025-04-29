package dev.jbazann.postlady.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

public class ClientApplication {

    public static final Logger LOGGER = Logger.getLogger(ClientApplication.class.getSimpleName());

    public static void main(String[] args) throws IOException {
        Application.launch(UI.class, args);
    }

    public static class UI extends Application {

        @Override
        public void start(Stage stage) {
            WebView view = new WebView();
            WebEngine engine = view.getEngine();

            engine.setOnError(event -> {
                LOGGER.warning("WebEngine error: " + event.getMessage());
            });

            engine.setOnAlert(event -> {
                LOGGER.warning("JavaScript Alert: " + event.getData());
            });

            VBox vbox = new VBox(view);
            VBox.setVgrow(view, Priority.ALWAYS);
            Scene scene = getScene(vbox, engine);

            stage.setTitle("HI I DON'T KNOW WHAT I'M DOING");
            stage.setScene(scene);

            LOGGER.info("Showing stage.");
            stage.show();
        }

        private static Scene getScene(VBox layout, WebEngine engine) {
            Scene scene = new Scene(layout);
            scene.setOnKeyPressed(event -> {
                switch (event.getCode()) {
                    case F1 -> {
                    }
                    case F2 -> {
                        LOGGER.info("F2: http://localhost:8080");
                        engine.load("http://localhost:8080");
                    }
                    case F3 -> {
                        LOGGER.info("F3: https://jbazann.dev");
                        engine.load("https://jbazann.dev");
                    }
                    case F5 -> {
                        LOGGER.info("F5: Reload");
                        engine.reload();
                    }
                    case F6 -> {
                        Object location = engine.executeScript("document.location.href");
                        LOGGER.info("F6: " + location.toString());
                    }
                }
            });
            return scene;
        }

    }

}
