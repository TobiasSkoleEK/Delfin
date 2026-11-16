public class Staff{
    private final String name;
    private final int id;
    private final PrivilegeLevel privilegeLevel;
    private final String password;

    public Staff(String name, int id, PrivilegeLevel privilegeLevel, String password){
        this.name = name;
        this.id = id;
        this.privilegeLevel = privilegeLevel;
        this.password = password;
    }

    public PrivilegeLevel getPrivilegeLevel() {
        return privilegeLevel;
    }
}
