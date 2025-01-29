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
   
   //Método para o botão "Novo". reutilizando o método de limpar os campos na tela de cadastro.
   @FXML
   private void onNovoClick(){
       limparCampos();
       System.out.println("Campos limpos!");
   }
   
   //Método para o botão "Salvar". reutilizando o método de limpar os campos na tela de cadastro.
   @FXML
   private void onSalvarClick() throws SQLException{
       salvarProduto();
      
   }
   
   
   //Método para salvar os produtos.
   private void salvarProduto() throws SQLException{
       
       System.out.println("Método salvarProduto() chamado.");
       
       //Validação dos campos
       
       if(textOs.getText().isEmpty() || 
          textProduto.getText().isEmpty() || 
          textQuantidade.getText().isEmpty() || 
          textMetragem.getText().isEmpty()  || 
          textDescricao.getText().isEmpty()       ||
          textFornecedor.getText().isEmpty()      ||   
          choiceBoxerCategoria.getValue() == null ||
          datePickerCadastro.getValue() == null) {
       
         // Exibe um alerta se algum campo estiver vazio ou inválido
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Campos obrigatórios");
         alert.setHeaderText("Preencha todos os campos obrigatórios!");
         alert.setContentText("Por favor, verifique se todos os campos estão preenchidos corretamente.");
         alert.showAndWait();
         return; //Encerra o método se houver campos inválidos
   }
       
       
       //Verifica se o campo 'os' é um número inteiro válido
       int os;
       try{
          os = Integer.parseInt(textOs.getText());
        
       }catch (NumberFormatException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erro de Entrada!");
           alert.setHeaderText("Campo 'OS' inválido");
           alert.setContentText("Por favor, insira um número válido para o campo 'OS' ");
           alert.showAndWait();
           return;// Emcerra o método se o valor de 'os' for inválido
       }
       
       //Verifica se o campo 'quantidade' é um número inteiro válido 
       int quantidade;
       try {
           quantidade = Integer.parseInt(textQuantidade.getText());
           if(quantidade < 0){
               throw new NumberFormatException(); // Lança uma exceção se o número for inválido (menor que 0)
           }
       } catch (NumberFormatException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erro de Entrada");
           alert.setHeaderText("Campo 'Quantidade' inválido");
           alert.setContentText("Por favor, insira um número válido para a quantidade");
           alert.showAndWait();
           return; //Encerra o método se o valor de 'quantidade' for inválido
       }
       
       //Verifica se o campo 'metragem' é um número decimal válido
       double metragem;
       try {
           metragem = Double.parseDouble(textMetragem.getText());
           if(metragem <=0){
               throw new NumberFormatException(); // Lança uma exceção se o número for inválido (menor ou igual a 0)
           }
       } catch (NumberFormatException e) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erro de Entrada");
           alert.setHeaderText("Campo 'Metragem' inválido");
           alert.setContentText("Por favor, insira um número válido para a metragem");
           alert.showAndWait();
           return; //Encerra o método se o valor de 'quantidade' for inválido
       }
       
       
       //Continua com a criação do objeto produto
       Produto produto = new Produto();
       
       produto.setOs(Integer.parseInt(textOs.getText()));
       produto.setProduto(textProduto.getText());
       produto.setQuantidade(Integer.parseInt(textQuantidade.getText()));
       produto.setMetragem(Double.parseDouble(textMetragem.getText()));
       produto.setDescricao(textDescricao.getText());
       produto.setFornecedor(textFornecedor.getText());
       produto.setCategoria(choiceBoxerCategoria.getValue());
       produto.setDataCadastro(datePickerCadastro.getValue());
       
       
       produtoDAO.salvar(produto);
       
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Sucesso");
       alert.setHeaderText("Produto cadastrado com sucesso");
       alert.showAndWait();
        
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
