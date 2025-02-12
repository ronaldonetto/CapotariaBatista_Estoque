package br.com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import br.com.model.Produto;
import br.com.dao.ProdutoDAO;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

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
    private ListView<Produto> ListView;
    
    @FXML
    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
    
    @FXML 
    private Button btnNovo, btnSalvar, btnEditar, btnExcluir, btnCancelar, btnPesquisar, btnSair;
    
    private ProdutoDAO produtoDAO = new ProdutoDAO();  
    
    private Produto produto = new Produto();
    
   //Método para inicializar automaticamente ao carregar a FXML
   @FXML
   public void initialize(){
       //Configurações iniciais, como carregar categorias e unidades de medida
       carregarCategorias();
       
       // Carregar produtos existentes do banco
       try {
         List<Produto> produtos = produtoDAO.buscarTodos();
         listaProdutos.addAll(produtos);  // Adiciona todos os produtos ao ObservableList
       } catch (SQLException e) {
          e.printStackTrace();  // Trate os erros do banco adequadamente
       }
       
       // Configura o ListView
       ListView.setItems(listaProdutos);
    
       // Configurar o CellFactory para exibir as informações de forma mais estruturada
       ListView.setCellFactory(param -> new ListCell<Produto>() {
        @Override
        protected void updateItem(Produto item, boolean empty) {
            super.updateItem(item, empty);
            if (item != null) {
                // Criar o HBox para organizar as informações visualmente
                HBox hbox = new HBox();
                hbox.setSpacing(10);
                
                // Criar os elementos de label para os títulos e valores
                Label labelOs = new Label("Os:");
                Label labelProduto = new Label("Produto:");
                Label labelCategoria = new Label("Categoria:");
                Label labelQuantidade = new Label("Quantidade:");
                Label labelMetragem = new Label("Metragem:");
                
                // Criar as labels para os valores dos campos
                Label valorOs = new Label(String.valueOf(item.getOs()));
                Label valorProduto = new Label(item.getProduto());
                Label valorCategoria = new Label(item.getCategoria());
                Label valorQuantidade = new Label(String.valueOf(item.getQuantidade()));
                Label valorMetragem = new Label(String.valueOf(item.getMetragem()) + " m²");

                // Estilizar os títulos com negrito
                labelOs.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
                labelProduto.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;"); 
                labelCategoria.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
                labelQuantidade.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
                labelMetragem.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
                
                // Estilizar os valores (sem negrito, texto normal)
                valorOs.setStyle("-fx-font-size: 12px; -fx-text-fill: #1a1a1a;");
                valorProduto.setStyle("-fx-font-size: 12px; -fx-text-fill: #1a1a1a;");
                valorCategoria.setStyle("-fx-font-size: 12px; -fx-text-fill: #1a1a1a;");
                valorQuantidade.setStyle("-fx-font-size: 12px; -fx-text-fill: #1a1a1a;");
                valorMetragem.setStyle("-fx-font-size: 12px; -fx-text-fill: #1a1a1a;");
                
                // Adicionar as labels e valores no HBox
                hbox.getChildren().addAll(labelOs, valorOs, labelProduto, valorProduto, labelCategoria, valorCategoria, labelQuantidade, valorQuantidade, labelMetragem, valorMetragem);
                
                // Exibir o HBox no ListCell
                setGraphic(hbox);
            } else {
                setGraphic(null);  // Limpar o conteúdo da célula caso esteja vazia
            }
        }
    });
}
   
   private void carregarProdutosDoBanco() {
    try {
        // Aqui você faria a consulta no banco para carregar os produtos
        List<Produto> produtos = produtoDAO.buscarTodos();
        listaProdutos.addAll(produtos);  // Adiciona todos os produtos à lista
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
   //Método para carregar as categorias disponiveis.
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
       produto.setDataCadastro(LocalDateTime.now());
       
       //Salva o produto
       produtoDAO.salvar(produto);
       
       //Adiciona o produto no observableList (isso vai atualizar o ListView automaticamente). 
       listaProdutos.add(produto);
       
       ListView.setItems(listaProdutos);
               
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
