package br.com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import br.com.model.Produto;
import br.com.dao.ProdutoDAO;
import java.sql.SQLException;
import javafx.scene.control.Button;

/**
 *
 * @author ronaldo neto
 */
public class CadastroProdutoController {
    
    @FXML
    private TextField textOs, textProduto, textQuantidade, textDescricao, textMetragem, textFornecedor;
    
    @FXML
    private Label labelOs, labelProduto, labelQuantidade, labelDescricao, labelMetragem, labelFornecedor;
    
    @FXML
    private DatePicker datePickerCadastro;
    
    @FXML 
    private ChoiceBox<String> choiceBoxerCategoria;
    
    @FXML 
    private Button btnNovo, btnSalvar, btnEditar, btnExcluir, btnCancelar, btnPesquisar, btnSair;
    
    private ProdutoDAO produtoDAO = new ProdutoDAO();  
    
   //Método para inicializado automaticamente ao carregar a FXML
   @FXML
   public void initialize(){
       //Configurações iniciais, como carregar categorias e unidades de medida
       carregarCategorias();
       
   }
   
   public void carregarCategorias(){
       //Adiciona categorias disponiveis
       choiceBoxerCategoria.getItems().addAll("Náutico", "Automotivo", "Residencial", "Industrial");    
   }
   
   //Método para limpar os campos na tela de cadastro
   private void limparCampos() {
        textOs.clear();
        textProduto.clear();
        textQuantidade.clear();
        textDescricao.clear();
        textMetragem.clear();
        textFornecedor.clear();
        choiceBoxerCategoria.setValue(null);
        datePickerCadastro.setValue(null);
        
    }
   

    
}
