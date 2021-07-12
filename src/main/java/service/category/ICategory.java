package service.category;

import model.CategoryModel;
import model.ProductModel;

import java.util.List;

public interface ICategory {
    List<CategoryModel> showAll();
    CategoryModel findById(int id);
    void create(CategoryModel categoryModel);
    void remove(int id);
    void update(CategoryModel categoryModel);
}
