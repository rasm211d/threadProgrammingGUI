package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Opg32_2 extends Application {
    Timeline animation;


    @Override
    public void start(Stage stage) throws Exception {
        CarPane carPane = new CarPane();
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> carPane.moveCar()));
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    animation.setCycleCount(Timeline.INDEFINITE);
                    animation.play();

                } catch (Exception e) {

                }
            }
        }).start();

        Scene scene = new Scene(carPane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}
