package top.lesson3;

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
        System.out.println("main()=>" + Thread.currentThread().getName());
        launch(args);
        //2.Application.launch(Main.class,args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start()=>" + Thread.currentThread().getName());
        primaryStage.setTitle("JavaFX");

        primaryStage.getIcons().add(new Image("top/icon/miaopost.png"));
        // primaryStage.setIconified(true); 设置最小化
        // primaryStage.setMaximized(true); 设置最大化

//        primaryStage.setMaxWidth(800);
//        primaryStage.setMaxHeight(800);
//        primaryStage.setMinWidth(300);
//        primaryStage.setMinHeight(300);


        primaryStage.heightProperty()
                .addListener((observable, oldValue, newValue) -> {
                            System.out.println(newValue.intValue());
                        }
                );

        primaryStage.widthProperty()
                .addListener((observable, oldValue, newValue) -> {
                    System.out.println(newValue.intValue());
                });

        primaryStage.show();

        //primaryStage.setResizable(false);//设置不可改变窗口大小
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
//设置全屏
//        primaryStage.setFullScreen(true);
//        primaryStage.setScene(new Scene(new Group()));
        //primaryStage.close();//关闭
    }
}
