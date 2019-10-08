package top.lesson19;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;




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


        StackPane stack = new StackPane();
        stack.setStyle("-fx-background-color: #EE6AA7");

        stack.getChildren().addAll(b1,b2,b3,b4,b5);



        Scene scene = new Scene(stack);


        primaryStage.setScene(scene);
        primaryStage.setTitle("这里是javafx");
        primaryStage.show();
    }


}
