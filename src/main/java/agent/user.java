package agent;

import ai.Controller;
import ai.Main;
import com.jfoenix.controls.JFXTextField;
import jade.Boot;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

import java.util.Scanner;

public class user extends Agent {
    @FXML
    private JFXTextField msgField;
    @FXML
    private VBox container;
    Scanner scanner = new Scanner(System.in);

    public void setMsg(String msg) {
        ACLMessage aCLMessage = new ACLMessage(ACLMessage.INFORM);
        aCLMessage.addReceiver(new AID("bot", AID.ISLOCALNAME));

        aCLMessage.setContent(msg);
        this.send(aCLMessage);
    }

    @Override
    protected void setup() {
        super.setup();
        System.out.println("User is ready");
        while (true){
            String msg = scanner.nextLine();
            if (msg.equals("exit") || msg.equals("خروج")) {
                takeDown();
                break;
            }
            setMsg(msg);
        }
    }

    @Override
    protected void takeDown() {
        super.takeDown();
        System.out.println("Bye");
    }

    @FXML
    void sendMessage(ActionEvent event) {
        if (!msgField.getText().isEmpty()) {
            Label label = new Label(msgField.getText());
            label.setBackground(new Background(new BackgroundFill(Paint.valueOf("#174fe7"), null, null)));
            label.setTextFill(Paint.valueOf("#fff"));
            label.setWrapText(true);
            label.setPadding(new Insets(5, 5, 5, 5));
            container.getChildren().add(label);
            setMsg("السلام عليكم");
            msgField.setText("");
        }
    }
}
