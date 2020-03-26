package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.sql.Time;

public class CarPane extends Pane {
    private double x = 0;
    private double y = 100;
    private double radius = 5;
    private Rectangle rectangle;
    private Polygon polygon;
    private Circle circle1;
    private Circle circle2;
    private Timeline animation;

    public CarPane() {
        drawcar();
        //animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveCar()));
        //animation.setCycleCount(Timeline.INDEFINITE);
        //animation.play();

    }

    private void drawcar() {
        getChildren().clear();
        rectangle = new Rectangle(x, y-20, 50, 10);
        polygon = new Polygon(x +10, y-20, x + 20, y-30, x+30, y-30, x+40, y-20);
        circle1 = new Circle(x + 15, y-5, radius);
        circle2 = new Circle(x + 35, y-5, radius);
        getChildren().addAll(rectangle,polygon,circle1,circle2);
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 1.0);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1.0 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }



    protected void moveCar() {
        if (x <= getWidth()) {
            x += 1;
        }
        else {
            x=0;
        }
        drawcar();
    }
}
