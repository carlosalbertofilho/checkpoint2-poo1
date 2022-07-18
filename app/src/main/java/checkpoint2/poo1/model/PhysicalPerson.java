package checkpoint2.poo1.model;

import java.util.regex.Pattern;

public class PhysicalPerson extends Users implements User {
    private String cpf;

    /**
     * Construtor da Classe PhysicalPerson
     * @param id                Id do usuário
     * @param cpf               CPF do usuário
     * @param name              Nome do usuário
     * @param phone             Telefone do usuário
     * @param street            Endereço do usuário
     * @param numberStreet      Número da Residência do usuário
     * @param postalCod         CEP do usuário
     */
    public PhysicalPerson(Integer id,
                          String cpf,
                          String name,
                          String phone,
                          String street,
                          String numberStreet,
                          String postalCod) {
        setId(id);
        setCpf(cpf);
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
    public String toString() {
        return "Cliente: %s, CPF: %s".formatted(
                getName(),
                getCpf()
        );
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Pattern isValidCPF = Pattern.compile("(^\\d{3}.\\d{3}.\\d{3}-\\d{2}$)");
        if ( !isValidCPF.matcher(cpf).matches() )
            throw new IllegalArgumentException("CNPJ Invalid format value");
        this.cpf = cpf;
    }

}
