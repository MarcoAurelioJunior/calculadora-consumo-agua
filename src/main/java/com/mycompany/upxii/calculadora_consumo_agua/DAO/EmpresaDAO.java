package com.mycompany.upxii.calculadora_consumo_agua.DAO;

import com.mycompany.upxii.calculadora_consumo_agua.Classes.Empresa;
import com.mycompany.upxii.calculadora_consumo_agua.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO {

    public Empresa obterEmpresaPorId(int idEmpresa) throws SQLException {
        String sql = "SELECT * FROM empresas_tarifas WHERE id_empresa = ?";
        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);

            ps.setInt(1, idEmpresa);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String nome = rs.getString("nome_empresa");
                double tarifaFixa = rs.getDouble("tarifa_fixa");
                double faixa1Tarifa = rs.getDouble("faixa_1_tarifa");
                double faixa2Tarifa = rs.getDouble("faixa_2_tarifa");
                double faixa3Tarifa = rs.getDouble("faixa_3_tarifa");
                // Data da última atualização se precisar
                String dataUltimaAtualizacao = rs.getString("data_ultima_atualizacao");

                Empresa empresa = new Empresa(nome, tarifaFixa, faixa1Tarifa, faixa2Tarifa, faixa3Tarifa, dataUltimaAtualizacao);
                return empresa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public Empresa obterEmpresaPorId(Empresa empresa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
