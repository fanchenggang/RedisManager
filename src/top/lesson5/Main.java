package top.lesson5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * @Package: top.lesson5
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 23:20
 * @Describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Platform.runLater(()->{
            System.out.println("runLater");
            int i = 1;
            while (i<=10){
                System.out.println("i=" + i);
                i = i+1;
            }

        });

    }


}
