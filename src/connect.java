import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class connect {
    public static Connection connect() {
        Connection conn = null;
        try {
            // SQLite connection string
            Properties appProps = new Properties();
            appProps.load(new FileInputStream("db.properties"));
            String url = appProps.getProperty("url");
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return conn;
    }
    public static int selectLevel(String username) {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        connect();

        //Insert app = new Insert();
        // insert three new rows
        //app.insert("tete","bonjour" );
        //Select select = new Select();
        //selectLevel("ZER");
        //select.selectGold("ZER");

        Update app = new Update();
        //app.unlockSkin("tetelamenace","skin2");
        app.changeSkin("tetelamenace","skin2");
    }
}
