/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dma
 */
public class ConexaoBanco {
    
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:C:/Users/informatica/Documents/ControleDeChamados/db/chamados.db";
    
    public static Connection openConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void closeConnection(Connection conexao){
        if(conexao != null){
            try {
                conexao.close();
                System.out.println("Conexão finalizada.");
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void closeConnection(Connection conexao, PreparedStatement statement){
        closeConnection(conexao);
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
   
        public static void closeConnection(Connection conexao, PreparedStatement statement, ResultSet result){
            closeConnection(conexao, statement);
            
            if(result != null){
            try {
                result.close();
                System.out.println("Conexão desconectada.");
            } catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}


