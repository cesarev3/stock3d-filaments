package br.tec.codewaves.stock3d.controller;

import br.tec.codewaves.stock3d.util.ConnectionFactory;
import br.tec.codewaves.stock3d.model.ProductFeature;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductFeatureController {

    public void save(ProductFeature productFeature) {
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


            statement.setString(1, productFeature.getMaterial());
            statement.setString(2, productFeature.getType_material());
            statement.setString(3, productFeature.getManufacturer());
            statement.setDouble(4, productFeature.getDiameter());
            statement.setDouble(5, productFeature.getRet_distance());
            statement.setDouble(6, productFeature.getRet_speed());
            statement.setString(7, productFeature.getExtrude_temp_range());
            statement.setString(8, productFeature.getBed_temp_range());


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

    public List<ProductFeature> getAll(String optionA, String optionB){

        String sql = "SELECT * FROM prod_features WHERE "
            + optionA + " = '" + optionB + "'";

        //Lista de tarefas que será devolvida quando o método acontecer
        List<ProductFeature> productFeatures = new ArrayList<>();

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
                ProductFeature productFeature = new ProductFeature();

                productFeature.setId_feature(resultSet.getInt("id_feature"));
                productFeature.setMaterial(resultSet.getString("material"));
                productFeature.setType_material(resultSet.getString("type_material"));
                productFeature.setManufacturer(resultSet.getString("manufacturer"));
                productFeature.setDiameter(resultSet.getDouble("diameter"));
                productFeature.setRet_distance(resultSet.getDouble("ret_distance"));
                productFeature.setRet_speed(resultSet.getDouble("ret_speed"));
                productFeature.setExtrude_temp_range(resultSet.getString("extrude_temp_range"));
                productFeature.setBed_temp_range(resultSet.getString("bed_temp_range"));

                productFeatures.add(productFeature);
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

    public void update(ProductFeature productFeature) {
        String sql = "UPDATE prod_features SET "
                + "material = ?, "
                + "type_material = ?, "
                + "manufacturer = ?, "
                + "diameter = ?, "
                + "ret_distance = ?, "
                + "ret_speed = ?, "
                + "extrude_temp_range = ?, "
                + "bed_temp_range = ? "
                + "WHERE id_feature = ?";


        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a Query
            statement = connection.prepareStatement(sql);

            //Setando os valores do statement
            statement.setString(1, productFeature.getMaterial());
            statement.setString(2, productFeature.getType_material());
            statement.setString(3, productFeature.getManufacturer());
            statement.setDouble(4, productFeature.getDiameter());
            statement.setDouble(5, productFeature.getRet_distance());
            statement.setDouble(6, productFeature.getRet_speed());
            statement.setString(7, productFeature.getExtrude_temp_range());
            statement.setString(8, productFeature.getBed_temp_range());
            statement.setInt(9, productFeature.getId_feature());

            //Executando a query
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("ERRO ao atualizar a tarefa");
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

    public void removeByid(int id) {
        String sql = "DELETE FROM prod_features WHERE id_feature = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Criando a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();

            //Preparando a query
            statement = connection.prepareStatement(sql);

            //Setando os valores
            statement.setInt(1, id);

            //Executandoa query
            statement.execute();

        } catch (SQLException ex){
            throw new RuntimeException("ERRO ao deletar a tarefa" + ex.getMessage());
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
