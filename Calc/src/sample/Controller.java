package sample;

import javafx.event.ActionEvent;

import java.awt.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
    private int result;
    private int firstVar;
    private int secondVar;
    private int action=0;

    @FXML
    public TextField inputField;
    @FXML
    public TextArea resultArea;


    public void minus(ActionEvent actionEvent) {
        if(action!=0){
            equality(actionEvent);
        }else{
            resultArea.appendText(inputField.getText() + "\n-\n");
            result = Integer.parseInt(inputField.getText());
            inputField.setText("");
            action = 1;
        }
    }

    public void divide(ActionEvent actionEvent) {
        if(action!=0){
            equality(actionEvent);
        }else{
            resultArea.appendText(inputField.getText() + "\n/\n");
            result = Integer.parseInt(inputField.getText());
            inputField.setText("");
            action = 2;
        }
    }

    public void multiply(ActionEvent actionEvent) {
        if(action!=0){
            equality(actionEvent);
        }else {
            resultArea.appendText(inputField.getText() + "\n*\n");
            result = Integer.parseInt(inputField.getText());
            inputField.setText("");
            action = 3;
        }
    }

    public void plus(ActionEvent actionEvent) {
        if(action!=0){
            equality(actionEvent);
        }else {
            resultArea.appendText(inputField.getText() + "\n+\n");
            result = Integer.parseInt(inputField.getText());
            inputField.setText("");
            action = 4;
        }
    }

    public void equality(ActionEvent actionEvent) {
        if(action == 1){
            resultArea.appendText(inputField.getText());
            result -= Integer.parseInt(inputField.getText());
            resultArea.appendText("\n=\n"+ result +"\n");
            inputField.setText("");
        }
        if(action == 2){
            resultArea.appendText(inputField.getText());
            result /= Integer.parseInt(inputField.getText());
            resultArea.appendText("\n=\n"+ result +"\n");
            inputField.setText("");
        }
        if(action == 3){
            resultArea.appendText(inputField.getText());
            result *= Integer.parseInt(inputField.getText());
            resultArea.appendText("\n=\n"+ result +"\n");
            inputField.setText("");
        }
        if(action == 4){
            resultArea.appendText(inputField.getText());
            result += Integer.parseInt(inputField.getText());
            resultArea.appendText("\n=\n"+ result +"\n");
            inputField.setText("");
        }
        action = 0;
    }

    public void keyListener(KeyEvent keyEvent) {

        ActionEvent actionEvent = null;
        if(keyEvent.getCode() == KeyCode.SUBTRACT){
            minus(actionEvent);
        }
        if(keyEvent.getCode() == KeyCode.ADD){
            plus(actionEvent);
        }
        if(keyEvent.getCode() == KeyCode.MULTIPLY){
            multiply(actionEvent);
        }
        if(keyEvent.getCode() == KeyCode.DIVIDE){
            divide(actionEvent);
        }
        if(keyEvent.getCode() == KeyCode.ENTER){
            equality(actionEvent);
        }

    }

    public void resetField(KeyEvent keyEvent) {
        ActionEvent actionEvent = null;
        if(keyEvent.getCode() == KeyCode.SUBTRACT){
            inputField.setText("");
        }
        if(keyEvent.getCode() == KeyCode.ADD){
            inputField.setText("");
        }
        if(keyEvent.getCode() == KeyCode.MULTIPLY){
            inputField.setText("");
        }
        if(keyEvent.getCode() == KeyCode.DIVIDE){
            inputField.setText("");
        }
        if(keyEvent.getCode() == KeyCode.ENTER){
            inputField.setText("");
        }
    }
}
