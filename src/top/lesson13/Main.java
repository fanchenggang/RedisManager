package top.lesson13;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author: FanChengGang
 * @date: 2019-09-27 14:32
 * @describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("b1");

        b1.setLayoutY(100);
        b1.setLayoutX(100);

        Button b2 = new Button("b2");

        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: #FF3E96");


        pane.setPadding(new Insets(10));

//        AnchorPane.setTopAnchor(b1,10.0);
//        AnchorPane.setLeftAnchor(b1,10.0);


        pane.getChildren().addAll(b1,b2);



        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("...");
            }
        });



        Scene scene = new Scene(pane);
        primaryStage.setTitle("这里是javafx");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);

        primaryStage.setScene(scene);










        primaryStage.show();
    }


}
