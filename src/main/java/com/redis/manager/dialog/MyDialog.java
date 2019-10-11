package com.redis.manager.dialog;

import com.redis.manager.config.UserConfig;
import com.redis.manager.model.RedisClient;
import com.redis.manager.pane.LeftPane;
import com.redis.manager.util.RedisService;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author: FanChengGang
 * @date: 2019-10-11 10:44
 * @describe: TODO
 **/
public class MyDialog {


    public static void openEditDialog(RedisClient redisClient, TreeItem<String> treeItem){
        javafx.scene.control.Dialog<Pair<String, RedisClient>> dialog = new javafx.scene.control.Dialog<>();


//            ButtonType testConnectBtn = new ButtonType("Test Connect", ButtonBar.ButtonData.APPLY);

        ButtonType saveBtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll( saveBtn, cancelBtn);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField name = new TextField();
        name.setPromptText("Connection Name");
        TextField address = new TextField();
        address.setPromptText("127.0.0.1");
        TextField port = new TextField();
        port.setPromptText("6379");
        PasswordField password = new PasswordField();
        password.setPromptText("Auth");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);

        grid.add(new Label("Address:"), 0, 1);
        grid.add(address, 1, 1);


        grid.add(new Label("Port:"), 2, 1);
        grid.add(port, 3, 1);

        grid.add(new Label("Auth:"), 0, 2);
        grid.add(password, 1, 2);

        Node saveButton = dialog.getDialogPane().lookupButton(saveBtn);
        saveButton.setDisable(true);

        name.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.trim().isEmpty() || name.getText().trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> name.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveBtn ) {
                int redisPort = 6379;
                if (port.getText() != null && !port.getText().equals("")) {
                    redisPort = Integer.parseInt(port.getText());
                }
                return new Pair<>(dialogButton.getText(),new RedisClient(name.getText(),
                        address.getText(),
                        redisPort,
                        password.getText(), null));
            }
            return null;
        });

        if (redisClient!=null){
            dialog.setTitle("Edit Connection Settings");
            name.setText(redisClient.getName());
            address.setText(redisClient.getHost());
            password.setText(redisClient.getPassword());
            port.setText(String.valueOf(redisClient.getPort()));
        }else{
            dialog.setTitle("New Connection Settings");
        }

        Optional<Pair<String,RedisClient>> result = dialog.showAndWait();

        result.ifPresent(r->{
            boolean sucFlag = false;
            if (redisClient != null){
                UserConfig.updateRedisClient(redisClient,r.getValue());
                treeItem.setValue(r.getValue().getName());
                sucFlag = true;
            }else{
                sucFlag = UserConfig.addRedisClient(r.getValue());
                if (sucFlag){
                    LeftPane.createConnectView(r.getValue().getName());
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Test Connect");
            alert.setContentText(sucFlag==true?"SUCCESS!":"FAIL!");
            alert.showAndWait();
        });



    }


    public static String renameKeyDialog(String oldKeyName){

       return commonDialog("New Name",oldKeyName,r->{

            if (r.getValue()!= null && r.getValue().trim().length()>0&&!oldKeyName.equals(r.getValue())){
                RedisService.rename(oldKeyName,r.getValue());
            }
        },true);


    }

    public static String ttlKeyDialog(String key,String ttl) {
        return commonDialog("TTL",ttl,r->{
            if (r.getValue()!=null&&r.getValue().trim().length()>0&&!ttl.equals(r.getKey())){
                RedisService.expire(key,Integer.parseInt(r.getValue()));
            }
        },true);
    }

    public static String commonDialog(String promptText, String nameText, Consumer<Pair<String,String>> consumer,boolean saveButtonDisable){
        javafx.scene.control.Dialog<Pair<String, String>> dialog = new javafx.scene.control.Dialog<>();

        ButtonType saveBtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelBtn = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll( saveBtn, cancelBtn);

        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField name = new TextField();
        name.setPromptText(promptText);
        name.setText(nameText);
        grid.add(new Label(promptText+":"), 0, 0);
        grid.add(name, 1, 0);

        Node saveButton = dialog.getDialogPane().lookupButton(saveBtn);
        saveButton.setDisable(saveButtonDisable);

        name.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.trim().isEmpty() || name.getText().trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        Platform.runLater(() -> name.requestFocus());

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == saveBtn ) {
                return new Pair<>("newKeyName",name.getText());
            }
            return null;
        });

        Optional<Pair<String,String>> result = dialog.showAndWait();

        result.ifPresent(r->{
            consumer.accept(r);
        });
        return name.getText();
    }

    public static String delDialog(String key) {
        return commonDialog("Delete Key",key,r->{
            if (r.getValue()!=null&&r.getValue().trim().length()>0){
                RedisService.delete(key);
            }
        },false);
    }
}
