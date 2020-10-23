
package SQLconection;

import org.apache.commons.dbcp2.BasicDataSource;

public abstract class AdministradorDeConexiones {

    //public static String db = "corralon";
    //192.168.1.50 negocio
    public static String url = "jdbc:mysql://127.0.0.1/meleria";
    public static String user = "Admin";
    public static String pass = "meleria";
    
    public static BasicDataSource setearParametros(){
        BasicDataSource bs = new BasicDataSource();
        bs.setDriverClassName("com.mysql.jdbc.Driver");
        bs.setUsername(user);
        bs.setPassword(pass);
        bs.setUrl(url);
        return bs;
    }
    
}
