/**
 * @author: Ethan Nguyen
 * {@summary: This class is the parent class for all Provider records.
 * It contains the basic information for all records.}
 * @param: name, number, address, city, state, zipCode
 * @return: name, number, address, city, state, zipCode
 */
class ProviderRecord extends Record {
    public ProviderRecord(String name, String number, String address, String city, String state, String zipCode){
        super(name, number, address, city, state, zipCode);
    }
}