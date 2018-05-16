package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AcessoBanco {
    
    public static void insertData(String requerente, String setor, String reclamacao, String conclusao, String status, String data, String atendente){
        Connection conexao = ConexaoBanco.openConnection();
        PreparedStatement sql;
        
        try {
            sql = conexao.prepareStatement("INSERT INTO chamados(requerente, setor, reclamacao, conclusao, status, data, atendente) VALUES('"+requerente+"','"+setor+"','"+reclamacao+"', '"+conclusao+"', '"+status+"', '"+data+"', '"+atendente+"')");
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado no banco com sucesso.");
            
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(conexao);
        }
    }
    
     public static String consultarData(int id){
        Connection conexao = ConexaoBanco.openConnection();
        String sql = "SELECT data, atendente FROM chamados WHERE id = '"+id+"'";
        
        String dataChamado = "null";
        
        try {
           Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
            
                dataChamado = result.getString("data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(conexao);
            System.out.println("Conexão fechada.");
        }
        return dataChamado;
    }
     public static String consultarAtendente(int id){
        Connection conexao = ConexaoBanco.openConnection();
        String sql = "SELECT atendente FROM chamados WHERE id = '"+id+"'";
        
        String nomeAtendente = "null";
        
        try {
           Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
            
                nomeAtendente = result.getString("atendente");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(conexao);
            System.out.println("Conexão fechada.");
        }
        return nomeAtendente;
    }
 
     public static void updateData(int id, String requerente, String setor, String reclamacao, String conclusao, String status){
        Connection conexao = ConexaoBanco.openConnection();
        PreparedStatement sql;
        
        try {
            sql = conexao.prepareStatement("UPDATE chamados SET requerente = '"+requerente+"', setor = '"+setor+"', reclamacao = '"+reclamacao+"', conclusao = '"+conclusao+"', status = '"+status+"' WHERE id = '"+id+"'");
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editado no banco.");
            
        } catch (SQLException ex) {
            Logger.getLogger(AcessoBanco.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoBanco.closeConnection(conexao);
        }
    }
}




