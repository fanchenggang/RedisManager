package com.redis.manager;

import com.redis.manager.pane.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.redis.manager.util.RedisService;

/**
 * @Package: com.redis.manager
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-10-08 23:17
 * @Describe: TODO
 **/
public class Application extends javafx.application.Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane bor = new BorderPane();
    //    bor.setStyle("-fx-background-color: #B23AEE");


        bor.setTop(TopPane.pane);
        bor.setBottom(BottomPane.pane);
        bor.setLeft(LeftPane.pane);
     //   bor.setRight(RightPane.pane);
        bor.setCenter(CenterPane.pane);


        Scene scene = new Scene(bor);
        primaryStage.setTitle("RedisManager");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @Override
    public void stop() throws Exception {
        super.stop();
        RedisService.closeAll();
    }
}

