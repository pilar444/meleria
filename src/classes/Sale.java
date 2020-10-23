//VENTAS
package classes;

import java.util.Date;

public class Sale {
    
    private int saleCode;
    private  Date fecha;
    private float subtotal;
    private float iva;
    private float total;
    private int typeCode;
    private int personCode;
    private int order;
    
    // Getters and Setters methods
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getSaleCode() {
        return saleCode;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public float getIva() {
        return iva;
    }

    public float getTotal() {
        return total;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public int getPersonCode() {
        return personCode;
    }

    public int getOrder() {
        return order;
    }

    public void setSaleCode(int saleCode) {
        this.saleCode = saleCode;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public void setPersonCode(int personCode) {
        this.personCode = personCode;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    
    
    
}
