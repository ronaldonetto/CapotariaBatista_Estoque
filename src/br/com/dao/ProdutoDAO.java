package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.model.Produto;
import br.com.dao.ConnectionDataBase;
import java.sql.Date;


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
            stmt.setDate(8, Date.valueOf(produto.getDataCadastro()));
            
            stmt.executeUpdate();
        }
 
    }
}    

