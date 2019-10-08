package com.redis.manager.pane;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

/**
 * @Package: com.redis.manager.pane
 * @Author: FanChengGang
 * @QQ:451922429
 * @Email:fancg@outlook.com
 * @CreateDate: 2019-10-08 23:19
 * @Describe: TODO
 **/
public class LeftPane {

    public static AnchorPane pane;


    static {
        pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EE6AA7");
        initDbTree();
    }
    public static void initDbTree(){
        //左侧列表
        TreeItem<String> rootItem = new TreeItem<>("mp-dev");
        rootItem.setExpanded(true);
        for (int i = 1; i < 6; i++) {
            TreeItem<String> item = new TreeItem<>("db" + i);
            for (int j = 0; j < 6; j++) {
                TreeItem<String> item2 = new TreeItem<>("list_" + i);
                item.getChildren().add(item2);
            }
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<>(rootItem);
        pane.getChildren().addAll(tree);
    }
}
