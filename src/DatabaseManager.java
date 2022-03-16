public class DatabaseManager {
    public static void connect(){
        connect.connect();
    }
    public static int selectGold(String username){
        return Select.selectGold(username);
    }
    public static int selectLevel(String username){return Select.selectLevel(username);}
    public static String selectCurrentSkin(String username) {return Select.selectCurrentSkin(username);}
    public static int selectSkin(String username,String idSkin){return Select.selectSkin(username,idSkin);}
    public static boolean player(String username,String password){return PlayerConnection.player(username,password);}
    public static void insert(String username,String password) {Insert.insert(username,password);}
    public static void addOneLevel(String username) {Update.addOneLevel(username);}
    public static void addGold(String username, int difference) {Update.addGold(username,difference);}
    public static void unlockSkin(String username, String idSkin){Update.unlockSkin(username, idSkin);}
    public static void changeSkin(String username, String idSkin){Update.changeSkin(username, idSkin);}


    public static void main(String[] args) {

        connect();
        selectGold("ZER");



    }
}
