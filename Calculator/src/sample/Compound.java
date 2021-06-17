package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Compound extends Application{

    public static void stage() {    //Creating a static method
        Stage window = new Stage();
        window.setTitle("Compound saving Calculator");
        Pane root = new Pane();

        Button back= new Button("Back");   //Creating Back button.
        back.setLayoutX(500);
        back.setLayoutY(540);
        back.setStyle("-fx-pref-width:80; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");

        //setting the action for back button.
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) back.getScene().getWindow();
                stage.close();
            }
        });

        //Creating the elements of tab 1 (FV)
        Label lb1 = new Label("Start Principle");
        lb1.setLayoutX(50);
        lb1.setLayoutY(50);
        Label lb2 = new Label("Time Period(years)");
        lb2.setLayoutX(50);
        lb2.setLayoutY(100);
        Label lb3 = new Label("I/Y (Interest %)");
        lb3.setLayoutX(50);
        lb3.setLayoutY(150);
        TextField tf1 = new TextField();
        tf1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf1,root);
            }
        });
        tf1.setLayoutX(200);
        tf1.setLayoutY(50);
        TextField tf2 = new TextField();
        tf2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf2,root);
            }
        });
        tf2.setLayoutX(200);
        tf2.setLayoutY(100);
        TextField tf3 = new TextField();
        tf3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf3,root);
            }
        });
        tf3.setLayoutX(200);
        tf3.setLayoutY(150);
        Button cal1 = new Button("Calculate");
        cal1.setLayoutX(100);
        cal1.setLayoutY(300);
        Label lb4 = new Label(" ");
        lb4.setLayoutX(100);
        lb4.setLayoutY(400);
        Alert a1=new Alert(Alert.AlertType.ERROR);
        a1.setContentText("Please fill all the details and add only numeric values.");

        //Setting the action to the calculate button of the tab1
        cal1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double n = 12;
                    Double r = Double.parseDouble(tf3.getText()) / 100;
                    Double t = Double.parseDouble(tf2.getText());
                    Double P = Double.parseDouble(tf1.getText());
                    Double A = P * ( pow(( 1 + ( r / n ) ), ( n * t )) );
                    lb4.setText("The Future Value \nis:" + String.format("%.2f",A));
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //Creating tab1 and adding all the elements to tab1
        Tab tab_1 = new Tab("FV");
        Pane layout1 = new Pane();
        layout1.getChildren().addAll(lb1, lb2, lb3, lb4, tf1, tf2, tf3, cal1);
        tab_1.setContent(layout1);

        //Creating the elements of tab 2
        Label lb11 = new Label("Start Principle");
        lb11.setLayoutX(50);
        lb11.setLayoutY(50);
        Label lb21 = new Label("Time Period(years)");
        lb21.setLayoutX(50);
        lb21.setLayoutY(100);
        Label lb31 = new Label("Future Value");
        lb31.setLayoutX(50);
        lb31.setLayoutY(150);
        TextField tf11 = new TextField();
        tf11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf11,root);
            }
        });
        tf11.setLayoutX(200);
        tf11.setLayoutY(50);
        TextField tf21 = new TextField();
        tf21.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf21,root);
            }
        });
        tf21.setLayoutX(200);
        tf21.setLayoutY(100);
        TextField tf31 = new TextField();
        tf31.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf31,root);
            }
        });
        tf31.setLayoutX(200);
        tf31.setLayoutY(150);
        Button cal2 = new Button("Calculate");
        cal2.setLayoutX(100);
        cal2.setLayoutY(300);
        Label lb41 = new Label(" ");
        lb41.setLayoutX(100);
        lb41.setLayoutY(400);

        //Setting the action to the calculate button of the tab2
        cal2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double n = 12;
                    Double A = Double.parseDouble(tf31.getText());
                    Double t = Double.parseDouble(tf21.getText());
                    Double P = Double.parseDouble(tf11.getText());
                    Double r = (n * ( pow(( A / P ), ( 1 / ( n * t ) )) - 1 ))*100;
                    lb41.setText("The Interest rate \nis: " + String.format("%.2f",r));
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //craeting tab 2 and adding all the elements.
        Tab tab_2 = new Tab("Interest");
        Pane layout2 = new Pane();
        layout2.getChildren().addAll(lb11, lb21, lb31, lb41, tf11, tf21, tf31, cal2);
        tab_2.setContent(layout2);

        //Creating the elements of tab 3
        Label lb12 = new Label("Start Principle");
        lb12.setLayoutX(50);
        lb12.setLayoutY(50);
        Label lb22 = new Label("Future Value");
        lb22.setLayoutX(50);
        lb22.setLayoutY(100);
        Label lb32 = new Label("I/Y (Interest %)");
        lb32.setLayoutX(50);
        lb32.setLayoutY(150);
        TextField tf12 = new TextField();
        tf12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf12,root);
            }
        });
        tf12.setLayoutX(200);
        tf12.setLayoutY(50);
        TextField tf22 = new TextField();
        tf22.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf22,root);
            }
        });
        tf22.setLayoutX(200);
        tf22.setLayoutY(100);
        TextField tf32 = new TextField();
        tf32.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf32,root);
            }
        });
        tf32.setLayoutX(200);
        tf32.setLayoutY(150);
        Button cal3 = new Button("Calculate");
        cal3.setLayoutX(100);
        cal3.setLayoutY(300);
        Label lb42 = new Label(" ");
        lb42.setLayoutX(100);
        lb42.setLayoutY(400);

        //Setting the action to the calculate button of the tab3
        cal3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double n = 12;
                    Double r = Double.parseDouble(tf32.getText()) / 100;
                    Double A = Double.parseDouble(tf22.getText());
                    Double P = Double.parseDouble(tf12.getText());
                    Double t = log(A/P)/(n*(log(1+(r/n))));
                    lb42.setText("The time period in \n years is: " + String.format("%.2f",t));
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //craeting the tab3 and adding the elements
        Tab tab_3 = new Tab("Time Period");
        Pane layout3 = new Pane();
        layout3.getChildren().addAll(lb12, lb22, lb32, lb42, tf12, tf22, tf32, cal3);
        tab_3.setContent(layout3);

        //Creating the elements of tab 4
        Label lb13 = new Label("Future Value");
        lb13.setLayoutX(50);
        lb13.setLayoutY(50);
        Label lb23 = new Label("Time Period(years)");
        lb23.setLayoutX(50);
        lb23.setLayoutY(100);
        Label lb33 = new Label("I/Y (Interest %)");
        lb33.setLayoutX(50);
        lb33.setLayoutY(150);
        TextField tf13 = new TextField();
        tf13.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf13,root);
            }
        });
        tf13.setLayoutX(200);
        tf13.setLayoutY(50);
        TextField tf23 = new TextField();
        tf23.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf23,root);
            }
        });
        tf23.setLayoutX(200);
        tf23.setLayoutY(100);
        TextField tf33 = new TextField();
        tf33.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf33,root);
            }
        });
        tf33.setLayoutX(200);
        tf33.setLayoutY(150);
        Button cal4 = new Button("Calculate");
        cal4.setLayoutX(100);
        cal4.setLayoutY(300);
        Label lb43 = new Label(" ");
        lb43.setLayoutX(100);
        lb43.setLayoutY(400);

        //Setting the action to the calculate button of the tab4
        cal4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double n = 12;
                    Double r = Double.parseDouble(tf33.getText()) / 100;
                    Double t = Double.parseDouble(tf23.getText());
                    Double A = Double.parseDouble(tf13.getText());
                    Double P = A/(pow((1+(r/n)),(n*t)));
                    lb43.setText("The starting priciple \nis: " + String.format("%.2f",P));
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //creating the tab 4 and adding all the elements.
        Tab tab_4 = new Tab("Start Principle");
        Pane layout4 = new Pane();
        layout4.getChildren().addAll(lb13, lb23, lb33, lb43, tf13, tf23, tf33, cal4);
        tab_4.setContent(layout4);

        //setting styles
        cal1.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");
        cal2.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");
        cal3.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");
        cal4.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");

        lb4.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");
        lb41.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");
        lb42.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");
        lb43.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");

        //Creating the tabpane and adding all the tabs
        TabPane tabpane= new TabPane(tab_1,tab_2,tab_3,tab_4);

        //adding the elements to the pane
        root.setStyle("-fx-background-color:#00cccc;");
        root.getChildren().add(tabpane);
        root.getChildren().add(back);
        window.setScene(new Scene(root, 650, 600));
        window.show();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

    }
    public static void main(String[] args) {
        launch(args);
    }

}
