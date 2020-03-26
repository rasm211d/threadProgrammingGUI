package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Opg30_1 extends Application {
    String text = "";
    Lock lock = new ReentrantLock();




    @Override
    public void start(Stage primaryStage) throws Exception{
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable printNum = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(printNum);

        thread1.start();
        thread2.start();
        thread3.start();

        primaryStage.setTitle("Hello World");
        TextArea textArea1 = new TextArea(text);
        textArea1.wrapTextProperty().setValue(true);
        VBox vBox = new VBox(textArea1);
        Scene scene = new Scene(vBox, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    class PrintChar implements Runnable {
        private char charToPrint;
        private int times;

        public PrintChar(char c, int t) {
            charToPrint = c;
            times = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < times - 1 ; i++) {
                lock.lock();
                text = text + charToPrint;
                lock.unlock();

            }
        }
    }

    class PrintNum implements Runnable {
        private int lastNum;
        private int num;

        public PrintNum (int l) {
            lastNum = l;
        }


        @Override
        public void run() {
            for (num = 0; num <=lastNum ; num++) {
                lock.lock();
                text = text + num;
                lock.unlock();
            }
        }

    }
}
