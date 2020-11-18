//CALLES
package classes;

import SQLconection.AdministradorDeConexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Street {
    
    private static final BasicDataSource bs = AdministradorDeConexiones.setearParametros();
    private int streetCode;
    private String name;
    private boolean low; //used to cancel a street
    
    // Getters and Setters methods

    public int getStreetCode() {
        return streetCode;
    }

    public String getName() {
        return name;
    }

    public boolean isLow() {
        return low;
    }

    public void setStreetCode(int streetCode) {
        this.streetCode = streetCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLow(boolean low) {
        this.low = low;
    }
    
    public void insertarCalle() throws Exception {

        Connection conn = null;
        try {
           conn = bs.getConnection();
           // realización de la consulta
                  
        String laInsercion = "INSERT INTO `CALLES` (`CAL_CODCAL` , `CAL_NOMBRE`, `CAL_BAJA`)" +
                              "VALUES (?,?, ?)";

        PreparedStatement stmtInsercion = conn.prepareStatement(laInsercion);

        stmtInsercion.setInt(1, this.getStreetCode());
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
        
    public static Street getByName (String nameStreet) throws Exception{

        Street s = new Street();
        
        Connection conn = null;
        try {
           conn = bs.getConnection(); //LO MISMO ACÁ
           // realización de la consulta
           String laConsulta = ("SELECT * from CALLES where CAL_NOMBRE= ? ");

        PreparedStatement stmtlaConsulta = conn.prepareStatement(laConsulta);
        stmtlaConsulta.setString(1, nameStreet);
        stmtlaConsulta.execute();

        ResultSet rs = (ResultSet) stmtlaConsulta.getResultSet();
        if (rs.next()) {
            s.setStreetCode(rs.getInt("CAL_CODCAL"));
            s.setLow(rs.getBoolean("CAL_BAJA"));
            s.setName(rs.getString("CAL_NOMBRE"));
        }
        } catch (SQLException e) {
           // tratamiento de error
        } finally {
           if (null != conn)
              conn.close();
        }      
        
        return s;
     }    
}
