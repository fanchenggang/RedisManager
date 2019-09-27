package top.lesson16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author: FanChengGang
 * @date: 2019-09-27 14:32
 * @describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        AnchorPane a1 = new AnchorPane();
        a1.setPrefWidth(100);
        a1.setPrefHeight(100);
        a1.setStyle("-fx-background-color: #EE6AA7");

        AnchorPane a2 = new AnchorPane();
        a2.setPrefWidth(100);
        a2.setPrefHeight(100);
        a2.setStyle("-fx-background-color: #98FB98");

        AnchorPane a3 = new AnchorPane();
        a3.setPrefWidth(100);
        a3.setPrefHeight(100);
        a3.setStyle("-fx-background-color: #A0522D");

        AnchorPane a4 = new AnchorPane();
        a4.setPrefWidth(100);
        a4.setPrefHeight(100);
        a4.setStyle("-fx-background-color: #1E90FF");

        AnchorPane a5 = new AnchorPane();
        a5.setPrefWidth(100);
        a5.setPrefHeight(100);
        a5.setStyle("-fx-background-color: #EEEE00");


        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color: #B23AEE");
        Button button = new Button("test");
//        bor.setTop(button);
        bor.setTop(a1);
        bor.setBottom(a2);
        bor.setLeft(a3);
        bor.setRight(a4);
        bor.setCenter(a5);
   //     bor.setPadding(new Insets(10));
      //  BorderPane.setMargin(a1,new Insets(10));
     //   BorderPane.setAlignment(button, Pos.BOTTOM_LEFT);

        Scene scene = new Scene(bor);
        primaryStage.setTitle("这里是Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        primaryStage.setScene(scene);


        primaryStage.show();
    }


}
