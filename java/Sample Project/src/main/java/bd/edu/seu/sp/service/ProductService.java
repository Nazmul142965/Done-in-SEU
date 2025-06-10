package bd.edu.seu.sp.service;

import bd.edu.seu.sp.model.Product;
import bd.edu.seu.sp.utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public void insert(Product product){
        try{
            Connection connection = ConnectionSingleton.getConnection();
             Statement statement = connection.createStatement();
            String query  = "INSERT INTO product VALUES(" + product.getId() + "', '" + product.getName() + "','" + product.getPrice() + " ')";;
            statement.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error inserting product");
            e.printStackTrace();
        }
    }

    public void update(Product product){
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query  = "UPDATE product SET name='" + product.getName() + "', price=" + product.getPrice() + " WHERE id=" + product.getId();;
            statement.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error updating product");
            e.printStackTrace();
        }
    }

    public void delete(Product product){
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query  = "DELETE FROM product WHERE id=" + product.getId();;
            statement.executeUpdate(query);
        }catch(Exception e){
            System.out.println("Error deleting product");
            e.printStackTrace();
        }
    }

    public List<Product> list(){
        List<Product> products = new ArrayList<>();
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query  = "SELECT * FROM product";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Product product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getDouble("price"));
//                product.setId(resultSet.getInt("id"));
//                product.setName(resultSet.getString("name"));
//                product.setPrice(resultSet.getDouble("price"));
                products.add(product);

            }
        }catch(Exception e){
            System.out.println("Error listing product");
            e.printStackTrace();
        }
        return products;
    }

}
