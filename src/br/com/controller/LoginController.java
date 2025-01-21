package br.com.controller;

import br.com.service.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author ronaldo neto
 */
public class LoginController {

    @FXML
    private TextField UsernameField;
    
    @FXML
    private PasswordField PasswordField;
    
    private final LoginService loginService = new LoginService();
     
    @FXML
     private void handleLogin(ActionEvent event){
            String username = UsernameField.getText();
            String senha = PasswordField.getText();
            
            if(username.isEmpty() || senha.isEmpty()){
                showAlert(AlertType.WARNING, "Aviso", "Preencha todos os campos!");
                return;
            }
            
            boolean isAuthenticadet = loginService.authenticate(username, senha);
            
            if(isAuthenticadet){
                showAlert(AlertType.INFORMATION, "Sucesso", "Login realizado com sucesso");
            }else{
                showAlert(AlertType.ERROR, "Erro", "Usuário ou senha inválidos");
            }
    }         
            
     
     private void showAlert(AlertType alertType, String title, String content){
         Alert alert = new Alert(alertType);
         alert.setTitle(title);
         alert.setContentText(content);
         alert.showAndWait();
     }
}
