/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import recommendation_library.domain.BookRecommendation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import recommendation_library.domain.Type;

/**
 *
 * @author anadis
 */
public class DatabaseRecommendationDao implements RecommendationDao {

    private String fileName;

    public DatabaseRecommendationDao(String filename) {
        this.fileName = filename;
        connect();
        createBookTable();
    }

    private Connection connect() {
        // SQLite connection string  
        String url = "jdbc:sqlite:" + fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());  
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void createBookTable() {
        String sql = "CREATE TABLE IF NOT EXISTS books (\n"
                + " id integer PRIMARY KEY,\n"
                + " author TEXT NOT NULL,\n"
                + " title TEXT NOT NULL UNIQUE,\n"
                + " description TEXT,\n"
                + " isbn TEXT,\n"
                + " created TEXT"
                + ");";
        try {
            Connection connection = connect();
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("table created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Insert a new recommendation into the database
     *
     * @param author
     * @param title
     * @param description
     * @param isbn
     */
    @Override
    public void createBookRecommendation(String author, String title, String description, String isbn) {
        String sql = "INSERT INTO books(author, title, description, isbn, created) "
                + "VALUES(?,?,?,?,?)";
        try {
            Connection conn = this.connect();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, author);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, isbn);
            statement.setString(5, java.time.LocalDate.now().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Fetch every recommendation from attached database
     * @return List of recommendations
     */
    @Override
    public List<BookRecommendation> getAllBookRecommendations() {
        ArrayList<BookRecommendation> books = new ArrayList<>();
        try {
            Connection connection = this.connect();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM books");
            while (result.next()) {
                books.add(new BookRecommendation(result.getString("author"),
                        result.getString("title"), result.getString("description"),
                        result.getString("isbn"), result.getString("created")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }
    
    @Override
    public void editBookRecommendation(String title, String fieldToBeEdited, String newValue) {
        String sql = "UPDATE books SET " + fieldToBeEdited + " = ? WHERE title = ?" ;
        // make sql query;
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, newValue);
            pstmt.setString(2, title);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
