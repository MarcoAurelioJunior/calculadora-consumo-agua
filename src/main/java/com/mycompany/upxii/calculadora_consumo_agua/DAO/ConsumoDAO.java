package com.mycompany.upxii.calculadora_consumo_agua.DAO;

import com.mycompany.upxii.calculadora_consumo_agua.Classes.Consumo;
import com.mycompany.upxii.calculadora_consumo_agua.Classes.Usuario;
import com.mycompany.upxii.calculadora_consumo_agua.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsumoDAO {
    public void adicionaConsumo(Consumo consumo, Usuario usuario){
        String sqlConsumo = "INSERT INTO consumo (id_usuario, quantidade_litros, descricao) VALUES (?,?,?)"; 
        
        PreparedStatement ps = null;
        
        try {
            ps = Conexao.getConexao().prepareStatement(sqlConsumo);
                
            ps.setInt(1, usuario.getIdUsuario()); //Armazena no BD a chave estrangeiro do USUARIO que adicionou um consumo
            ps.setDouble(2, consumo.getQuantidade_litros());
            ps.setString(3, consumo.getDescricao());

            
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Deu erro aqui!!!" + ex.getMessage());
        }
    }
}
