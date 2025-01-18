package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * 
 * @author ronaldo neto
 */
public class ConnectionDataBase {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/estoque_capotaria";
    private static final String USUARIO = "root";
    private static final String SENHA = "Reg.3388";
    
    /**
     * Estabelece uma conexão com o banco de dados.
     *
     * @return Connection objeto de conexão ou null em caso de falha.
     */
    
    /**
     * Estabelece uma conexão com o banco de dados.
     *
     * @return Connection objeto de conexão ou null em caso de falha.
     */
    public static Connection conectar() {
        try {
            // Registra o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelece a conexão
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            return conexao;
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return null;
    }
    /**
     * 
     * Testa a conexão com o banco de dados.
     * 
     */
    
    public static void testarConexao() {
        try (Connection conexao = conectar()) {
            if (conexao != null) {
                System.out.println("Conexão bem-sucedida com o banco de dados!");
            } else {
                System.out.println("Falha ao conectar com o banco de dados.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
        
        }
    
     /**
     * Método principal para testar a classe.
     *
     * @param args argumentos da linha de comando.
     */
    public static void main(String[] args) {
        testarConexao();
    }
 }
    
  

