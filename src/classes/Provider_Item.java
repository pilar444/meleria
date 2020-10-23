//PROVEEDOR_ARTICULO
package classes;

//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class Provider_Item {
    
    private static final BasicDataSource pac = AdministradorDeConexiones.setearParametros();
    private int personalCode;
    private int Order;
    private int itemCode;
    private boolean Low;
    private int resetPoint;
    
    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(int personalCode) {
        this.personalCode = personalCode;
    }

    public int getOrder() {
        return Order;
    }

    public void setOrder(int Order) {
        this.Order = Order;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public boolean isLow() {
        return Low;
    }

    public void setLow(boolean Low) {
        this.Low = Low;
    }

    public int getResetPoint() {
        return resetPoint;
    }

    public void setResetPoint(int resetPoint) {
        this.resetPoint = resetPoint;
    }
    
    //BUSCAR PROV_ART
    public static ArrayList buscarProvArt() throws Exception {

        Connection conn = null;
        ArrayList provart = new ArrayList();
        try {
           conn = pac.getConnection(); 
           String consPA = ("select * from provart order by 'PROV_ART_CODIGOPER', 'PROV_ART_CODART'");

        PreparedStatement consdPA = conn.prepareStatement(consPA);
        consdPA.executeQuery();
        ResultSet rs = (ResultSet) consdPA.getResultSet();
        Provider_Item  pa = null;

        while(rs.next()){
            
            pa = new Provider_Item ();
            
                   pa.setPersonalCode(rs.getInt("personalCode"));
                   pa.setOrder(rs.getInt("Order"));
                   pa.setLow(rs.getBoolean("Low"));
                   pa.setItemCode(rs.getInt("itemCode"));
                   pa.setResetPoint(rs.getInt("resetPoint"));
                   
                   provart.add(pa);
         }
        
        consdPA.close();

        } catch (SQLException e) {
           
        } finally {
            
           if (null != conn)
              conn.close();
        }      
        
        return(provart);
    }
    
    //BUSCAR POR NOMBRE
    public static String nombreProvArt(int cod) throws Exception{

        String nomPA = "";

        Connection conn = null;
        try {
           conn = pac.getConnection(); 
           String consPA = ("SELECT RUB_NOMBRE from RUBROS where RUB_CODRUB= ? ");

        PreparedStatement consdPA = conn.prepareStatement(consPA);
        consdPA.setInt(1, cod);
        consdPA.execute();

        ResultSet rs = (ResultSet) consdPA.getResultSet();
        if (rs.next()) {
            nomPA = rs.getString("RUB_NOMBRE");
        }
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return nomPA;
     }
    
    //BUSCAR CANTIDAD PROV_ART
    public static boolean cantProvArt(String nomPA) throws Exception{
        boolean cantPA = false;
        Connection conn = null;
        int cantt=0;
        try {
           conn = pac.getConnection();
        String consPA = "SELECT count(*) as 'cantidad' FROM RUBROS WHERE 'PROV_ART_CODIGOPER', 'PROV_ART_CODART'=?";
        PreparedStatement consdPA =conn.prepareStatement(consPA);
        consdPA.setString(1,nomPA);

        consdPA.execute();
        ResultSet rs = (ResultSet) consdPA.getResultSet();
        rs.first();
        cantt = rs.getInt("cantidad");
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      

        if (cantt == 0)
            cantPA = true;

        return(cantPA);
     }

    //ELIMINAR PROV_ART
    public void eliminarProvArt(int numPA) throws Exception {

       Connection conn = null;
        try {
           conn = pac.getConnection(); 
        String elimPA = ("DELETE FROM PROVEEDORES_ARTICULOS WHERE 'PROV_ART_CODIGOPER', 'PROV_ART_CODART'=?");

        System.out.println(">>SQL: " + elimPA );

        PreparedStatement elimdPA = conn.prepareStatement(elimPA);
        elimdPA.setInt(1, this.getPersonalCode());
        elimdPA.setInt(2, this.getItemCode());
        elimdPA.execute();
        
        elimdPA.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != pac)
              pac.close();
        }          
    }
    
    //AGREGAR PROV_ART
     public void insertarProvArt() throws Exception{

        Connection conn = null;
        try {
           conn = pac.getConnection();
                  
        String insPA = "INSERT INTO `provart` (`PROV_ART_ORDEN`, `PROV_ART_BAJA`, `PROV_ART_PUNTO DE REPOSICION`)" + "VALUES ( ?, ?)";

        PreparedStatement insdPA = conn.prepareStatement(insPA);
        
        insdPA.setInt(1, this.getPersonalCode());
        insdPA.setInt(1, this.getOrder());
        insdPA.setBoolean(2, this.isLow());
        insdPA.setInt(1, this.getItemCode());
        insdPA.setInt(1, this.getResetPoint());
        
        insdPA.execute();
      
        insdPA.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
            }    
        }
     
     //MODIFICAR PROV_ART
    public void modificarProvArt() throws Exception    {

        Connection conn = null;
        try {
           conn = pac.getConnection();
           
        String actPA = "UPDATE provart " + "SET `personalCode`=?, `Order`=?, `Low`=?, `itemCode`=?, `resetPoint`=?";

        PreparedStatement actdPA = conn.prepareStatement(actPA);

        actdPA.setInt(1, this.getPersonalCode());
        actdPA.setInt(1, this.getOrder());
        actdPA.setBoolean(2, this.isLow());
        actdPA.setInt(1, this.getItemCode());
        actdPA.setInt(1, this.getResetPoint());

        actdPA.execute();

        actdPA.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        }       
}
    



