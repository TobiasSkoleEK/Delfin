public class Staff{
    private final String name;
    private final int id;
    private final privilegeLevel privilegeLevel;
    private final String password;

    public Staff(String name, int id, privilegeLevel privilegeLevel, String password){
        this.name = name;
        this.id = id;
        this.privilegeLevel = privilegeLevel;
        this.password = password;
    }

    public privilegeLevel getPrivilegeLevel() {
        return privilegeLevel;
    }
}
