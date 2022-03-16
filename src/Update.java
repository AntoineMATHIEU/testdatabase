import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

    /**
     * Augmenter le niveau du joueur d'une unité
     *@param username nom du joeur
     */
    public static void addOneLevel(String username) {
        Select app = new Select();
        int level = app.selectLevel(username);
        level+=1;


        String sql = "UPDATE bomberman SET level = ? "
                + "WHERE username= ?";

        try (Connection conn = connect.connect();
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

    /**
     * Ajouter la quantité difference au solde de gold du joueur
     */
    public static void addGold(String username, int difference) {

        Select app = new Select();
        int currentQuantity = app.selectGold(username);
        int newgold = currentQuantity + difference;

        String sql = "UPDATE bomberman SET gold = ? " + "WHERE username= ?";

        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, newgold);
            pstmt.setString(2, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Débloquer le skin
     */
    public static void unlockSkin(String username, String idSkin){
        String sql = "UPDATE bomberman SET "+ idSkin +" = 1 WHERE username = ?";

        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Changer de skin
     */
    public static void changeSkin(String username, String idSkin){

        String sql = "UPDATE bomberman SET currentSkin = ? WHERE username = ?";

        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, idSkin);
            pstmt.setString(2, username);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
