package br.com.main;

import javafx.application.Application; // Classe base para aplicações JavaFX.
import javafx.fxml.FXMLLoader; // Usado para carregar o arquivo FXML.
import javafx.scene.Scene; // Contêiner para os elementos da interface.
import javafx.stage.Stage; // Representa a janela.
import javafx.scene.layout.AnchorPane; // Layout AnchorPane.


public class CapotariaBatista_ControleEstoque extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception { 
        // Carrega o arquivo FXML da tela de Cadastro de Produtos.
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/br/com/view/CadastroProduto.fxml"));
        
        // Define a cena com a tela de Cadastro de Produtos.
        Scene scene = new Scene(root);  
        
        primaryStage.setScene(scene); // Define a cena a ser exibida.
        primaryStage.setTitle("Login"); // Define o título da janela.
        primaryStage.setResizable(false); // Impede o redimensionamento da janela.
        
        // Exibe a janela com a cena.
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX.
    }
}