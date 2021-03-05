
package controller;
    import daos.UserDao;
    import java.util.ArrayList;
    import java.sql.Connection;
    import models.User;
    import tools.Koneksi;
    import java.util.List;

public class UserController {
    public String inputUser(String username,String password,String email,String noHp){
    Koneksi daftarAkun = new Koneksi();
    Connection conn = daftarAkun.getConnection();
        UserDao userDao = new UserDao(conn);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setNoTelp(noHp);
        if(userDao.inputuser(user)) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public List<User> letUserLogin(){
        List<User> usr = new ArrayList();
        Koneksi daftarAkun = new Koneksi();
        Connection conn = daftarAkun.getConnection();
        UserDao userDao = new UserDao(conn);
        usr = userDao.getUser();
        if(usr != null) {
            System.out.println("Success");
            return usr;
        } else {
            System.out.println("Fail");
            return null;
        }
        
    }
}
