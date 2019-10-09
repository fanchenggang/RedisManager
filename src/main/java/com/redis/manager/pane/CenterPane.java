package com.redis.manager.pane;

import com.redis.manager.model.RowData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

    public static Label keyLabel;
    public static Label valueLabel;

    public static TextArea valueArea;
    public static TextField keyText;

    public static ObservableList<RowData> listData =  FXCollections.observableArrayList();


    static {
        pane = new AnchorPane();
        pane.setPrefWidth(100);
        pane.setPrefHeight(100);
        pane.setStyle("-fx-background-color: #EEEE00");

    }

    public static void viewText() {
        if (pane.getChildren().size()>0){
            pane.getChildren().remove(0);
        }

        keyLabel = new Label("STRING: ");
        keyText = new TextField();
        valueArea = new TextArea();


        final ComboBox priorityComboBox = new ComboBox();
        priorityComboBox.getItems().addAll("JSON", "TEXT");

        priorityComboBox.setValue("JSON");

        Button renameBtn = new Button("Rename");
        Button ttlBtn = new Button("TTL:-1");
        Button delBtn = new Button("Delete");
        Button reloadBtn = new Button("Reload Value");

        GridPane grid = new GridPane();
        grid.setVgap(6);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(keyLabel, 0, 0);
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

    public static void viewList() {
        if (pane.getChildren().size()>0){
            pane.getChildren().remove(0);
        }
        listData.clear();
        keyLabel = new Label("List: ");
        keyText = new TextField();
        valueArea = new TextArea();

        TableView table = new TableView();
        TableColumn rowCol = new TableColumn("row");
        TableColumn valueCol = new TableColumn("value");
        rowCol.setCellValueFactory(new PropertyValueFactory<>("index"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
        table.setItems(listData);
        table.getColumns().addAll(rowCol,valueCol);

        table.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            RowData data = (RowData) newValue;
            valueArea.setText(data.getValue());
        }));

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(keyLabel, 0, 0);
        grid.add(keyText, 1, 0,3,1);

        grid.add(table, 0, 1, 4, 1);
        grid.add(valueArea, 0, 2, 4, 1);
        grid.setPrefWidth(400);
        grid.setPrefHeight(400);


        pane.getChildren().addAll(grid);

    }


}
