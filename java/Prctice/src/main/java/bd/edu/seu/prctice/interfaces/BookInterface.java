package bd.edu.seu.prctice.interfaces;

import bd.edu.seu.prctice.model.Book;

import java.util.List;

public interface BookInterface {
    void insertBook(Book book);
    void updateBook(Book oldBook,Book updatedBook);
    void deleteBook(Book book);
    List<Book> getBooksObservableList();


}
