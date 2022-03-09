import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Insert {
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */

    public void insert(String username,String MdP) {
        String sql = "INSERT INTO bomberman(username,MdP,level,currentSkin,skin1,skin2,gold) VALUES(?,?,1,1,1,0,0)";
        String encryptedPassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(MdP.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = s.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, encryptedPassword);
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
