import br.tec.codewaves.stock3d.controller.ProductFeatureController;
import br.tec.codewaves.stock3d.model.ProductFeature;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args)throws SQLException {
        ProductFeatureController productFeatureController = new ProductFeatureController();

        //Incluir novo Projeto
//        ProductFeature productFeature = new ProductFeature();
//
//        productFeature.setMaterial("TPU");
//        productFeature.setType_material("Flex");
//        productFeature.setManufacturer("Creality");
//        productFeature.setDiameter(1.75);
//        productFeature.setRet_distance(7);
//        productFeature.setRet_speed(50);
//        productFeature.setExtrude_temp_range("220 a 250");
//        productFeature.setBed_temp_range("50 a 65");
//
//        productController.save(productModel);

        //Listar a quantidade de projetos
            List<ProductFeature> productFeatures = productFeatureController.getAll("material", "TPU");
            for (ProductFeature products : productFeatures) {
                System.out.print(products.getId_feature() + " ");
                System.out.print(products.getMaterial() + " ");
                System.out.print(products.getType_material() + " ");
                System.out.print(products.getManufacturer() + " ");
                System.out.println(products.getDiameter());
            }

            System.out.println("Total de produtos = " + productFeatures.size());

        //Editar um produto
//        ProductFeature productFeature = new ProductFeature();
////
//        productFeature.setMaterial("TPU");
//        productFeature.setType_material("Flex");
//        productFeature.setManufacturer("Master World");
//        productFeature.setDiameter(1.75);
//        productFeature.setRet_distance(7);
//        productFeature.setRet_speed(50);
//        productFeature.setExtrude_temp_range("220 a 250");
//        productFeature.setBed_temp_range("50 a 65");
//        productFeature.setId_feature(8);
//
//        productFeatureController.update(productFeature);

        //Deletar produtos
//           productFeatureController.removeByid(9);

    }
}
