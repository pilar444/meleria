//ARTICULOS
package classes;

import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.apache.commons.dbcp2.BasicDataSource;

public class Item {
    
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int itemCode;
    private String name;
    private int headingCode; //codigo de rubro
    private int stock;
    private float salePrice; //precio de venta
    private float costPrice;
    private String observation;
    private int brandCode; //codigo de marca
    private boolean low;
    
    // Getters and Setters methods

    public boolean getLow() {
        return low;
    }

    public void setLow(boolean low) {
        this.low = low;
    }
    

    public int getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public int getHeadingCode() {
        return headingCode;
    }

    public int getStock() {
        return stock;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public String getObservation() {
        return observation;
    }

    public int getBrandCode() {
        return brandCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadingCode(int headingCode) {
        this.headingCode = headingCode;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public static ArrayList buscarArticulos() throws Exception {

        Connection conn = null;
        ArrayList articulos = new ArrayList();
        try {
           conn = bs.getConnection();
           // realización de la consulta
           String laConsulta = ("select * from articulos order by ART_CODART where ART_BAJA = '0'"); //que este activo

        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        Item I = null;

        while(rs.next()){

            I = new Item();
                I.setItemCode(rs.getInt("ART_CODART"));
                I.setName(rs.getString("ART_NOMBRE"));
                I.setHeadingCode(rs.getInt("ART_CODRUB"));
                I.setStock(rs.getInt("ART_STOCK"));
                I.setSalePrice(rs.getFloat("ART_PRECIOVENT"));
                I.setCostPrice(rs.getFloat("ART_PRECIOCOST"));
                I.setObservation(rs.getString("ART_OBSERV"));
                I.setBrandCode(rs.getInt("ART_CODMARC"));
                
                articulos.add(I);
         }
        stmtlaConsulta.close();

        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        return(articulos);

    }
    
    public static Item buscarArticulosPorNombre (String name) throws Exception {

        Connection conn = null;
        Item I = new Item();
        try {
           conn = bs.getConnection();
           // realización de la consulta
           String laConsulta = ("select * FROM articulos WHERE ART_NOMBRE = ? and ART_BAJA = '0'");
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1, name);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

        while(rs.next()){
                I.setItemCode(rs.getInt("ART_CODART"));
                I.setName(rs.getString("ART_NOMBRE"));
                I.setBrandCode(rs.getInt("ART_CODMARC"));
                I.setStock(rs.getInt("ART_STOCK"));
                I.setSalePrice(rs.getFloat("ART_PRECIOVENT"));
                I.setCostPrice(rs.getFloat("ART_PRECIOCOST"));
                I.setObservation(rs.getString("ART_OBSERV"));
                I.setHeadingCode(rs.getInt("ART_CODRUB"));   
         }
        stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return(I);
    }
    
    public static Item buscarArticulosPorRubro (int headingCode) throws Exception {

        Connection conn = null;
        Item I = new Item();
        try {
           conn = bs.getConnection();
           // realización de la consulta
           String laConsulta = ("select * FROM articulos WHERE ART_CODRUB = ? and ART_BAJA = '0'");
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setInt(1, headingCode);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

        while(rs.next()){
                I.setItemCode(rs.getInt("ART_CODART"));
                I.setName(rs.getString("ART_NOMBRE"));
                I.setHeadingCode(rs.getInt("ART_CODRUB"));
                I.setStock(rs.getInt("ART_STOCK"));
                I.setSalePrice(rs.getFloat("ART_PRECIOVENT"));
                I.setCostPrice(rs.getFloat("ART_PRECIOCOST"));
                I.setObservation(rs.getString("ART_OBSERV"));
                I.setBrandCode(rs.getInt("ART_CODMARC"));   
         }
        stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return(I);
    }
    
    public static Item buscarArticulosPorMarca (int brandCode) throws Exception {

        Connection conn = null;
        Item I = new Item();
        try {
           conn = bs.getConnection();
           // realización de la consulta
           String laConsulta = ("select * FROM articulos WHERE ART_CODMARC = ? and ART_BAJA = '0'");
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setInt(1, brandCode);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();

        while(rs.next()){
                I.setItemCode(rs.getInt("ART_CODART"));
                I.setName(rs.getString("ART_NOMBRE"));
                I.setHeadingCode(rs.getInt("ART_CODRUB"));
                I.setStock(rs.getInt("ART_STOCK"));
                I.setSalePrice(rs.getFloat("ART_PRECIOVENT"));
                I.setCostPrice(rs.getFloat("ART_PRECIOCOST"));
                I.setObservation(rs.getString("ART_OBSERV"));
                I.setBrandCode(rs.getInt("ART_CODMARC"));   
         }
        stmtlaConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return(I);
    }
    
    public void insertarArticulo() throws Exception {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `articulos` (`ART_CODART`, `ART_NOMBRE`, `ART_CODRUB`, `ART_STOCK`, `ART_PRECIOVENT`, `ART_PRECIOCOST`, `ART_OBSERV`, `ART_CODMARC`, `ART_BAJA`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        stmtInsercion.setInt(1, this.getItemCode());
        stmtInsercion.setString(2, this.getName());
        stmtInsercion.setInt(3, this.getHeadingCode());
        stmtInsercion.setInt(4, this.getStock());
        stmtInsercion.setFloat(5,this.getSalePrice());
        stmtInsercion.setFloat(6,this.getCostPrice());
        stmtInsercion.setString(7, this.getObservation());
        stmtInsercion.setInt(8, this.getBrandCode());
        stmtInsercion.setBoolean(9, this.getLow());
        /*if (this.getCiudad()==0){
            stmtInsercion.setNull(3, java.sql.Types.NULL);
        }else{
            stmtInsercion.setInt(3, this.getCiudad());
        }*/      
        stmtInsercion.execute();
      
        stmtInsercion.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }
    }
        
        public void modificarArticulo(int artcod) throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la sentencia de actualizacion
           // RECORDAR WHERE ART_BAJA=0
        String laActualizacion = "UPDATE articulos SET `ART_CODART` = ?, `ART_NOMBRE` = ?, `ART_CODMARC` = ?, `ART_STOCK` = ?, `ART_PRECIOVENT` = ?, `ART_PRECIOCOST` = ?, `ART_OBSERV` = ?, `ART_CODRUB` = ?, `ART_BAJA` = ? WHERE `ART_CODART` = ?";

        PreparedStatement stmtlaActualizacion = conn.prepareStatement(laActualizacion);
        
        stmtlaActualizacion.setInt(1,this.getItemCode());
        stmtlaActualizacion.setString(2,this.getName());
        stmtlaActualizacion.setInt(3,this.getBrandCode());
        stmtlaActualizacion.setInt(4,this.getStock());
        stmtlaActualizacion.setFloat(5,this.getSalePrice());
        stmtlaActualizacion.setFloat(6,this.getCostPrice());
        stmtlaActualizacion.setString(7,this.getObservation());
        stmtlaActualizacion.setInt(8,this.getHeadingCode());
        stmtlaActualizacion.setBoolean(9, false);
        stmtlaActualizacion.setInt(10,artcod);
        
        stmtlaActualizacion.execute();
        
        // Cierra el Statement
        stmtlaActualizacion.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      

    }
     public static void cargarTabla(String valor, JTable table) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        try {
           conn = bs.getConnection();
           //realizaciÃ³n de la consulta
            DefaultTableModel mx = (DefaultTableModel) table.getModel();
            while (mx.getRowCount() > 0) {
                mx.setRowCount(0);
            }
           
            
            String laConsulta = "SELECT ART_CODART, ART_NOMBRE FROM articulos WHERE (ART_NOMBRE LIKE '%" + valor +  "%' OR ART_CODART LIKE '%" + valor + "%') and ART_BAJA = '0' order by ART_NOMBRE";
            PreparedStatement stmtConsulta = conn.prepareStatement(laConsulta);
            stmtConsulta.execute();
            ResultSet consulta = (ResultSet) stmtConsulta.getResultSet();
            
            while (consulta.next()) {
                
                DefaultTableModel temp = (DefaultTableModel) table.getModel();
                Object nuevo[] = {

                    consulta.getString("ART_CODART"),
                    consulta.getString("ART_NOMBRE"),
                       
                };
                temp.addRow(nuevo);
                
            }
            stmtConsulta.close();
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }
            
       
        }
        
    //ELIMINAR
       public static void deleteItem(Integer itemCode) throws Exception {
        
        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la sentencia de eliminacion
           

        String laEliminacion = ("UPDATE articulos SET ART_BAJA = '1' WHERE ART_CODART = ?");

        // Informa la eliminacion a realizar
        System.out.println(">>SQL: " + laEliminacion);

        // Ejecuta la eliminacion
        PreparedStatement stmtEliminacion = conn.prepareStatement(laEliminacion);
        stmtEliminacion.setInt(1, itemCode); //el codigo que me llega
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
        
        
 
}


