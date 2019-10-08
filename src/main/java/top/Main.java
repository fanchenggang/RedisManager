package top;

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


        AnchorPane ta = new AnchorPane();
        ta.setPrefWidth(100);
        ta.setPrefHeight(50);
        ta.setStyle("-fx-background-color: #EE6AA7");

        Button button = new Button("connet");
        ta.getChildren().add(button);


        AnchorPane ba = new AnchorPane();
        ba.setPrefWidth(100);
        ba.setPrefHeight(100);
        ba.setStyle("-fx-background-color: #98FB98");

        AnchorPane la = new AnchorPane();
        la.setPrefWidth(150);
        la.setPrefHeight(100);
        la.setStyle("-fx-background-color: #A0522D");

        AnchorPane ra = new AnchorPane();
        ra.setPrefWidth(100);
        ra.setPrefHeight(100);
        ra.setStyle("-fx-background-color: #1E90FF");

        AnchorPane ca = new AnchorPane();
        ca.setPrefWidth(100);
        ca.setPrefHeight(100);
        ca.setStyle("-fx-background-color: #EEEE00");


        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color: #B23AEE");

        bor.setTop(ta);
        bor.setBottom(ba);
        bor.setLeft(la);
        bor.setRight(ra);
        bor.setCenter(ca);

        Scene scene = new Scene(bor);
        primaryStage.setTitle("redis-manager");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        primaryStage.setScene(scene);


        primaryStage.show();
    }


}
