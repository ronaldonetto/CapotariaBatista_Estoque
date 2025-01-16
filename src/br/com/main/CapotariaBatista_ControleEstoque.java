package br.com.main;

import javafx.application.Application; //Classe base para aplicações em javaFX. Importado para utilizar os métodos do javaFX.
import javafx.fxml.FXMLLoader; //Usado para carregar o arquivo FXML em uma aplicação javaFX.
import javafx.scene.Scene; // Contêiner onde os elementos da inuterface são exibidos.
import javafx.stage.Stage; //Utilizado para de uma tela para outra.
import javafx.scene.layout.AnchorPane;// Indica o layout que irei utilizar.

public class CapotariaBatista_ControleEstoque extends Application {

    @Override
    //Aqui eu vou criar e inicializar a interface gráfica.
    public void start(Stage primaryStage) throws Exception { 
        
        // Carrega o arquivo FXML da tela de login (substitua o caminho conforme necessário).
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/br/com/view/Login.fxml"));
        
        // Define a cena com a tela de login
        Scene scene = new Scene(root);  
        
        primaryStage.setScene(scene); //Define a cena que será exibida.
        primaryStage.setTitle("Login");// Nome que vai aparecer na tela.
        primaryStage.setResizable(false);// Com essa função a tela não pode ser redimensionada.
        
        // Exibe a janela com a cena.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  //Inicia a aplicação JavaFX.
    }
}
