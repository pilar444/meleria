//PERSONAS
package classes;

//IMPORT
import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class Person {
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int personCode;
    private int order;
    private String name;
    private String surname;
    private int phone;
    private boolean low; //used to cancel a person
    private int streetNumber;
    private float balance;
    private int cityCode;
    private int streetCode;
 
    // Getters and Setters methods

    public int getPersonCode() {
        return personCode;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public boolean isLow() {
        return low;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public float getBalance() {
        return balance;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getStreetCode() {
        return streetCode;
    }

    public void setPersonCode(int personCode) {
        this.personCode = personCode;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setLow(boolean low) {
        this.low = low;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setStreetCode(int streetCode) {
        this.streetCode = streetCode;
    }
    
    //BUSCAR
    public static ArrayList buscarPersonas() throws Exception {

        Connection conn = null;
        ArrayList personas = new ArrayList();
        try {
           conn = bs.getConnection(); //ACÁ DECÍA "BS" LO CAMBIÉ POR EL NOMBRE DE NUESTRA BASE
           // realización de la consulta
           String laConsulta = ("select * from personas order by PER_CODIGOPER");

        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.executeQuery();
        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        Person r = null;

        while(rs.next()){
            /*
            r = new Brand();
            
                   r.setCodigoPersona(rs.getInt("personCode"));
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
        
        return(personas);
    }
    
    //BUSCAR POR APELLIDO
    public static String apellidoPersona (int cod) throws Exception{

        String ape="";

        Connection conn = null;
        try {
           conn = bs.getConnection(); //LO MISMO ACÁ
           // realización de la consulta
           String laConsulta = ("SELECT PER_APELLIDO from PERSONAS where PER_CODIGOPER= ? ");

        PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
        stmtlaConsulta.setInt(1, cod);
        stmtlaConsulta.execute();

        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        if (rs.next()) {
            ape = rs.getString("PER_APELLIDO");
        }
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return ape;
     }

    //BUSCAR POR BAJA, CANTIDAD DE PERSONAS EXISTENTES
    public static boolean existePersona(String ape) throws Exception{
        boolean existePer = false;
        Connection conn = null;
        int cant=0;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la consulta y la ejecuta
        String laConsulta = "SELECT count(*) as 'cantidad' FROM PERSONAS WHERE PER_APELLIDO=?";
        PreparedStatement stmtlaConsulta =conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1,ape);

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
            existePer = true;

        return(existePer);
     }
    
    //ELIMINAR PERSONA
    public void eliminarPersona(int num) throws Exception {

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
        stmtEliminacion.setInt(1, this.getPersonCode());
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
     public void insertarPersona() throws Exception{

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `personas` (`PER_ORDEN`,`PER_NOMBRE`,  `PER_APELLIDO`,`PER_CELULAR`"
                + ",`PER_BAJA`, `PER_NUMCALLE`, `PER_SALDO`, `PER_CODCIU`, `PER_CODCAL`)" +
                              "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        //stmtInsercion.setInt(1, this.getBrandCode());
        stmtInsercion.setInt(1, this.getOrder());
        stmtInsercion.setString(2, this.getName());
        stmtInsercion.setString(3, this.getSurname());
        stmtInsercion.setInt(4, this.getPhone());
        stmtInsercion.setBoolean(5, this.isLow());
        stmtInsercion.setInt(6, this.getStreetNumber());
        stmtInsercion.setFloat(7, this.getBalance());
        stmtInsercion.setInt(8, this.getCityCode());
        stmtInsercion.setInt(9, this.getStreetCode());
               
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
    public void modificarPersona() throws Exception    {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
           // Arma la sentencia de actualizacion
        String laActualizacion = "UPDATE person " +
                                 "SET `name`=?, `personCode`=?,`order`=?, `name`=?, `surname`=?,`phone`=?, `Low`=?,"
                + "`streetNumber`=?, `balance`=?, `cityCode`=?, `streetCode`=?";

        PreparedStatement stmtlaActualizacion = conn.prepareStatement(laActualizacion);

        
        
        stmtlaActualizacion.setInt(1, this.getPersonCode());
        stmtlaActualizacion.setInt(2, this.getOrder());
        stmtlaActualizacion.setString(3, this.getName());
        stmtlaActualizacion.setString(4, this.getSurname());
        stmtlaActualizacion.setInt(5, this.getPhone());
        stmtlaActualizacion.setBoolean(6, this.isLow());
        stmtlaActualizacion.setInt(7, this.getStreetNumber());
        stmtlaActualizacion.setFloat(8, this.getBalance());
        stmtlaActualizacion.setInt(9, this.getCityCode());
        stmtlaActualizacion.setInt(10, this.getStreetCode());

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
