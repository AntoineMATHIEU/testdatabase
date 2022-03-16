import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerConnection {
    public static boolean player(String username, String password){
        String testPassword = null;
        String encryptedPassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
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
        String sql ="SELECT MdP FROM bomberman WHERE username= ?";
        try (Connection conn = connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, username);
            //
            ResultSet rs = pstmt.executeQuery();

            testPassword = rs.getString("MdP").toString();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(encryptedPassword.equals(testPassword));
        return encryptedPassword.equals(testPassword);
    }
}