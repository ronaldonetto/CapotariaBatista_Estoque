package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ronaldo neto
 */
public class ConnectionDataBase {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/estoque_capotaria";
    private static final String USUARIO = "root";
    private static final String SENHA = "Reg.3388";
    
    
    public static Connection conectar(){
        Connection conexao = null;
        try{
            //Registra o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //Estabelece a conexão
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida");
        }catch(ClassNotFoundException e){
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
        }catch(SQLException e){
            System.out.println("Erro ao conectar o banco de dados: " + e.getMessage());
        }
        return conexao;
    }
    
    
    public static void testarConexao(){
        Connection conexao = conectar();
        
        if(conexao != null){
            try{
                //Realiza uma consulta simples para verificar se a conexão está funcionando
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1"); //Uma consulta simples
                if(rs.next()) {
                    System.out.println("Conexão bem-sucedida com o banco de dados!");
                }
                rs.close();
                stmt.close();
            } catch(SQLException e){
                System.out.println("Erro ao executar a consulta: " + e.getMessage());
            } finally{
                try {
                    if(conexao != null) {
                        conexao.close(); //Fecha a conexão após o uso
                    }
                } catch (SQLException e){
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
    }
    
    public static void main(String[] args){
        //Testar a conexão
        conectar();
    }
    
}
