package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BallBounce extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BallPane ballPane = new BallPane();
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(ballPane, 200, 300);
        stage.setScene(scene);
        stage.show();
    }
}
