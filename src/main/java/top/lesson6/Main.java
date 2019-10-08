package top.lesson6;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @Package: top.lesson7
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-09-26 23:29
 * @Describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Screen screen = Screen.getPrimary();

        Rectangle2D rec1 = screen.getBounds();


        Rectangle2D rec2 = screen.getVisualBounds();

        System.out.println("left x = "+rec1.getMinX()+", right y = "+rec1.getMinY());
        System.out.println("left x = "+rec1.getMaxX()+", right y = "+rec1.getMaxY());
        System.out.println("w x = "+rec1.getWidth()+", h y = "+rec1.getHeight());

        System.out.println("left x = "+rec2.getMinX()+", right y = "+rec2.getMinY());
        System.out.println("left x = "+rec2.getMaxX()+", right y = "+rec2.getMaxY());
        System.out.println("w x = "+rec2.getWidth()+", h y = "+rec2.getHeight());

        double dpi = screen.getDpi();
        System.out.println(dpi);
    }


}
