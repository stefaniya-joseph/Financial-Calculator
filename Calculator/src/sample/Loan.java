package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static java.lang.Math.pow;
import static java.lang.Math.log;

public class Loan extends Application {

    public static void stage(){
        Stage window= new Stage();
        window.setTitle("Loan Calculator");
        Pane root = new Pane();

        Button back= new Button("Back");   //Creating the back button
        back.setLayoutX(500);
        back.setLayoutY(540);
        back.setStyle("-fx-pref-width:80; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");

        //setting the action to the back button
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) back.getScene().getWindow();
                stage.close();
            }
        });

        //Creating the elements of tab 1
        Label lb1=new Label("Loan Amount");
        lb1.setLayoutX(50);
        lb1.setLayoutY(50);
        Label lb2=new Label("Loan Term(years)");
        lb2.setLayoutX(50);
        lb2.setLayoutY(100);
        Label lb3=new Label("Interest Rate");
        lb3.setLayoutX(50);
        lb3.setLayoutY(150);
        TextField tf1=new TextField();
        tf1.setLayoutX(200);
        tf1.setLayoutY(50);
        tf1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf1,root);
            }
        });
        TextField tf2=new TextField();
        tf2.setLayoutX(200);
        tf2.setLayoutY(100);
        tf2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf2,root);
            }
        });
        TextField tf3=new TextField();
        tf3.setLayoutX(200);
        tf3.setLayoutY(150);
        tf3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf3,root);
            }
        });
        Label lb4=new Label("Payment: ");
        lb4.setLayoutX(50);
        lb4.setLayoutY(200);
        RadioButton r1= new RadioButton("Monthly");
        r1.setLayoutX(200);
        r1.setLayoutY(200);
        RadioButton r2= new RadioButton("Annualy");
        r2.setLayoutX(200);
        r2.setLayoutY(225);
        ToggleGroup tg1=new ToggleGroup();
        r1.setToggleGroup(tg1);
        r2.setToggleGroup(tg1);
        Button cal1=new Button("Calculate");
        cal1.setLayoutX(100);
        cal1.setLayoutY(300);
        Label lb5=new Label(" ");
        lb5.setLayoutX(100);
        lb5.setLayoutY(400);
        Alert a1=new Alert(Alert.AlertType.ERROR);
        a1.setContentText("Please fill all the details and add only numeric values.");

        //Setting the action to the calculate button of the tab1
        cal1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double n=12;
                    double r = Double.parseDouble(tf3.getText())/1200;
                    double t = Double.parseDouble(tf2.getText());
                    double P = Double.parseDouble(tf1.getText());
                    double PMT=P*((r*pow((1+r),(n*t)))/(pow((1+r),(n*t))-1));
                    if (r1.isSelected()) {
                        lb5.setText("The monthly payment \nis: " + String.format("%.2f",PMT));
                    } else if (r2.isSelected()) {
                        PMT = PMT / 12;
                        lb5.setText("The yearly payment \nis: " + String.format("%.2f",PMT));
                    } else {
                        a1.show();
                    }
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //Creating the tab1 and adding the elements
        Tab tab_1= new Tab("Payment");
        Pane layout1 = new Pane();
        layout1.getChildren().addAll(lb1,lb2,lb3,lb4,tf1,tf2,tf3,r1,r2,cal1,lb5);
        tab_1.setContent(layout1);

        //Creating the elements tab 2
        Label lb12=new Label("Loan Term(years)");
        lb12.setLayoutX(50);
        lb12.setLayoutY(50);
        Label lb22=new Label("Payment Amount");
        lb22.setLayoutX(50);
        lb22.setLayoutY(100);
        Label lb32=new Label("Interest Rate");
        lb32.setLayoutX(50);
        lb32.setLayoutY(150);
        TextField tf12=new TextField();
        tf12.setLayoutX(200);
        tf12.setLayoutY(50);
        tf12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf12,root);
            }
        });
        TextField tf22=new TextField();
        tf22.setLayoutX(200);
        tf22.setLayoutY(100);
        tf22.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf22,root);
            }
        });
        TextField tf32=new TextField();
        tf32.setLayoutX(200);
        tf32.setLayoutY(150);
        tf32.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf32,root);
            }
        });
        Label lb42=new Label("Payment: ");
        lb42.setLayoutX(50);
        lb42.setLayoutY(200);
        RadioButton r12= new RadioButton("Monthly");
        r12.setLayoutX(200);
        r12.setLayoutY(200);
        RadioButton r22= new RadioButton("Annualy");
        r22.setLayoutX(200);
        r22.setLayoutY(225);
        ToggleGroup tg12=new ToggleGroup();
        r12.setToggleGroup(tg12);
        r22.setToggleGroup(tg12);
        Button cal3=new Button("Calculate");
        cal3.setLayoutX(100);
        cal3.setLayoutY(300);
        Label lb52=new Label(" ");
        lb52.setLayoutX(100);
        lb52.setLayoutY(400);

        //Setting the action to the calculate button of the tab2
        cal3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double r = Double.parseDouble(tf32.getText())/1200;
                    double PMT = Double.parseDouble(tf22.getText());
                    double t = Double.parseDouble(tf12.getText())*12;
                    if (r12.isSelected()) {
                        double P =(PMT/r)*(1-(1/pow((1+r),t)));
                        lb52.setText("The loan amount \nis: " + String.format("%.2f",P));
                    } else if (r22.isSelected()) {
                        PMT = PMT / 12;
                        double P =(PMT/r)*(1-(1/pow((1+r),t)));
                        lb52.setText("The loan amount \nis: " + String.format("%.2f",P));
                    } else {
                        a1.show();
                    }
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //Creating the tab 2 and adding elements
        Tab tab_3= new Tab("Loan Amount");
        Pane layout3 = new Pane();
        layout3.getChildren().addAll(lb12,lb22,lb32,lb42,lb52,tf12,tf22,tf32,r12,r22,cal3);
        tab_3.setContent(layout3);

        //Creating the elements of tab 3
        Label lb13=new Label("Loan Amount");
        lb13.setLayoutX(50);
        lb13.setLayoutY(50);
        Label lb23=new Label("Payment");
        lb23.setLayoutX(50);
        lb23.setLayoutY(100);
        Label lb33=new Label("Interest Rate");
        lb33.setLayoutX(50);
        lb33.setLayoutY(150);
        TextField tf13=new TextField();
        tf13.setLayoutX(200);
        tf13.setLayoutY(50);
        tf13.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf13,root);
            }
        });
        TextField tf23=new TextField();
        tf23.setLayoutX(200);
        tf23.setLayoutY(100);
        tf23.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf23,root);
            }
        });
        TextField tf33=new TextField();
        tf33.setLayoutX(200);
        tf33.setLayoutY(150);
        tf33.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                keyboard.key(tf33,root);
            }
        });
        Label lb43=new Label("Payment: ");
        lb43.setLayoutX(50);
        lb43.setLayoutY(200);
        RadioButton r13= new RadioButton("Monthly");
        r13.setLayoutX(200);
        r13.setLayoutY(200);
        RadioButton r23= new RadioButton("Annualy");
        r23.setLayoutX(200);
        r23.setLayoutY(225);
        ToggleGroup tg13=new ToggleGroup();
        r13.setToggleGroup(tg13);
        r23.setToggleGroup(tg13);
        Button cal4=new Button("Calculate");
        cal4.setLayoutX(100);
        cal4.setLayoutY(300);
        Label lb53=new Label(" ");
        lb53.setLayoutX(100);
        lb53.setLayoutY(400);

        //Setting the action to the calculate button of the tab3
        cal4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    double r = Double.parseDouble(tf33.getText())/1200;
                    double PMT = Double.parseDouble(tf23.getText());
                    double P = Double.parseDouble(tf13.getText());
                    if (r13.isSelected()) {
                        double t = log((PMT/r)/((PMT/r)-P))/log(1+r);
                        lb53.setText("The time period in \nmonth is:" + String.format("%.2f",t));
                    } else if (r23.isSelected()) {
                        PMT = PMT / 12;
                        double t = log((PMT/r)/((PMT/r)-P))/log(1+r);
                        lb53.setText("The time period in \nmonth is: " + String.format("%.2f",t));
                    } else {
                        a1.show();
                    }
                } catch (NumberFormatException e) {
                    a1.show();
                }
            }
        });

        //Creating the tab 3 and adding elements
        Tab tab_4= new Tab("Loan Term");
        Pane layout4 = new Pane();
        layout4.getChildren().addAll(lb13,lb23,lb33,lb43,tf13,tf23,tf33,r13,r23,cal4,lb53);
        tab_4.setContent(layout4);

        //setting the styles
        cal1.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");
        cal3.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");
        cal4.setStyle("-fx-pref-width: 150; -fx-pref-height:50; -fx-border-width: 2; -fx-font-family:\"serif\"; -fx-font-size:14; -fx-text-alignment:center; -fx-background-color:#0073e6;");

        lb5.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");
        lb52.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");
        lb53.setStyle("-fx-font-family:\"serif\"; -fx-text-alignment:\"center\";-fx-font-size:26; -fx-pref-height:150; -fx-text-fill: \"Green\";-fx-pref-width: 250;");

        //Creating tabpane and adding the tabs
        TabPane tabpane= new TabPane(tab_1,tab_3,tab_4);

        root.setStyle("-fx-background-color:#00cccc;");
        root.getChildren().add(back);
        root.getChildren().add(tabpane);
        window.setScene(new Scene(root, 650, 600));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
