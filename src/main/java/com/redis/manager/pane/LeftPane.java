package com.redis.manager.pane;

import com.redis.manager.config.UserConfig;
import com.redis.manager.dialog.MyDialog;
import com.redis.manager.model.RedisClient;
import com.redis.manager.model.RowData;
import com.redis.manager.util.RedisService;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public static TreeItem<String> rootItem = new TreeItem<>("root");

    public static boolean initDbListFlag = false;

    static {
        pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EE6AA7");
        initDbTree();
    }

    public static void initDbTree() {

        TreeView<String> treeView = new TreeView<>(rootItem);
        Map<String, RedisClient> clientMap = RedisService.redisClientMap;
        clientMap.forEach((k, v) -> {
            createConnectView(k);
        });

        treeView.setShowRoot(false);
        treeView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getClickCount() > 0 && e.getButton().equals(MouseButton.PRIMARY)) {
                TreeItem selectedItem = treeView.getSelectionModel().getSelectedItem();
                if (selectedItem == null) {
                    return;
                }
                String value = (String) selectedItem.getValue();
                TreeItem<String> selectedParentItem = selectedItem.getParent();
                if (selectedParentItem == null) {
                    return;
                }
                if (selectedParentItem.getValue().equals("root")) {
                    if (selectedItem.getChildren().size() == 0 && initDbListFlag == false) {

                        List<RedisService.Db> dbList = null;
                        try {
                            initDbListFlag = true;
                            dbList = RedisService.getDbList(value);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            return;
                        }finally {
                            initDbListFlag = false;

                        }
                        dbList.forEach(d -> {
                            TreeItem<String> item = new TreeItem<>(d.getName() + "(" + d.getCount().toString() + ")");
                            selectedItem.getChildren().add(item);
                        });
                        selectedItem.setExpanded(true);

                    }else{
                        return;
                    }
                }
                if (selectedParentItem.getValue().startsWith("db")) {
                    String type = RedisService.getType(value);
                    if (type.equals("string")) {

                        CenterPane.viewText(selectedItem);

                        return;
                    } else if (type.equals("list")) {
                        CenterPane.viewList(selectedItem);

                        List<String> valueList = RedisService.lrange(value);
                        for (int i = 0; i < valueList.size(); i++) {
                            RowData data = new RowData(i, valueList.get(i));
                            CenterPane.listData.add(data);
                        }
                        return;
                    }
                }
                if (!value.startsWith("db")) {
                    return;
                }
                ObservableList children = selectedItem.getChildren();
                children.remove(0, children.size() - 1);
                Set<String> keyList = RedisService.getAllKeyList(Integer.parseInt(String.valueOf(value.charAt(2))));
                keyList.forEach(k -> {
                    TreeItem<String> item = new TreeItem<>(k);
                    selectedItem.getChildren().add(item);
                });
                selectedItem.setExpanded(true);
            }
        });
        pane.getChildren().addAll(treeView);
    }


    public static void createConnectView(String connectName){
        TreeItem<String> treeItem = new TreeItem<>(connectName);
        treeItem.setExpanded(true);

        HBox hBox = new HBox();
        Button del = new Button("Del");
        Button edit = new Button("Edit");
        hBox.getChildren().addAll(del,edit);
        hBox.setPadding(new Insets(0,0,0,20));
        treeItem.setGraphic(hBox);

        del.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            UserConfig.removeRedisClient(treeItem.getValue());
            rootItem.getChildren().remove(treeItem);
        });
        edit.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            MyDialog.openEditDialog(RedisService.redisClientMap.get(treeItem.getValue()),treeItem);
        });

        rootItem.getChildren().add(treeItem);
    }



}
