package br.com.dao;

import br.com.controller.CadastroProdutoController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.model.Produto;
import br.com.dao.ConnectionDataBase;

import java.time.LocalDateTime;
import java.sql.Timestamp;


/**
 *
 * @author ronaldo neto
 */

public class ProdutoDAO {
    
    
    
    //Método para salvar os produtos no banco de dados. Utilizado queries 
    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO Produtos (os_produto, nome_produto, categoria, quantidade_metro, quantidade, descricao, fornecedor, data_cadastro)  VALUES (?,?,?,?,?,?,?,?)";     
        try (Connection conn = ConnectionDataBase.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, produto.getOs());
            stmt.setString(2, produto.getProduto());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getMetragem());
            stmt.setInt(5, produto.getQuantidade());
            stmt.setString(6, produto.getDescricao());
            stmt.setString(7, produto.getFornecedor());
            
            // Obtém a data e hora atual
            LocalDateTime dataCadastroComHoraAtual = LocalDateTime.now();

            // Converte LocalDateTime para Timestamp
            Timestamp timestamp = Timestamp.valueOf(dataCadastroComHoraAtual);
            stmt.setTimestamp(8, timestamp);
            
            stmt.executeUpdate();
        }
      
    }
    
    public List<Produto> buscarTodos() throws SQLException {
    List<Produto> produtos = new ArrayList<>();
    String sql = "SELECT * FROM Produtos";  // Exemplo de consulta SQL
    try (Connection conn = ConnectionDataBase.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setOs(rs.getInt("os_produto"));
            produto.setProduto(rs.getString("nome_produto"));
            produto.setQuantidade(rs.getInt("quantidade_metro"));
            produto.setMetragem(rs.getDouble("quantidade"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setFornecedor(rs.getString("fornecedor"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
            produtos.add(produto);
        }
    }
    return produtos;
}
    
 }   

