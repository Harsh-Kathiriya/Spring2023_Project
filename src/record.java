abstract class Record {
    private String name;
    private String number;
    private String address;
    private String city;
    private String state;
    private String zipCode; 


    /**
     * @return the name
     */
    public String getName(){
        return this.name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the number
     */
    public String getNumber(){
        return this.number;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        if (this.checkNumber(number)){
            this.number = number;
        }
        else {
            System.out.println("Invalid number");
        }
    }
    /**
     * @return the address
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the city
     */
    public String getCity(){
        return this.city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return the state
     */
    public String getState(){
        return this.state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * @return the zipCode
     */
    public String getZipCode(){
        return this.zipCode;
    }
    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Record(String name, String number, String address, String city, String state, String zipCode ) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    private boolean checkNumber(String number) {
        if (number.length() != 9) {
            return false;
        }
        return true;
    }
}