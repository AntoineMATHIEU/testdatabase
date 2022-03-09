import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\tng13\\Desktop\\testdatabase\\Bombermantest.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Update le niveau d'un joueur
     *
     *@param username nom du joeur
     *@param level niveau du joueur
     */
    public void updateLevel(String username, int level) {
        String sql = "UPDATE bomberman SET level = ? "
                + "WHERE username= ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, level);
            pstmt.setString(2, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGold(String username, int gold) {
        String sql = "UPDATE bomberman SET gold = ? "
                + "WHERE username= ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, gold);
            pstmt.setString(2, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Update app = new Update();
        app.updateGold("theo",1000);
    }
}
