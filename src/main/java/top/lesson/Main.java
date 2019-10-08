package top.lesson;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * @Package: demo.lesson
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 22:08
 * @Describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        System.out.println("main()=>"+Thread.currentThread().getName());
        launch(args);
        //2.Application.launch(Main.class,args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start()=>"+Thread.currentThread().getName());
        primaryStage.setTitle("JavaFX");

        primaryStage.getIcons().add(new Image("/miaopost.png"));
        primaryStage.show();
    }
}
