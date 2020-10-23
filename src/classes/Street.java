//CALLES
package classes;

public class Street {
    
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
    
    
            
}
