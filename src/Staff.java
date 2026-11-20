public class Staff {
    private final String name;
    private final int id;
    private final PrivilegeLevel privilegeLevel;
    private final String password;

    public Staff(String name, int id, String password, PrivilegeLevel access) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.privilegeLevel = access;
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

    @Override
    public String toString() {
        String privilege = "Trainer";
        if (privilegeLevel.equals(PrivilegeLevel.Administrator)) {
            privilege = "Admin";
            if (privilegeLevel.equals(PrivilegeLevel.Cashier)) {
                privilege = "Cashier";
            }
        }
        return "Name: " + name + "ID: " + id + "PrivilegeLevel: " + privilege;
    }
}
