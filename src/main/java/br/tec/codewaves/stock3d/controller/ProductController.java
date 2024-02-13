package br.tec.codewaves.stock3d.controllers;

import br.tec.codewaves.stock3d.utils.ConnectionFactory;
import br.tec.codewaves.stock3d.models.ProductModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    public void save(ProductModel productModel) {
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


            statement.setString(1,productModel.getMaterial());
            statement.setString(2,productModel.getType_material());
            statement.setString(3,productModel.getManufacturer());
            statement.setDouble(4,productModel.getDiameter());
            statement.setDouble(5,productModel.getRet_distance());
            statement.setDouble(6,productModel.getRet_speed());
            statement.setString(7,productModel.getExtrude_temp_range());
            statement.setString(8,productModel.getBed_temp_range());


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

    public List<ProductModel> getAll(){

        String sql = "SELECT * FROM prod_features";

        //Lista de tarefas que será devolvida quando o método acontecer
        List<ProductModel> productModels = new ArrayList<>();

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
                ProductModel productModel = new ProductModel();

                productModel.setId_feature(resultSet.getInt("id_feature"));
                productModel.setMaterial(resultSet.getString("material"));
                productModel.setType_material(resultSet.getString("type_material"));
                productModel.setManufacturer(resultSet.getString("manufacturer"));
                productModel.setDiameter(resultSet.getDouble("diameter"));
                productModel.setRet_distance(resultSet.getDouble("ret_distance"));
                productModel.setRet_speed(resultSet.getDouble("ret_speed"));
                productModel.setExtrude_temp_range(resultSet.getString("extrude_temp_range"));
                productModel.setBed_temp_range(resultSet.getString("bed_temp_range"));

                productModels.add(productModel);
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
        return productModels;
    }


}
