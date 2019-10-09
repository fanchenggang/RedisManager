package com.redis.manager.pane;

import com.redis.manager.model.RowData;
import com.redis.manager.util.RedisService;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.List;
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


    static {
        pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EE6AA7");
        initDbTree();
    }

    public static void initDbTree() {

        //左侧列表
        TreeItem<String> rootItem = new TreeItem<>("mp-dev");
        rootItem.setExpanded(true);

        List<RedisService.Db> dbList = RedisService.getDbList();
        dbList.forEach(d -> {
            TreeItem<String> item = new TreeItem<>(d.getName() + "(" + d.getCount().toString() + ")");
            rootItem.getChildren().add(item);
        });

        TreeView<String> tree = new TreeView<>(rootItem);
        tree.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getClickCount() == 2) {
                TreeItem selectedItem = tree.getSelectionModel().getSelectedItem();
                String value = (String) selectedItem.getValue();
                TreeItem<String> selectedParentItem = selectedItem.getParent();
                if (selectedParentItem == null){
                    return;
                }
                if (selectedParentItem.getValue().startsWith("db")) {
                    String type = RedisService.getType(value);
                    if (type.equals("string")) {
                        String v = RedisService.getKey(value);
                        CenterPane.viewText();
                        CenterPane.keyText.setText(value);
                        CenterPane.valueArea.setText(v);
                        return;
                    } else if (type.equals("list")) {
                        CenterPane.viewList();
                        CenterPane.keyText.setText(value);
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

        //左侧列表

        pane.getChildren().addAll(tree);
    }
}
