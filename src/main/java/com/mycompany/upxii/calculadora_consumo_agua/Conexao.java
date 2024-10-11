
package com.mycompany.upxii.calculadora_consumo_agua;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    
    public static Connection getConexao() throws SQLException{
        Connection conexao = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/CalculadoraConsumoAgua", "root", "SQL10122005#");
 
            return conexao;
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado");
        } catch (SQLException ex) {
            System.out.println("ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return null;
    }
        
        
    
    
    
}
