//MARCAS
package classes;

//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class Brand {
     private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int brandCode;
    private String name;
    private boolean low; //used to cancel a brand

    // Getters and Setters methods
    
    public int getBrandCode() {
        return brandCode;
    }

    public String getName() {
        return name;
    }

    public boolean isLow() {
        return low;
    }

    public void setBrandCode(int brandCode) {
        this.brandCode = brandCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLow(boolean low) {
        this.low = low;
    }
    
    //BUSCAR
    public static ArrayList buscarMarcas() throws Exception {

        Connection conn = null;
        ArrayList marcas = new ArrayList();
        try {
           conn = bs.getConnection(); //ACÁ DECÍA "BS" LO CAMBIÉ POR EL NOMBRE DE NUESTRA BASE
           // realización de la consulta
           String laConsulta = ("select * from marcas order by MAR_CODMARC and MAR_BAJA=0");

        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        Brand r = null;

        while(rs.next()){
            /*
            r = new Brand();
            
                   r.setCodigoMarca(rs.getInt("brandCode"));
                   r.setNombreMarca(rs.getString("name"));
                   r.setBajaMarca(rs.getBoolean("low"));
                   
                   marcas.add(r);
            */
         }
        stmtlaConsulta.close();

        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return(marcas);
    }
    
    //BUSCAR NOMBRE POR CODIGO
    public static String nombreMarca(int cod) throws Exception{

        String nom="";

        Connection conn = null;
        try {
           conn = bs.getConnection(); //LO MISMO ACÁ
           // realización de la consulta
           String laConsulta = ("SELECT MAR_NOMBRE from marcas where MAR_CODMARC= ? and MAR_BAJA=0");

        PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
        stmtlaConsulta.setInt(1, cod);
        stmtlaConsulta.execute();

        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        if (rs.next()) {
            nom = rs.getString("MAR_NOMBRE");
        }
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return nom;
     }

    //BUSCAR POR BAJA, CANTIDAD DE MARCAS EXISTENTES
    public static boolean existeMarca(String nom) throws Exception{
        boolean existeMar = false;
        Connection conn = null;
        int cant=0;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la consulta y la ejecuta
        String laConsulta = "SELECT count(*) as 'cantidad' FROM marcas WHERE MAR_NOMBRE=? and MAR_BAJA=0";
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1,nom);

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
            existeMar = true;

        return(existeMar);
     }
    
    //ELIMINAR MARCA
    public void eliminarMarca(int num) throws Exception {

       Connection conn = null;
        try {
           conn = bs.getConnection(); //ACÁ TAMBIÉN
           // realización de la consulta
           // Arma la sentencia de eliminacion
        String laEliminacion = ("DELETE FROM marcas WHERE MAR_CODMARC = ? and MAR_BAJA=0");

        // Informa la eliminacion a realizar
        System.out.println(">>SQL: " + laEliminacion);

        // Ejecuta la eliminacion
        PreparedStatement stmtEliminacion = conn.prepareStatement(laEliminacion);
        stmtEliminacion.setInt(1, this.getBrandCode());
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
    
    //AGREGAR MARCA
     public void insertarMarca() throws Exception{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `marcas` (`MAR_NOMBRE`, `MAR_BAJA`)" +
                              "VALUES ( ?, ?)";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        //stmtInsercion.setInt(1, this.getBrandCode());
        stmtInsercion.setString(1, this.getName());
        stmtInsercion.setBoolean(2, this.isLow());
     
               
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
    public void modificarMarca() throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la sentencia de actualizacion
        String laActualizacion = "UPDATE brand " +
                                 "SET `name`=?, `brandCode`=?, `Low`=?";

        PreparedStatement stmtlaActualizacion = conn.prepareStatement(laActualizacion);

        
        
        
        stmtlaActualizacion.setString(1, this.getName());
        stmtlaActualizacion.setInt(2, this.getBrandCode());
        stmtlaActualizacion.setBoolean(3, this.isLow());

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
