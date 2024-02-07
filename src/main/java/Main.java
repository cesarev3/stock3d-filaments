import br.tec.codewaves.stock3d.controllers.ProductController;
import br.tec.codewaves.stock3d.models.ProductModel;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)throws SQLException {
        ProductController productController = new ProductController();

        //Incluir novo Projeto
        ProductModel productModel = new ProductModel();

        productModel.setCodigo("P004");
        productModel.setMaterial("PLA");
        productModel.setTipo("Normal");
        productModel.setCor("Preto Fosco");
        productModel.setFabricante("3DLab");
        productModel.setFab_produto("1099");
        productModel.setDiametro(1.75);
        productModel.setRetracao_distancia(9);
        productModel.setRetracao_velocidade(45);
        productModel.setBico_temperaturas("190 a 220");
        productModel.setTemperatura_bico(215);
        productModel.setMesa_temperaturas("50 a 60");
        productModel.setTemperatura_mesa(60);
        productModel.setVentoinha(100);
        productModel.setAtivo(true);


        productController.save(productModel);

    }
}
