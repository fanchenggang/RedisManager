package top.lesson8;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * @author: FanChengGang
 * @date: 2019-09-27 9:45
 * @describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");


        b1.setLayoutX(0);
        b1.setLayoutY(0);

        b2.setLayoutX(200);
        b2.setLayoutY(0);


        b3.setLayoutX(400);
        b3.setLayoutY(0);


        Group group = new Group();
        ObservableList<Node> children = group.getChildren();
        children.addAll(b1, b2, b3);
        group.setOpacity(0.5);


        //判断该位置是否有组件
        boolean contains = group.contains(0, 0);
        System.out.println(contains);


        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
        System.out.println("test");
    }

}