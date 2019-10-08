package top.lesson4;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @Package: top.lesson4
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 22:56
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

        //设置透明度
//        primaryStage.setOpacity(0.5);
        //设置置顶
//        primaryStage.setAlwaysOnTop(true);

        primaryStage.setX(100);
        primaryStage.setY(100);

        primaryStage.xProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("x->"+newValue.intValue());
        });

        primaryStage.yProperty().addListener((observable, oldValue, newValue) ->{
            System.out.println("y->"+newValue.intValue());
        });

        primaryStage.show();
    }


}

