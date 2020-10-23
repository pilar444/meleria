//TIPO_PERSONAS
package classes;

public class TypePerson {
    
    private int personCode;
    private String description; //indicates if the person is a customer or provider
    private boolean low;
    
    // Getters and Setters methods

    public int getPersonCode() {
        return personCode;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLow() {
        return low;
    }

    public void setPersonCode(int personCode) {
        this.personCode = personCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLow(boolean low) {
        this.low = low;
    }
    
    
}
