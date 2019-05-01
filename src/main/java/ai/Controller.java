package ai;

import jade.Boot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Controller {
    public static Stage queenStage;
    public static Stage chatStage;

    @FXML
    void chatBotWindow(ActionEvent event) {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/chat_view.fxml"));
//            Parent root;
//
//            root = fxmlLoader.load();
//
//            Stage masterStage = new Stage();
//            masterStage.setScene(new Scene(root,387,586));
//            masterStage.setTitle("AI Project - Chat Bot");
//            masterStage.setResizable(false);
//            chatStage = masterStage;
//            Controller.chatStage.show();
//            Main.stage.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Boot.main(new String[]{"-gui"});
    }

    @FXML
    void nQueenWindow(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/nqueen_view.fxml"));
            Parent root;

            root = fxmlLoader.load();

            Stage masterStage = new Stage();
            masterStage.setScene(new Scene(root, 835, 630));
            masterStage.initStyle(StageStyle.DECORATED);
            masterStage.setTitle("AI Project - N-Queen Genetic Algorithm");
            masterStage.setResizable(true);
            queenStage = masterStage;
            Main.stage.close();
            masterStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
