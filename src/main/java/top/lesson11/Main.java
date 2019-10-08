package top.lesson11;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * @author: FanChengGang
 * @date: 2019-09-27 13:32
 * @describe: TODO
 **/

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Group group = new Group();

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
        System.out.println("test");


        KeyCodeCombination kccb = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHIFT_DOWN);
        scene.getAccelerators().put(kccb, () -> {
            System.out.println("监听");
        });

    }
        public static void play(){

        }
}