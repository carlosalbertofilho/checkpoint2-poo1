package checkpoint2.poo1.model;

import java.util.regex.Pattern;

public class LegalPerson extends Users implements User {

    private String cnpj;

    public LegalPerson(Integer id,
                       String cnpj,
                       String name,
                       String phone,
                       String street,
                       String numberStreet,
                       String postalCod) {
        setId(id);
        setCnpj(cnpj);
        setName(name);
        setPhone(phone);
        setStreet(street);
        setNumberStreet(numberStreet);
        setPostalCod(postalCod);
    }
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if ( cnpj == null ) throw new NullPointerException("CNPJ cannot be null");
        Pattern isValidCNPJ = Pattern.compile("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)");
        if ( !isValidCNPJ.matcher(cnpj).matches() )
            throw new IllegalArgumentException("CNPJ Invalid format value");
        this.cnpj = cnpj;
    }
}
