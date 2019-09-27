package top.lesson12;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * @author: FanChengGang
 * @date: 2019-09-27 13:54
 * @describe: TODO
 **/
public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setTitle("这里是javafx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);


        TextField textField = new TextField();
    //    textField.setText("这是文本");
        textField.setFont(Font.font(14));
        textField.setLayoutX(100);
        textField.setLayoutY(100);
        Tooltip tooltip = new Tooltip("这是提示");
        textField.setTooltip(tooltip);
        textField.setPromptText("请输入7个字以下");
        textField.setFocusTraversable(false);


        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if (newValue.length()>7){
                textField.setText(oldValue);
            }
        });

        textField.selectedTextProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        ObservableList<Node> children = group.getChildren();
        children.add(textField);

        PasswordField pf = new PasswordField();
        pf.setLayoutX(100);
        pf.setLayoutY(100);


        children.add(pf);

        primaryStage.show();
    }
}
