package service.product;

import model.ProductModel;

import java.util.List;

public interface IProducts  {
    List<ProductModel> showAll();
    ProductModel findById(int id);
    ProductModel findUserByUserName(String name);
    void create(ProductModel productModel);
    void remove(int id);
    void update(ProductModel productModel);
}

