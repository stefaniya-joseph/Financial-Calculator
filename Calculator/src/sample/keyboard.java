package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class keyboard extends Application {
    public static void key(TextField x, Pane y) {

        //Creating the buttons for the calculator.
        Button btn1 = new Button("1");
        btn1.setLayoutX(420);
        btn1.setLayoutY(50);
        Button btn2 = new Button("2");
        btn2.setLayoutX(490);
        btn2.setLayoutY(50);
        Button btn3 = new Button("3");
        btn3.setLayoutX(560);
        btn3.setLayoutY(50);
        Button btn4 = new Button("4");
        btn4.setLayoutX(420);
        btn4.setLayoutY(120);
        Button btn5 = new Button("5");
        btn5.setLayoutX(490);
        btn5.setLayoutY(120);
        Button btn6 = new Button("6");
        btn6.setLayoutX(560);
        btn6.setLayoutY(120);
        Button btn7 = new Button("7");
        btn7.setLayoutX(420);
        btn7.setLayoutY(190);
        Button btn8 = new Button("8");
        btn8.setLayoutX(490);
        btn8.setLayoutY(190);
        Button btn9 = new Button("9");
        btn9.setLayoutX(560);
        btn9.setLayoutY(190);
        Button btn0 = new Button("0");
        btn0.setLayoutX(490);
        btn0.setLayoutY(260);
        Button btnBackspace = new Button("<--");
        btnBackspace.setLayoutX(420);
        btnBackspace.setLayoutY(260);
        Button btnPoint = new Button(".");
        btnPoint.setLayoutX(560);
        btnPoint.setLayoutY(260);

        //Setting the style of each class
        btn1.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn2.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn3.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn4.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn5.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn6.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn7.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn8.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn9.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btn0.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btnBackspace.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");
        btnPoint.setStyle("-fx-pref-width:50; -fx-pref-height:50; -fx-background-color:#404040;-fx-font-size:18; -fx-font-family:\"serif\"; -fx-text-fill:#ffffff;");

        //Setting the action of each button
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "1");
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "2");
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "3");
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "4");
            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "5");
            }
        });

        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "6");
            }
        });

        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "7");
            }
        });

        btn8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "8");
            }
        });

        btn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "9");
            }
        });
        btn0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                x.setText(x.getText() + "0");
            }
        });
        btnPoint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String A =x.getText();
                if(!(A.contains("."))){
                    x.setText(x.getText() + ".");
                }
            }
        });
        btnBackspace.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int length=x.getText().length();
                int num=x.getText().length()-1;
                if(length>0){
                    StringBuilder back=new StringBuilder(x.getText());
                    back.deleteCharAt(num);
                    String store=back.toString();
                    x.setText(store);
                }
            }
        });

        //Adding all the buttons to the pane.
        y.getChildren().add(btn1);
        y.getChildren().add(btn2);
        y.getChildren().add(btn3);
        y.getChildren().add(btn4);
        y.getChildren().add(btn5);
        y.getChildren().add(btn6);
        y.getChildren().add(btn7);
        y.getChildren().add(btn8);
        y.getChildren().add(btn9);
        y.getChildren().add(btn0);
        y.getChildren().add(btnBackspace);
        y.getChildren().add(btnPoint);
    }

    //Creating a method to help button in the main window.
    public static void Help(){
        Stage window= new Stage();
        window.setTitle("Help View");
        Label lb1=new Label("This is a Financial Calculator with 4 different calculators. They are,\n   1.Compound saving (no futher payments)\n"+
        "   2.Saving (compound interest with regular payments)\n   3.Loans(compound interest with regular payments)\n"+
        "   4.Mortgage \n \n What are the functions?\n Each calculator is sub divided as tabs. You have to select \nthe tab with the title of the parameter which you need to find."+
        "\nAfter selecting the correct tab enter the details correctly as required \nto get the correct value.");
        lb1.setLayoutX(20);
        lb1.setLayoutY(20);

        lb1.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"left\";-fx-font-size:16; -fx-pref-height:300; -fx-text-fill: \"Green\";-fx-pref-width: 480;");

        Pane root=new Pane();
        root.getChildren().add(lb1);
        root.setStyle("-fx-background-color:#00cccc;");
        Scene scene=new Scene(root, 480, 300);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
