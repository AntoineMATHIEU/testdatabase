import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        connect();

        Insert app = new Insert();
        // insert three new rows
        //app.insert("Anto","MdPTest" );
        Select select = new Select();
        select.selectLevel("ZER");
        select.selectGold("ZER");
    }
}
