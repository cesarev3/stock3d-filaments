package br.tec.codewaves.stock3d.controllers;

import br.tec.codewaves.stock3d.utils.ConnectionFactory;
import br.tec.codewaves.stock3d.models.ProductModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductController {

    public void save(ProductModel productModel) {
        String sql = "INSERT INTO produtos (codigo,"
                + " material,"
                + " tipo,"
                + " cor,"
                + " fabricante,"
                + " fab_produto,"
                + " diametro,"
                + " retracao_distancia,"
                + " retracao_velocidade,"
                + " bico_temperaturas,"
                + " temperatura_bico,"
                + " mesa_temperaturas,"
                + " temperatura_mesa,"
                + " ventoinha,"
                + " ativo)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Cria uma conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Cria um PreparedStatement para executar a query
            statement = connection.prepareStatement(sql);


            statement.setString(1,productModel.getCodigo());
            statement.setString(2,productModel.getMaterial());
            statement.setString(3,productModel.getTipo());
            statement.setString(4,productModel.getCor());
            statement.setString(5,productModel.getFabricante());
            statement.setString(6,productModel.getFab_produto());
            statement.setDouble(7,productModel.getDiametro());
            statement.setDouble(8,productModel.getRetracao_distancia());
            statement.setDouble(9,productModel.getRetracao_velocidade());
            statement.setString(10,productModel.getBico_temperaturas());
            statement.setInt(11,productModel.getTemperatura_bico());
            statement.setString(12,productModel.getMesa_temperaturas());
            statement.setInt(13,productModel.getTemperatura_mesa());
            statement.setInt(14,productModel.getVentoinha());
            statement.setBoolean(15,productModel.isAtivo());

            //Executa a SQL de inserção de dados
            statement.execute();

        } catch (SQLException ex){
            throw new RuntimeException("ERRO ao salvar a tarefa");
        } finally {
            //Fecha as conexões
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
    }
}
