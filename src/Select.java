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
    public String selectCurrentSkin(String username) {
        String currentSkin="";
        String sql = "SELECT currentSkin FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();
            currentSkin=rs.getString("currentSkin");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(currentSkin);
        return currentSkin;
    }
    public int selectSkin(String username,String idSkin) {
        int skinState =0;
        String sql = "SELECT "+idSkin+" FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            skinState=rs.getInt(idSkin);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(skinState);
        return  skinState;
    }
}


