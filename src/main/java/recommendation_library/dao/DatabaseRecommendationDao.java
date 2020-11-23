/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import recommendation_library.domain.Recommendation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anadis
 */
public class DatabaseRecommendationDao implements RecommendationDao {

    private String fileName;


    public DatabaseRecommendationDao(String filename) {
        this.fileName = filename;
        connect();
        createTable();
    }

    private Connection connect() {
        // SQLite connection string  
        String url = "jdbc:sqlite:" + fileName;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            if (connection != null) {
                DatabaseMetaData meta = connection.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());  
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS recommendations (\n"
                + " id integer PRIMARY KEY,\n"
                + " author text NOT NULL,\n"
                + " title text NOT NULL,\n"
                + " description text"
                + ");";
        try {

            Connection conn = connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createRecommendation(String author, String title, String descr) {
        String sql = "INSERT INTO recommendations(author, title, description) "
                + "VALUES(?,?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, author);
            pstmt.setString(2, title);
            pstmt.setString(3, descr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Recommendation> getAll() {
        ArrayList<Recommendation> recommendations = new ArrayList<>();
        try {
            Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM recommendations");
            while (rs.next()) {  
                recommendations.add(new Recommendation(rs.getString("author"), 
                        rs.getString("title"), rs.getString("description")));  
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return recommendations;
    }

}
