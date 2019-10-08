package top.lesson4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @Package: top.lesson4
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 22:56
 * @Describe: TODO
 **/
public class Main2 extends Application {


    public static void main(String[] args) {
        System.out.println("main()=>" + Thread.currentThread().getName());
        launch(args);
        //2.Application.launch(Main.class,args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Stage s1 = new Stage();
        Stage s2 = new Stage();
        Stage s3 = new Stage();
        Stage s4 = new Stage();
        Stage s5 = new Stage();
        s1.initStyle(StageStyle.DECORATED);
        s2.initStyle(StageStyle.TRANSPARENT);
        s3.initStyle(StageStyle.UNDECORATED);
        s4.initStyle(StageStyle.UNIFIED);
        s5.initStyle(StageStyle.UTILITY);
        s1.show();
        s2.show();
        s3.show();
        s4.show();
        s5.show();
//        Platform.exit(); //关闭全部窗口
    }


}

