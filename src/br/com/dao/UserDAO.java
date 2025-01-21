package br.com.dao;

import br.com.dao.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ronaldo neto
 */
public class UserDAO {
    
    public boolean validateUser(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
        try(Connection conexao = ConnectionDataBase.conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql)){
            
            
            stmt.setString(1,username);
            stmt.setString(2, password);
            
            try(ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch(Exception e){
                System.out.println("Erro ao conectar ao banco" + e.getMessage());
                return false;
                }
    }
    
}
