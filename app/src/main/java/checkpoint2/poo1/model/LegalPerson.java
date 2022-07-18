package checkpoint2.poo1.model;

import java.util.regex.Pattern;

public class LegalPerson implements User{

    private Integer id;
    private String cnpj;
    private String name;
    private String phone;
    private String postalCod;
    private String numberStreet;
    private String street;

    @Override
    public String getAddress() {
        return "%s , Nº: %s , CEP: %s".formatted(
                getStreet(),
                getNumberStreet(),
                getPostalCod()
        );
    }

    @Override
    public String toString(){
        return "Empresa: %s, CNPJ: %s".formatted(
                getName(),
                getCnpj()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if ( id < 0 ) throw new IllegalArgumentException("id value is negative");
        if ( id == 0 ) throw new IllegalArgumentException("id value is zero");
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        Pattern isValidCNPJ = Pattern.compile("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
        if ( !isValidCNPJ.matcher(cnpj).matches() )
            throw new IllegalArgumentException("CNPJ Invalid format value");
        this.cnpj = cnpj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Pattern isValidName = Pattern.compile("(^[a-zA-Z]{2,15}$)");
        if ( !isValidName.matcher(name).matches() )
            throw new IllegalArgumentException("Name needs to be between 2 to 15 characters");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        Pattern isValidPhone = Pattern.compile("(^\\(d{3}\\)?[ -]?\\d{4,5}-\\d{4}$)");
        if ( !isValidPhone.matcher(phone).matches() )
            throw new IllegalArgumentException("Phone invalid format value");
        this.phone = phone;
    }

    public String getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(String postalCod) {
        Pattern isValidPostalCod = Pattern.compile("(^\\d{5}-\\d{3}$)");
        if ( !isValidPostalCod.matcher(postalCod).matches() )
            throw new IllegalArgumentException("PostalCod invalid format value");
        this.postalCod = postalCod;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        Pattern isValidNumberStreet = Pattern.compile("(^[a-zA-Z0-9]{1,6}$)");
        if ( !isValidNumberStreet.matcher(numberStreet).matches() )
            throw new IllegalArgumentException("Number Street invalid format value");
        this.numberStreet = numberStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        Pattern isValidStreet = Pattern.compile("(^[a-zA-Z]{3,50}$)");
        if ( !isValidStreet.matcher(street).matches() )
            throw new IllegalArgumentException("Street invalid format value");
        this.street = street;
    }
}
