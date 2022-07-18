package checkpoint2.poo1.model;

import java.util.UUID;
import java.util.regex.Pattern;

public abstract class Users {
    private Integer id;
    private String name;
    private String phone;
    private String postalCod;
    private String numberStreet;
    private String street;

    public static Integer getRandomID(){
        String str = UUID.randomUUID().toString();
        int uid = str.hashCode();
        String filterStr = ""+uid;
        str = filterStr.replaceAll("-","");
        return Integer.parseInt(str);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if ( id == null ) throw new NullPointerException("id cannot be null");
        if ( id < 0 ) throw new IllegalArgumentException("id value is negative");
        if ( id == 0 ) throw new IllegalArgumentException("id value is zero");
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if ( name == null ) throw new NullPointerException("Name cannot be null");
        Pattern isValidName = Pattern.compile("(^[a-zA-Z\\s]{2,15}$)");
        if ( !isValidName.matcher(name).matches() )
            throw new IllegalArgumentException("Name needs to be between 2 to 15 characters");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if ( phone == null ) throw new NullPointerException("Phone cannot be null");
        Pattern isValidPhone = Pattern.compile("(^\\(d{3}\\)?[ -]?\\d{4,5}-\\d{4}$)");
        if ( !isValidPhone.matcher(phone).matches() )
            throw new IllegalArgumentException("Phone invalid format value");
        this.phone = phone;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(String postalCod) {
        if ( postalCod == null ) throw new NullPointerException("Postal Code cannot be null");
        Pattern isValidPostalCod = Pattern.compile("(^\\d{5}-\\d{3}$)");
        if ( !isValidPostalCod.matcher(postalCod).matches() )
            throw new IllegalArgumentException("PostalCod invalid format value");
        this.postalCod = postalCod;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        if ( numberStreet == null ) throw new NullPointerException("Number Street cannot be null");
        Pattern isValidNumberStreet = Pattern.compile("(^[a-zA-Z0-9]{1,6}$)");
        if ( !isValidNumberStreet.matcher(numberStreet).matches() )
            throw new IllegalArgumentException("Number Street invalid format value");
        this.numberStreet = numberStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if ( street == null ) throw new NullPointerException("Street cannot be null");
        Pattern isValidStreet = Pattern.compile("(^[a-zA-Z\\s]{3,50}$)");
        if ( !isValidStreet.matcher(street).matches() )
            throw new IllegalArgumentException("Street invalid format value");
        this.street = street;
    }
}
