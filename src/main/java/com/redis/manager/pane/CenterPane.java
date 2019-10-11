package com.redis.manager.pane;

import com.redis.manager.dialog.MyDialog;
import com.redis.manager.model.RowData;
import com.redis.manager.util.RedisService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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


    public static TextArea valueArea = new TextArea();
  //  public static TextField keyText = new TextField();

    public static ObservableList<RowData> listData = FXCollections.observableArrayList();


    static {
        pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EEEE00");

    }

    static Label StringKeyLabel = new Label("STRING: ");
    static Label ListKeyLabel = new Label("List: ");

    public static void viewText(TreeItem selectedItem) {
        if (pane.getChildren().size() > 0) {
            pane.getChildren().remove(0);
        }
        TextField keyText = new TextField();
        String key = (String) selectedItem.getValue();
        keyText.setText(key);
        String value = RedisService.getKey(key);
        valueArea.setText(value);

        final ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll("JSON", "TEXT");

        priorityComboBox.setValue("JSON");

        //重命名
        Button renameBtn = new Button("Rename");
        renameBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String newKeyName = MyDialog.renameKeyDialog(keyText.getText());
            keyText.setText(newKeyName);
            selectedItem.setValue(newKeyName);
        });
        //设置过期时间
        String ttl = RedisService.ttl(key).toString();
        Button ttlBtn = new Button("TTL:" + ttl);
        ttlBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            String newTtl = MyDialog.ttlKeyDialog(key, ttl);
            ttlBtn.setText("TTL:" + newTtl);
        });
        //删除
        Button delBtn = new Button("Delete");
        delBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            String result = MyDialog.delDialog(key);
            TreeItem parent = selectedItem.getParent();
            parent.getChildren().remove(selectedItem);
            pane.getChildren().remove(0);
        });
        //重新加载
        Button reloadBtn = new Button("Reload Value");
        reloadBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,event -> {
            String v = RedisService.getKey(key);
            valueArea.setText(v);
            String expireTime = RedisService.ttl(key).toString();
            ttlBtn.setText("TTL:" + expireTime);
        });

        GridPane grid = new GridPane();
        grid.setVgap(6);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(StringKeyLabel, 0, 0);
        grid.add(keyText, 1, 0);
        grid.add(renameBtn, 2, 0);
        grid.add(ttlBtn, 3, 0);
        grid.add(delBtn, 4, 0);
        grid.add(reloadBtn, 5, 0);

        grid.add(new Label("Value:"), 0, 1);
        grid.add(new Label("View:"), 4, 1);
        grid.add(priorityComboBox, 5, 1);

        grid.add(valueArea, 0, 2, 6, 1);


        pane.getChildren().addAll(grid);

    }

    public static void viewList(TreeItem selectedItem) {
        if (pane.getChildren().size() > 0) {
            pane.getChildren().remove(0);
        }
        listData.clear();
        TextField keyText = new TextField();
        keyText.setText((String) selectedItem.getValue());
        valueArea = new TextArea();
        TableView table = new TableView();
        TableColumn rowCol = new TableColumn("row");
        TableColumn valueCol = new TableColumn("value");
        rowCol.setCellValueFactory(new PropertyValueFactory<>("index"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        table.setItems(listData);
        table.getColumns().addAll(rowCol, valueCol);

        table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            RowData data = (RowData) newValue;
            valueArea.setText(data.getValue());
        }));

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(ListKeyLabel, 0, 0);
        grid.add(keyText, 1, 0, 3, 1);

        grid.add(table, 0, 1, 4, 1);
        grid.add(valueArea, 0, 2, 4, 1);
        grid.setPrefWidth(400);
        grid.setPrefHeight(400);


        pane.getChildren().addAll(grid);

    }


}
