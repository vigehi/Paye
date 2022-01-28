package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MainApp {
    public Scene getMain() {
        GridPane grid = new GridPane();
        grid.setMinSize(1000, 600);
        grid.setPadding(new Insets(80, 20, 20, 80));
        grid.setVgap(5);
        grid.setHgap(5);
        grid.setAlignment(Pos.TOP_LEFT);

        Text text1 = new Text("Pay Period");
        Text text2 = new Text("Basic Salary");
        Text text3 = new Text("Benefits");
        Text text4 = new Text("Deduct NSSF");
        Text text5 = new Text("NSSF Rates");
        Text text6 = new Text("Deduct NHIF");
        Text text7 = new Text("NHIF Rates");
        Text text9 = new Text("Personal Relief");
        Text text10 = new Text("Basic Salary");
        Text text11 = new Text("Deductable NSSF");
        Text text12 = new Text("Benefits");
        Text text13 = new Text("Taxable Income");
        Text text14 = new Text("Tax on Taxable income");
        Text text15 = new Text("Personal Relief");
        Text text16 = new Text("NHIF");
        Text text17 = new Text("Net Pay");
        Text text18 = new Text("REPORT");
        TextField textField1 = new TextField();
        textField1.getText();
        TextField textField2 = new TextField();
        textField2.getText();
        TextField textField11 = new TextField();
        textField11.getText();
        TextField textField12 = new TextField();
        textField12.getText();
        TextField textField13 = new TextField();
        textField13.getText();
        Label textField3 = new Label();
        Label textField4 = new Label();
        textField4.getText();
        Label textField5 = new Label();
        Label textField6 = new Label();
        Label textField7 = new Label();
        Label textField8 = new Label();
        Label textField9 = new Label();
        Label textField10 = new Label();
        Button button1 = new Button("Calculate");
        CheckBox checkBox1 = new CheckBox("Month");
        CheckBox checkBox2 = new CheckBox("Year");
        CheckBox checkBox3 = new CheckBox("Yes");
        CheckBox checkBox4 = new CheckBox("No");
        CheckBox checkBox5 = new CheckBox("Yes");
        CheckBox checkBox6 = new CheckBox("No");
        button1.setOnMouseClicked((MouseEvent event) -> {
            //set textfield values
            textField3.setText(textField1.getText());
            textField5.setText(textField2.getText());
            textField9.setText(textField12.getText());
            textField8.setText(textField13.getText());
            if (checkBox3.isSelected())
                textField4.setText(textField11.getText());
            else if(checkBox4.isSelected())
                textField4.setText( " 0 ");



            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int num3 = Integer.parseInt(textField11.getText());
            int sum1 = (num1 + num2) ;
            int sum = sum1 - num3;
            textField6.setText(""+sum);
            final double rate1 = 0.1;
            final double rate2 = 0.15;
            final double rate3 = 0.2;
            final double rate4 = 0.25;
            final double rate5 = 0.3;
            float sum2;
            if (sum <= 10000){
                sum2 = (float) (sum * rate1);
                textField7.setText(""+sum2);
            }
            else if (sum <= 30000){
                sum2 = (float) (sum * rate2);
                textField7.setText(""+sum2);
            }
            else if (sum <= 60000){
                sum2 = (float) (sum * rate3);
                textField7.setText(""+sum2);
            }
            else if (sum <= 100000){
                sum2 = (float) (sum * rate4);
                textField7.setText(""+sum2);
            }
            else if (sum > 100000){
                sum2 = (float) (sum * rate5);
                textField7.setText(""+sum2);
            }
            int num4 = Integer.parseInt(textField6.getText());
            //int num5 = Integer.parseInt(textField7.getText());
           // int num6 = Integer.parseInt(textField8.getText());
            int num7 = Integer.parseInt(textField9.getText());
            int sum5 = num4 + num7;
            textField10.setText(""+sum5);

        });


        Separator separator1 = new Separator();
        Separator separator2 = new Separator();
        Separator separator3 = new Separator();
        Separator separator4 = new Separator();
        Separator separator5 = new Separator();
        Separator separator6 = new Separator();
        Separator separator7 = new Separator();
        Separator separator8 = new Separator();
        Separator separator9 = new Separator();
        Separator separator10 = new Separator();
        separator1.setOrientation(Orientation.VERTICAL);
        separator2.setOrientation(Orientation.VERTICAL);
        separator3.setOrientation(Orientation.VERTICAL);
        separator4.setOrientation(Orientation.VERTICAL);
        separator5.setOrientation(Orientation.VERTICAL);
        separator6.setOrientation(Orientation.VERTICAL);
        separator7.setOrientation(Orientation.VERTICAL);
        separator8.setOrientation(Orientation.VERTICAL);
        separator9.setOrientation(Orientation.VERTICAL);
        separator10.setOrientation(Orientation.VERTICAL);
        grid.add(text1, 0, 0);
        grid.add(text2, 0, 1);
        grid.add(text3, 0, 2);
        grid.add(text4, 0, 3);
        grid.add(text5, 0, 4);
        grid.add(text6, 0, 5);
        grid.add(text7, 0, 6);
        grid.add(text9, 0, 7);
        grid.add(textField11, 1, 4);
        grid.add(textField12, 1, 6);
        grid.add(textField13, 1, 7);
        grid.add(text10, 5, 1);
        grid.add(text11, 5, 2);
        grid.add(text12, 5, 3);
        grid.add(text13, 5, 4);
        grid.add(text14, 5, 5);
        grid.add(text15, 5, 6);
        grid.add(text16, 5, 7);
        grid.add(text17, 5, 8);
        grid.add(text18, 5, 0);

        grid.add(button1, 2, 10);
        grid.add(checkBox1, 1, 0);
        grid.add(checkBox2, 2, 0);
        grid.add(checkBox3, 1, 3);
        grid.add(checkBox4, 2, 3);
        grid.add(checkBox5, 1, 5);
        grid.add(checkBox6, 2, 5);
        grid.add(textField1, 1, 1);
        grid.add(textField2, 1, 2);
        grid.add(textField3, 6, 1);
        grid.add(textField4, 6, 2);
        grid.add(textField5, 6, 3);
        grid.add(textField6, 6, 4);
        grid.add(textField7, 6, 5);
        grid.add(textField8, 6, 6);
        grid.add(textField9, 6, 7);
        grid.add(textField10, 6, 8);
        grid.add(separator1, 4,0);
        grid.add(separator2, 4,1);
        grid.add(separator3, 4,2);
        grid.add(separator4, 4,3);
        grid.add(separator5, 4,4);
        grid.add(separator6, 4,5);
        grid.add(separator7, 4,6);
        grid.add(separator8, 4,7);
        grid.add(separator9, 4,8);
        grid.add(separator10, 4,9);

        grid.setVgap(20);
        grid.setHgap(20);
        text1.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text2.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text3.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text4.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text5.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text6.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text7.setStyle("-fx-font: normal bold 15px 'sans-serif' ");

        text9.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text10.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text11.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text12.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text13.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text14.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text16.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text15.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text17.setStyle("-fx-font: normal bold 15px 'sans-serif' ");
        text18.setStyle("-fx-font: normal bold 25px 'sans-serif' ");
        grid.setStyle("-fx-background-color: lightgrey;");
        button1.setStyle("-fx-background-color: darkblue;-fx-font: normal 15px 'sans-serif'; -fx-text-fill: white;");

        Scene scene = new Scene(grid);
        return scene;
    }
    public void calculate(){

    }
}
