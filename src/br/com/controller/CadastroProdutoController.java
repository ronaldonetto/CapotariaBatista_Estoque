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
    
   
    
}
