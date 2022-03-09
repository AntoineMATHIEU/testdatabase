import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Select {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Antoine Mathieu\\IdeaProjects\\testdatabase\\Bombermantest.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void selectGold(String username) {
        String sql = "SELECT gold FROM bomberman WHERE username= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("gold"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectLevel(String username) {
        String sql = "SELECT level FROM bomberman WHERE username= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("level"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectCurrentSkin(String username) {
        String sql = "SELECT currentSkin FROM bomberman WHERE username= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("currentSkin"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectSkin(String username) {
        String sql = "SELECT level FROM bomberman WHERE username= ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("level"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


