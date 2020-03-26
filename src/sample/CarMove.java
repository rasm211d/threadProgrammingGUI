package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class CarMove extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        CarPane carPane = new CarPane();
        carPane.setOnMousePressed(e -> carPane.pause());
        carPane.setOnMouseReleased(e -> carPane.play());

        carPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                carPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                carPane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(carPane, 200, 300);
        stage.setScene(scene);
        stage.show();
    }
}
