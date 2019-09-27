package top.lesson15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author: FanChengGang
 * @date: 2019-09-27 16:01
 * @describe: TODO
 **/
public class Main extends Application {

    static boolean isManager = false;
    static boolean isVisible = false;
    static int opacityValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        Button b5 = new Button("Button5");
        Button b6 = new Button("Button6");
        Button b7 = new Button("Button7");


//        b3.setManaged(false);
//        b3.setVisible(false);
//        b3.setOpacity(0);


        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #AEEEEEdd");


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(b1, b2, b3, b4);


        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(b5, b6, b7);

        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);

        ap.getChildren().addAll(hBox, vBox);

        Scene scene = new Scene(ap);
        primaryStage.setTitle("这里是Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);

        primaryStage.show();


        b5.setOnAction(event -> {
            b3.setManaged(isManager);
            new Print(hBox);
            if (isManager == true) {
                isManager = false;
            } else {
                isManager = true;
            }
            b5.setText("b3.setManaged(" + isManager + ")");

        });
        b6.setOnAction(event -> {
            System.out.println(isVisible);
            b3.setVisible(isVisible);
            new Print(hBox);
            if (isVisible == true) {
                isVisible = false;
            } else {
                isVisible = true;
            }
            b6.setText("b3.setVisible(" + isVisible + ")");
        });
        b7.setOnAction(event -> {
            new Print(hBox);
            b3.setOpacity(opacityValue);
            if (opacityValue == 0) {
                opacityValue = 1;
            } else {
                opacityValue = 0;
            }
            b7.setText("b3.setOpacity(" + opacityValue + ")");
        });

    }


}

class Print{
    Print(HBox hBox){
        System.out.println("当前HBox数量:"+hBox.getChildren().size());
    }
}
