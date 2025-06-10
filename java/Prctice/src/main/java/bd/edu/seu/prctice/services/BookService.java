package bd.edu.seu.prctice.services;

import bd.edu.seu.prctice.interfaces.BookInterface;
import bd.edu.seu.prctice.model.Book;
import bd.edu.seu.prctice.utility.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookService implements BookInterface {
    @Override
    public void insertBook(Book book) {
        try{
            Connection connection = ConnectionSingleton.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2,book.getTitle());
            preparedStatement.setDouble(3,book.getPrice());
            preparedStatement.setInt(4,book.getQuantity());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Failed to insert Book");
            e.printStackTrace();
        }
    }



    @Override
    public void updateBook(Book oldBook, Book updatedBook) {
        try{
            Connection connection = ConnectionSingleton.getConnection();
            String query = "update book set id=?, title=?, price=?, quamtity=? where id=? and title=? and price=? and quantity=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, updatedBook.getId());
            preparedStatement.setString(2, updatedBook.getTitle());
            preparedStatement.setDouble(3, updatedBook.getPrice());
            preparedStatement.setInt(4, updatedBook.getQuantity());

            preparedStatement.setInt(5, oldBook.getId());
            preparedStatement.setString(6, oldBook.getTitle());
            preparedStatement.setDouble(7, oldBook.getPrice());
            preparedStatement.setInt(8, oldBook.getQuantity());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            System.out.println("Failed to update Book");
            e.printStackTrace();
        }

    }

    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public List<Book> getBooksObservableList() {
        List<Book> booksObservableList = new ArrayList<>();
        try{
            Connection connection = ConnectionSingleton.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble(3), resultSet.getInt(4));
                booksObservableList.add(book);
            }
        }catch(SQLException e){
            System.out.println("Failed to get Books");
            e.printStackTrace();
        }
        return booksObservableList;
    }
}
