import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Select {


    public int selectGold(String username) {
        int gold =0;
        String sql = "SELECT gold FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set

                gold=rs.getInt("gold");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(gold);
        return gold;
    }

    public int selectLevel(String username) {
        int level=0;
        String sql = "SELECT level FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            level=rs.getInt("level");

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(level);
        return level;
    }
    public void selectCurrentSkin(String username) {
        String sql = "SELECT currentSkin FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set

                System.out.println(rs.getInt("currentSkin"));


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectSkin(String username) {
        String sql = "SELECT level FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt(""));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


