
package com.mycompany.upxii.calculadora_consumo_agua.DAO;

import com.mycompany.upxii.calculadora_consumo_agua.Conexao;
import com.mycompany.upxii.calculadora_consumo_agua.Classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario){
        String sqlCadastro = "INSERT INTO usuario (usuarioLog, nome, email, senha, id_empresa) VALUES (?,?,?,?,?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sqlCadastro);
            
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setInt(5, usuario.getEmpresa());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Deu erro aqui!!!" + ex.getMessage());
        }
    }
    
    public boolean loginUsuario(Usuario usuario){
        String sqlLogin = "SELECT * FROM usuario WHERE usuarioLog = ? AND senha = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sqlLogin);
                        
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getString("usuarioLog") != null && rs.getString("senha") != null){
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Deu erro neste lugar");
        }
        return false;
        
    }
    
    public Usuario userLogadoInfo(Usuario usuario){
         String sqlLogin = "SELECT * FROM usuario WHERE usuarioLog = ? AND senha = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sqlLogin);
                        
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                if(rs.getString("usuarioLog") != null && rs.getString("senha") != null){
                    int idUsuario = rs.getInt("id_usuario"); //Pega o ID gerado automaticamente pelo BD e armazena numa variavel
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    int empresa = rs.getInt("id_empresa");
                    
                    Usuario userLogin = new Usuario(idUsuario, nome, email, empresa);
                    return userLogin;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Deu erro neste lugar");
        }
        return null;
    }
    
    
}
