package top.lesson18;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.Instant;

/**
 * @Package: demo
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 21:52
 * @Describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");


        GridPane grid = new GridPane();

        grid.setStyle("-fx-background-color: #EE6AA7");

        grid.add(b1,0,0);
        grid.add(b2,1,0);
        grid.add(b3,2,0);
        grid.add(b4,3,0);
        grid.add(b5,0,1);
        grid.add(b6,1,1);
        grid.add(b7,2,1);
        grid.add(b8,3,1);

//        grid.setHgap(10);
//
//        grid.setVgap(10);
//
//        grid.setPadding(new Insets(10));

        Scene scene = new Scene(grid);

        primaryStage.setScene(scene);

        primaryStage.setTitle("这里是javafx");
        primaryStage.show();
    }


}
