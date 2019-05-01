package ai;

import ai.algo.GeneticAlgorithm;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class nQueenController implements Initializable {


    @FXML
    private JFXTextField numOfQ;

    @FXML
    private JFXTextField populationTF;

    @FXML
    private BorderPane puzzel;

    private GUIPuzzle guiPuzzle;

    public void initialize(URL location, ResourceBundle resources) {
        guiPuzzle = new GUIPuzzle();
        puzzel.setCenter(guiPuzzle);
        puzzel.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, new Insets(0, 0, 0, 0))));


    }

    @FXML
    void back(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/start.fxml"));
        Parent root;

        root = fxmlLoader.load();

        Stage masterStage = new Stage();
        masterStage.setScene(new Scene(root, 835, 630));
        masterStage.initStyle(StageStyle.DECORATED);
        masterStage.setTitle("AI Project - N-Queen Genetic Algorithm");
        masterStage.setResizable(true);
        Main.stage = masterStage;
        Controller.queenStage.close();
        masterStage.show();
    }

    @FXML
    void start(ActionEvent event) {
        if (!numOfQ.getText().isEmpty() && !populationTF.getText().isEmpty()) {
            try {
                int numOfQueens = Integer.parseInt(numOfQ.getText());
                int numOfPopulation = Integer.parseInt(populationTF.getText());

                int[] sol = GeneticAlgorithm.solvbyGenetic(numOfQueens, numOfPopulation);

                guiPuzzle.drawQueens(sol);


            } catch (Exception e) {
                System.out.println("Error in Parsing");
            }
        }
    }

}
