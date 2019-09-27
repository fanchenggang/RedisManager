package top.lesson14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #AEEEEEdd");


        HBox box = new HBox();
        box.setStyle("-fx-background-color: #E066FF");
        box.setPrefWidth(200);
        box.setPrefHeight(200);



        box.getChildren().addAll(b1,b2,b3);

        box.setPadding(new Insets(10));
        box.setSpacing(10);
        HBox.setMargin(b1,new Insets(10));

        box.setAlignment(Pos.CENTER);

        ObservableList<Node> apChildren = ap.getChildren();
        apChildren.add(box);


        //VBox vBox = new VBox();


        Scene scene = new Scene(ap);
        primaryStage.setTitle("这里是Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        primaryStage.setScene(scene);


        primaryStage.show();
    }


}
