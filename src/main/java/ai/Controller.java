package ai;

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

    @FXML
    void chatBotWindow(ActionEvent event) {

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
