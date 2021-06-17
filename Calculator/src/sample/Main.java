package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Creating the window
        primaryStage.setTitle("Calculator");

        //Creating the buttons and labels.
        Button btn1 = new Button("Savings");
        btn1.setId("btn1");
        btn1.setLayoutX(300);
        btn1.setLayoutY(200);
        Button btn2 = new Button("Loan");
        btn2.setId("btn2");
        btn2.setLayoutX(300);
        btn2.setLayoutY(300);
        Button btn3 = new Button("Mortgage");
        btn3.setId("btn3");
        btn3.setLayoutX(300);
        btn3.setLayoutY(400);
        Button btn4 = new Button("Compound\n" +
                "Saving");
        btn4.setId("btn4");
        btn4.setLayoutX(300);
        btn4.setLayoutY(500);
        Button btn5 = new Button("Help");
        btn5.setId("btn5");
        btn5.setLayoutX(20);
        btn5.setLayoutY(450);
        Button btn6 = new Button("Exit");
        btn6.setId("btn6");
        btn6.setLayoutX(20);
        btn6.setLayoutY(500);
        Label lb1 = new Label("Financial Calculator");
        lb1.setId("lb1");
        lb1.setLayoutX(150);
        lb1.setLayoutY(50);

        //Setting the action of the saving button.
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Saving.stage();
            }
        });

        //Setting the action of the loan button.
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Loan.stage();
            }
        });

        //Setting the action of Mortgage button.
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Mortgage.stage();
            }
        });

        //Setting the action of Compound Saving button.
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Compound.stage();
            }
        });

        //Setting the action of help button.
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                keyboard.Help();
            }
        });

        //Setting the action of Exit button.
        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        //Creating the pane and adding all the elements to it.
        Pane root = new Pane();
        root.setId("pane");
        root.getChildren().add(btn1);
        root.getChildren().add(btn2);
        root.getChildren().add(btn3);
        root.getChildren().add(btn4);
        root.getChildren().add(btn5);
        root.getChildren().add(btn6);
        root.getChildren().add(lb1);
        Scene scene=new Scene(root, 600, 600);
        //Adding the external styling sheet.
        scene.getStylesheets().addAll(this.getClass().getResource("java.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
