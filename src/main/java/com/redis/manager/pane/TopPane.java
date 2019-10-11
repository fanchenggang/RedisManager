package com.redis.manager.pane;

import com.redis.manager.dialog.MyDialog;
import javafx.scene.control.*;
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
        initMenu();
    }

    public static void initMenu() {
        MenuBar menuBar = new MenuBar();
        MenuItem newConnect = new Menu("New Connect");
        Menu file = new Menu("File");
        file.getItems().add(newConnect);
        newConnect.setOnAction(e -> {

            MyDialog.openEditDialog(null, null);

        });

        menuBar.getMenus().addAll(file);
        pane.getChildren().addAll(menuBar);
    }

}
