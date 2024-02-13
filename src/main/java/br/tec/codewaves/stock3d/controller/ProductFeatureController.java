package br.tec.codewaves.stock3d.controller;

import br.tec.codewaves.stock3d.util.ConnectionFactory;
import br.tec.codewaves.stock3d.model.ProductFeatures;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public void save(ProductFeatures productFeatures) {
        String sql = "INSERT INTO prod_features (material,"
                + " type_material,"
                + " manufacturer,"
                + " diameter,"
                + " ret_distance,"
                + " ret_speed,"
                + " extrude_temp_range,"
                + " bed_temp_range)"
                + " VALUES (?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Cria uma conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Cria um PreparedStatement para executar a query
            statement = connection.prepareStatement(sql);


            statement.setString(1, productFeatures.getMaterial());
            statement.setString(2, productFeatures.getType_material());
            statement.setString(3, productFeatures.getManufacturer());
            statement.setDouble(4, productFeatures.getDiameter());
            statement.setDouble(5, productFeatures.getRet_distance());
            statement.setDouble(6, productFeatures.getRet_speed());
            statement.setString(7, productFeatures.getExtrude_temp_range());
            statement.setString(8, productFeatures.getBed_temp_range());


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

    public List<ProductFeatures> getAll(String optionA, String optionB){

        String sql = "SELECT * FROM prod_features WHERE "
            + optionA + " = '" + optionB + "'";

        //Lista de tarefas que será devolvida quando o método acontecer
        List<ProductFeatures> productFeatures = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;


        try {
            //Criando a conexão
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            //Não necessário >> Setando o valor que corresponde ao filtro de busca
            //statement.setInt(1,id);

            //Valor retornado pela execução da query
            resultSet = statement.executeQuery();

            //Enquanto houverem valores a serem percorridos no meu resultado
            while(resultSet.next()){
                ProductFeatures productFeatures = new ProductFeatures();

                productFeatures.setId_feature(resultSet.getInt("id_feature"));
                productFeatures.setMaterial(resultSet.getString("material"));
                productFeatures.setType_material(resultSet.getString("type_material"));
                productFeatures.setManufacturer(resultSet.getString("manufacturer"));
                productFeatures.setDiameter(resultSet.getDouble("diameter"));
                productFeatures.setRet_distance(resultSet.getDouble("ret_distance"));
                productFeatures.setRet_speed(resultSet.getDouble("ret_speed"));
                productFeatures.setExtrude_temp_range(resultSet.getString("extrude_temp_range"));
                productFeatures.setBed_temp_range(resultSet.getString("bed_temp_range"));

                productFeatures.add(productFeatures);
            }


        } catch (SQLException ex){
            throw new RuntimeException("ERRO ao inserir a tarefa" + ex.getMessage(), ex);
        } finally {
            //Fecha as conexões
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
        //Lista de tarefas que foi criada e carregada
        return productFeatures;
    }


}
