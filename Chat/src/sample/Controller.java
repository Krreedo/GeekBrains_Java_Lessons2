package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TextArea messageScreen;
    @FXML
    public TextArea typingArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void sendButtonAction(MouseEvent mouseEvent) {
        messageScreen.appendText(typingArea.getText());
        typingArea.setText("");

    }

    public void sendMessage(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ENTER){
            messageScreen.appendText(typingArea.getText());
            typingArea.setText("");
        }
    }
}
