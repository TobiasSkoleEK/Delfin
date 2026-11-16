public class Cashier extends Staff{

    public Cashier(String name, int id, String password) {
        super(name, id, password);
        this.privilegeLevel = 2;
    }
}
