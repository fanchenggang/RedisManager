package top.lesson4;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @Package: top.lesson4
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 22:56
 * @Describe: TODO
 **/
public class Main3 extends Application {


    public static void main(String[] args) {
        System.out.println("main()=>" + Thread.currentThread().getName());
        launch(args);
        //2.Application.launch(Main.class,args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Stage s1 = new Stage();
        s1.setTitle("s1");

        Stage s2 = new Stage();
        s2.setTitle("s2");

        //设置模态框
        s2.initOwner(s1);
        s2.initModality(Modality.WINDOW_MODAL);

        Stage s3 = new Stage();
        s3.setTitle("s3");


        s1.show();
        s2.show();
        s3.show();


    }


}

