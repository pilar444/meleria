//RUBRO
package classes;

//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;


public class Heading {
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int headingCode;
    private String Name;
    private boolean Low;

    public int getHeadingCode() {
        return headingCode;
    }

    public void setHeadingCode(int headingCode) {
        this.headingCode = headingCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isLow() {
        return Low;
    }

    public void setLow(boolean Low) {
        this.Low = Low;
    }
    public static Heading searchHeadingByName(String nameHeading) throws Exception {

        Connection conn = null;
        Heading r = null;
        
        try {
           conn = bs.getConnection();
           // realizaciÃ³n de la consulta
           String consult = ("select * from rubros where RUB_NOMBRE = ?");

        PreparedStatement stmtconsult =conn.prepareStatement(consult);
        stmtconsult.setString(1, nameHeading);
        stmtconsult.executeQuery();
        ResultSet rs = (ResultSet) stmtconsult.getResultSet();
        

        while(rs.next()){

            r = new Heading();
            r.setHeadingCode(rs.getInt("RUB_CODRUB"));
            r.setName(rs.getString("RUB_NOMBRE"));

         }
        stmtconsult.close();

        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }

        return(r);

    }
    //BUSCAR RUBRO
    public static ArrayList buscarRubros() throws Exception {

        Connection conn = null;
        ArrayList rubros = new ArrayList();
        try {
           conn = bs.getConnection(); 
           String consRub = ("select * from rubros order by RUB_CODRUB and RUB_BAJA=0 ");

        PreparedStatement consdRub = conn.prepareStatement(consRub);
        consdRub.executeQuery();
        ResultSet rs = (ResultSet) consdRub.getResultSet();
        Heading ru = null;

        while(rs.next()){
            
            ru = new Heading();
            
                   ru.setHeadingCode(rs.getInt("headingCode"));
                   ru.setName(rs.getString("Name"));
                   ru.setLow(rs.getBoolean("Low"));
                   
                   rubros.add(ru);
         }
        
        consdRub.close();

        } catch (SQLException e) {
           
        } finally {
            
           if (null != conn)
              conn.close();
        }      
        
        return(rubros);
    }
    
    //BUSCAR NOMBRE POR CODIGO
    public static String nombreRubro(int cod) throws Exception{

        String nomrub = "";

        Connection conn = null;
        try {
           conn = bs.getConnection(); 
           String consRub = ("SELECT RUB_NOMBRE from rubros where RUB_CODRUB = ? and RUB_BAJA=0 ");

        PreparedStatement consdRub = conn.prepareStatement(consRub);
        consdRub.setInt(1, cod);
        consdRub.execute();
        
        
        ResultSet rs = (ResultSet) consdRub.getResultSet();
        if (rs.next()) {
            nomrub = rs.getString("RUB_NOMBRE");
            
        }
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return nomrub;
     }
    
    //BUSCAR CANTIDAD RUBROS
    public static boolean cantRubro(String nomrub) throws Exception{
        boolean cantRubro = false;
        Connection conn = null;
        int cant=0;
        try {
           conn = bs.getConnection();
        String consRub = "SELECT count(*) as 'cantidad' FROM RUBROS WHERE RUB_NOMBRE=? and RUB_BAJA=0 ";
        PreparedStatement consdRub =conn.prepareStatement(consRub);
        consdRub.setString(1,nomrub);

        consdRub.execute();
        ResultSet rs = (ResultSet) consdRub.getResultSet();
        rs.first();
        cant = rs.getInt("cantidad");
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      

        if (cant == 0)
            cantRubro = true;

        return(cantRubro);
     }

    //ELIMINAR RUBRO
    public void eliminarRubro() throws Exception {

       Connection conn = null;
        try {
           conn = bs.getConnection(); 
        String elimRub = ("DELETE FROM RUBROS WHERE RUB_CODRUB = ? and RUB_BAJA=0 ");

        System.out.println(">>SQL: " + elimRub );

        PreparedStatement elimdRub = conn.prepareStatement(elimRub);
        elimdRub.setInt(1, this.getHeadingCode());
        elimdRub.execute();
        
        elimdRub.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }          
    }

     //AGREGAR RUBRO
     public void insertarRubro() throws Exception{

        Connection conn = null;
        try {
           conn = bs.getConnection();
                  
        String insRub = "INSERT INTO `rubros` (`RUB_NOMBRE`, `RUB_BAJA`)" + "VALUES ( ?, ?)";

        PreparedStatement insdRub = conn.prepareStatement(insRub);

        insdRub.setInt(1, this.getHeadingCode());
        insdRub.setString(2, this.getName());
        insdRub.setBoolean(3, this.isLow());
     
        insdRub.execute();
      
        insdRub.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
            }    
        }
     
    //MODIFICAR RUBRO
    public void modificarRubro() throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           
        String actRub = "UPDATE heading " + "SET `Name`=?, `headingCode`=?, `Low`=?";

        PreparedStatement actdRub = conn.prepareStatement(actRub);

        actdRub.setString(1, this.getName());
        actdRub.setInt(2, this.getHeadingCode());
        actdRub.setBoolean(3, this.isLow());

        actdRub.execute();

       actdRub.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        }       
}
    
