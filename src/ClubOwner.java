public class ClubOwner extends Staff{

    public ClubOwner(String name, int id, String password) {
        super(name, id, password);
        this.privilegeLevel = 1;
    }
}
