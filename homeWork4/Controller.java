package homeWork4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Controller {

    @FXML
    Button sendBtn;

    @FXML
    private
    TextArea textArea;

    @FXML
    private
    TextField inputText;

    //Отправить сообощение по кнопке
    public void sendMessage(ActionEvent actionEvent) {
        textArea.setText(textArea.getText() + "\n" + inputText.getText());
        inputText.setText("");
    }
    //Отправить сообщение по нажатию на кнопку Enter

    @FXML
    public void textAction(KeyEvent e) {
        if (e.getCode().equals(KeyCode.ENTER)) {
            textArea.setText(textArea.getText() + "\n" + inputText.getText());
            inputText.setText("");
        }
    }
}
