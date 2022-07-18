package checkpoint2.poo1.model;

public class UserCreator {
        public User createUser(Integer id,
                               String cnpj,
                               String name,
                               String phone,
                               String street,
                               String numberStreet,
                               String postalCod){
            return new LegalPerson(id, cnpj, name,
                        phone, street, numberStreet, postalCod);
        }

    public User createUser(String cpf,
                           String name,
                           String phone,
                           String street,
                           String numberStreet,
                           String postalCod){
        return new PhysicalPerson(Users.getRandomID(), cpf, name,
                    phone, street, numberStreet, postalCod);
    }
}
