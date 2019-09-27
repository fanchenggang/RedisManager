package top.lesson9;

import com.sun.javafx.scene.layout.region.BorderImageWidthConverter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @author: FanChengGang
 * @date: 2019-09-27 9:45
 * @describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button("按钮");


        b1.setLayoutX(0);
        b1.setLayoutY(0);

        b1.setFont(Font.font("sans-serif", 100));
        b1.setTextFill(Paint.valueOf("#CD0000"));

        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("#8FBC8F"), new CornerRadii(20), new Insets(10));
        Background bg = new Background(bgf);
        b1.setBackground(bg);

        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#8A2BE2"), BorderStrokeStyle.SOLID,new CornerRadii(20),new BorderWidths(5));
        Border border = new Border(borderStroke);
        b1.setBorder(border);

        b1.setStyle("-fx-background-color: #7CCD7C");

        b1.setOnAction((event -> {
            Object source = event.getSource();
            System.out.println(source);
        }));

        Group group = new Group();

        group.getChildren().add(b1);


        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Java FX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
        System.out.println("test");
    }

}