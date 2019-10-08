package com.redis.manager.pane;

import javafx.scene.layout.AnchorPane;

/**
 * @Package: com.redis.manager.pane
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-10-08 23:20
 * @Describe: TODO
 **/
public class TopPane {
    public static AnchorPane pane;
     static {
         pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #B23AEE");

    }
}
