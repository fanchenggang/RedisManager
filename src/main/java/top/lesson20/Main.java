package top.lesson20;

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
        Text t1 = new Text("text1");
        Text t2 = new Text("text2");
        Text t3 = new Text("text3");



        TextFlow textFlow = new TextFlow();
       // textFlow.setStyle("-fx-background-color: #EE6AA7");

        textFlow.getChildren().addAll(t1,t2,t3);



        Scene scene = new Scene(textFlow);


        primaryStage.setScene(scene);
        primaryStage.setTitle("这里是javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }


}
