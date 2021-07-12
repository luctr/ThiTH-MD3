package service.category;

import model.CategoryModel;
import model.ProductModel;
import service.connertion.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategory{
    public List<CategoryModel> showAll() {
        Connection connection = ConnectionJDBC.getConnection();
        List<CategoryModel> list = new ArrayList<>();
        String sql = "select * from category  ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = ConnectionJDBC.getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setId(resultSet.getInt("idproduct"));
                categoryModel.setCategoryName(resultSet.getString("name"));
                list.add(categoryModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }
        return list;
    }

    @Override
    public CategoryModel findById(int id) {
        Connection connection = ConnectionJDBC.getConnection();
        String sql = "select * from category where category_id = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CategoryModel categoryModel = new CategoryModel();
                categoryModel.setId(resultSet.getInt("category_id"));
                categoryModel.setCategoryName(resultSet.getString("category_name"));
                return categoryModel;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                if (connection != null){
                    connection.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void create(CategoryModel categoryModel) {
        Connection connection = ConnectionJDBC.getConnection();
        String sql = "insert into category (category_name) value (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,categoryModel.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = ConnectionJDBC.getConnection();
        String sql = "delete from category where category_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void update( CategoryModel categoryModel) {
        Connection connection = ConnectionJDBC.getConnection();
        String sql = "update category set category_id= ?, category_name = ? where category_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryModel.getId());
            preparedStatement.setString(2, categoryModel.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
