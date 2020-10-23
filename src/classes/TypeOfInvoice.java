//TIPO DE FACTURA
package classes;

//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class TypeOfInvoice {

    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    public int codeType;
    public String Name;
    public String Abbreviation;

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String Abbreviation) {
        this.Abbreviation = Abbreviation;
    }
    
    //BUSCAR TIPO DE FACTURA
    public static ArrayList buscarFacturas() throws Exception {

        Connection conn = null;
        ArrayList facturas = new ArrayList();
        try {
           conn = bs.getConnection(); 
           String consTdf = ("select * from facturas order by TIP_TIPCOD");

        PreparedStatement consdTdf = conn.prepareStatement(consTdf);
        consdTdf.executeQuery();
        ResultSet rs = (ResultSet) consdTdf.getResultSet();
        TypeOfInvoice tdf = null;

        while(rs.next()){
            
            tdf = new TypeOfInvoice();
            
                   tdf.setCodeType(rs.getInt("codeType"));
                   tdf.setName(rs.getString("Name"));
                   tdf.setAbbreviation(rs.getString("Abbreviation"));
                   
                   facturas.add(tdf);
         }
        
        consdTdf.close();

        } catch (SQLException e) {
           
        } finally {
            
           if (null != conn)
              conn.close();
        }      
        
        return(facturas);
    }
    
    //BUSCAR POR TIPO DE FACTURA
    public static String nombreFactura(int cod) throws Exception{

        String nomtdf = "";

        Connection conn = null;
        try {
           conn = bs.getConnection(); 
           String consTdf = ("SELECT TIP_NOMBRE from TIPO DE FACTURA where TIP_TIPCOD= ? ");

        PreparedStatement consdTdf = conn.prepareStatement(consTdf);
        consdTdf.setInt(1, cod);
        consdTdf.execute();

        ResultSet rs = (ResultSet) consdTdf.getResultSet();
        if (rs.next()) {
            nomtdf = rs.getString("TIP_NOMBRE");
        }
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return nomtdf;
     }
    
    //BUSCAR CANTIDAD DE TIPO DE FACTURAS
    public static boolean cantFacturas(String nomtdf) throws Exception{
        boolean cantFacturas = false;
        Connection conn = null;
        int cantd=0;
        try {
           conn = bs.getConnection();
        String consTdf = "SELECT count(*) as 'cantidad' FROM TIPO_DE_FACTURA WHERE TIP_NOMBRE=?";
        PreparedStatement consdTdf = conn.prepareStatement(consTdf);
        consdTdf.setString(1,nomtdf);

        consdTdf.execute();
        ResultSet rs = (ResultSet) consdTdf.getResultSet();
        rs.first();
        cantd = rs.getInt("cantidad");
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      

        if (cantd == 0)
            cantFacturas = true;

        return(cantFacturas);
     }
    
    //ELIMINAR TIPO DE FACTURAS
    public void eliminarFacturas() throws Exception {

       Connection conn = null;
        try {
           conn = bs.getConnection(); 
        String elimTdf = ("DELETE FROM TIPO_DE_FACTURA WHERE TIP_TIPCOD = ?");

        System.out.println(">>SQL: " + elimTdf );

        PreparedStatement elimdTdf = conn.prepareStatement(elimTdf);
        elimdTdf.setInt(1, this.getCodeType());
        elimdTdf.execute();
        
        elimdTdf.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }          
    }
    
    //AGREGAR TIPO DE FACTURAS
     public void insertarFacturas() throws Exception{

        Connection conn = null;
        try {
           conn = bs.getConnection();
                  
        String insTdf = "INSERT INTO `facturas` (`TIP_NOMBRE`, `TIP_ABREVIACION`)" + "VALUES ( ?, ?)";

        PreparedStatement insdTdf = conn.prepareStatement(insTdf);

        insdTdf.setInt(1, this.getCodeType());
        insdTdf.setString(2, this.getName());
        insdTdf.setString(3, this.getAbbreviation());
     
        insdTdf.execute();
      
        insdTdf.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
            }    
        }
    
    //MODIFICAR TIPO DE FACTURAS
    public void modificarFacturas() throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           
        String actTdf = "UPDATE typeofinvoice " + "SET `Name`=?, `codeType`=?, `Abbreviation`=?";

        PreparedStatement actdTdf = conn.prepareStatement(actTdf);

        actdTdf.setString(1, this.getName());
        actdTdf.setInt(2, this.getCodeType());
        actdTdf.setString(3, this.getAbbreviation());

        actdTdf.execute();

        actdTdf.close();
        } catch (SQLException e) {
           
        } finally {
           if (null != conn)
              conn.close();
        }      
        }       
     
    }
    