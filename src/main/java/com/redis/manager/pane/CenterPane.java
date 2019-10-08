package com.redis.manager.pane;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

/**
 * @Package: com.redis.manager.pane
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-10-08 23:30
 * @Describe: TODO
 **/
public class CenterPane {
    public static AnchorPane pane;
     static {
       pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EEEE00");
        init();
    }

    private static void init(){
        Label keyLabel = new Label("String:");
        TextField keyText = new TextField();
        keyText.setText("xxxxx");
        FlowPane flowPane = new FlowPane();


        Label valueLabel = new Label("Value:");

        TextField valueText = new TextField();
        valueText.setPrefHeight(300);
        valueText.setPrefWidth(300);

        flowPane.getChildren().addAll(keyLabel,keyText,valueLabel,valueText);

        pane.getChildren().addAll(flowPane);

    }
}
