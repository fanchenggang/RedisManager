package com.redis.manager.pane;

import com.redis.manager.config.UserConfig;
import com.redis.manager.model.RedisClient;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

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
            Dialog<Pair<String,RedisClient>> dialog = new Dialog<>();
            dialog.setTitle("New Connection Settings");

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

            Optional<Pair<String,RedisClient>> result = dialog.showAndWait();

            result.ifPresent(r->{
                boolean b = UserConfig.addRedisClient(r.getValue());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Test Connect");
                alert.setContentText(b==true?"SUCCESS!":"FAIL!");
                alert.showAndWait();
                if (b){
                    LeftPane.rootItem.getChildren().add(new TreeItem<>(r.getValue().getName()));
                }
            });



        });

        menuBar.getMenus().addAll(file);
        pane.getChildren().addAll(menuBar);
    }

}
