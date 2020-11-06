//CIUDADES
package classes;

import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class City {
    
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int cityCode;
    private String name;
    private boolean low; //Used to cancel a city
    
    // Getters and Setters methods

    public int getCityCode() {
        return cityCode;
    }

    public String getName() {
        return name;
    }

    public boolean isLow() {
        return low;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLow(boolean low) {
        this.low = low;
    }
    
    
    public void insertarCiudad() throws Exception {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `CIUDADES` (`CIU_CODCIU` , `CIU_NOMBRE`, `CIU_BAJA`)" +
                              "VALUES (?,?, ?)";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        stmtInsercion.setInt(1, this.getCityCode());
        stmtInsercion.setString(2, this.getName());
        stmtInsercion.setBoolean(3,this.isLow());
        //stmtInsercion.setInt(3, this.getHeadingCode());
        
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
    
    public static City getByName (String nameCity) throws Exception{

        City c = new City();
        
        Connection conn = null;
        try {
           conn = bs.getConnection(); //LO MISMO ACÁ
           // realización de la consulta
           String laConsulta = ("SELECT * from CIUDADES where CIU_NOMBRE= ? ");

        PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1, nameCity);
        stmtlaConsulta.execute();

        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        if (rs.next()) {
            c.setCityCode(rs.getInt("CIU_CODCIU"));
        }
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return nom;
     }
    
    
}
