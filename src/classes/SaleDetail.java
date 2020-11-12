//DETALLE_VENTA
package classes;
//yanina
//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class SaleDetail {
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int saleDetailCode;
    private int saleCode;
    private int articleCode;
    private int saleQuantity;
    private float price;

    public int getSaleDetailCode() {
        return saleDetailCode;
    }

    public void setSaleDetailCode(int saleDetailCode) {
        this.saleDetailCode = saleDetailCode;
    }

    public int getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(int saleCode) {
        this.saleCode = saleCode;
    }

    public int getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(int articleCode) {
        this.articleCode = articleCode;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    //BUSCAR
    public static ArrayList buscarDetalles() throws Exception {

        Connection conn = null;
        ArrayList detalles = new ArrayList();
        try {
           conn = bs.getConnection(); //ACÁ DECÍA "BS" LO CAMBIÉ POR EL NOMBRE DE NUESTRA BASE
           // realización de la consulta
           String laConsulta = ("select * from detalles order by DET_CODDET");

        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        SaleDetail r = null;

        while(rs.next()){
            /*
            r = new SaleDetail();
            
                   r.setCodigoDetalle(rs.getInt("personCode"));
                   r.setNombrePersona(rs.getString("name"));
                   r.setBajaPersona(rs.getBoolean("low"));
                   
                   personas.add(r);
            */
         }
        stmtlaConsulta.close();

        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return(detalles);
    }
    
    //BUSCAR POR ARTICULO
    public static String articuloDetalle (int cod) throws Exception{

        String art="";

        Connection conn = null;
        try {
           conn = bs.getConnection(); //LO MISMO ACÁ
           // realización de la consulta
           String laConsulta = ("SELECT DET_CODART from DETALLE_VENTA where DET_CODDET= ? ");

        PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
        stmtlaConsulta.setInt(1, cod);
        stmtlaConsulta.execute();

        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        if (rs.next()) {
            art = rs.getString("DET_CODART");
        }
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return art;
     }

    //BUSCAR POR BAJA, CANTIDAD DE DETALLES EXISTENTES
    public static boolean existeDetalle(String det) throws Exception{
        boolean existeDet = false;
        Connection conn = null;
        int cant=0;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la consulta y la ejecuta
        String laConsulta = "SELECT count(*) as 'cantidad' FROM DETALLE_VENTA WHERE DET_CODDET=?";
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1,det);

        stmtlaConsulta.execute();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        rs.first();
        cant = rs.getInt("cantidad");
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      

        if (cant == 0)
            existeDet = true;

        return(existeDet);
     }
    
    //ELIMINAR PERSONA
    public void eliminarDetalle(int num) throws Exception {

       Connection conn = null;
        try {
           conn = bs.getConnection(); //ACÁ TAMBIÉN
           // realización de la consulta
           // Arma la sentencia de eliminacion
        String laEliminacion = ("DELETE FROM PERSONAS WHERE PER_CODIGOPER = ?");

        // Informa la eliminacion a realizar
        System.out.println(">>SQL: " + laEliminacion);

        // Ejecuta la eliminacion
        PreparedStatement stmtEliminacion = conn.prepareStatement(laEliminacion);
        stmtEliminacion.setInt(1, this.getSaleDetailCode());
        stmtEliminacion.execute();

        // Cierra el Statement
        stmtEliminacion.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != bs)
              bs.close();
        }          
    }
    
    //AGREGAR PERSONA
     public void insertarDetalle() throws Exception{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `detalles` (`DET_CODVEN`,`DET_CODART`,  `DET_CANTIDAD`,`DET_PRECIO`" +
                              "VALUES ( ?, ?, ?, ?)";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        //stmtInsercion.setInt(1, this.getSaleDetailCode());
        stmtInsercion.setInt(1, this.getSaleCode());
        stmtInsercion.setInt(2, this.getArticleCode());
        stmtInsercion.setInt(3, this.getSaleQuantity());
        stmtInsercion.setFloat(4, this.getPrice());
        
               
        stmtInsercion.execute();
      
        stmtInsercion.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
            }    
        }
        
    
     
    //MODIFICAR MARCA
    public void modificarDetalle() throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la sentencia de actualizacion
        String laActualizacion = "UPDATE saleDetail " +
                                 "SET `saleCode`=?, `articleCode`=?,`saleQuantity`=?, `price`=?";

        PreparedStatement stmtlaActualizacion = conn.prepareStatement(laActualizacion);

        
        
        stmtlaActualizacion.setInt(1, this.getSaleCode());
        stmtlaActualizacion.setInt(2, this.getArticleCode());
        stmtlaActualizacion.setInt(3, this.getSaleQuantity());
        stmtlaActualizacion.setFloat(4, this.getPrice());
        

        stmtlaActualizacion.execute();

       //Cierra el Statement
        stmtlaActualizacion.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
       
        }       
             
}

