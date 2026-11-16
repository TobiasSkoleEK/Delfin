public abstract class Staff{
    private final String name;
    private final int id;
    private final PrivilegeLevel privilegeLevel;
    private final String password;

    public Staff(String name, int id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public PrivilegeLevel getPrivilegeLevel() {
        return privilegeLevel;
    }
}
