package top.lesson7;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * @Package: top.lesson7
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 23:39
 * @Describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        //HostServices hostServices = getHostServices();
       // hostServices.showDocument("www.baidu.com");

        Button button = new Button("按钮");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        button.setCursor(Cursor.CLOSED_HAND);


        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);
      //  scene.setCursor(Cursor.CLOSED_HAND);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
        System.out.println("test");
    }


}
