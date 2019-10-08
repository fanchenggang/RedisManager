package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.redis.manager.util.RedisService;

/**
 * @author: FanChengGang
 * @date: 2019-10-08 14:00
 * @describe: TODO
 **/
public class MainTest extends Application {


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

        //左侧列表
        TreeItem<String> rootItem = new TreeItem<> ("mp-dev");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<> ("db" + i);
            for (int j = 0; j < 6; j++) {
                TreeItem<String> item2 = new TreeItem<>("list_"+i);
                item.getChildren().add(item2);
            }
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<> (rootItem);
        a3.getChildren().addAll(tree);

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


    @Override
    public void stop() throws Exception {
        super.stop();
        RedisService.closeAll();
    }
}
