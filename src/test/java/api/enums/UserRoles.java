package api.enums;

public enum UserRoles {
    USER("app-user"),
    MANAGER("app-manager"),
    ADMIN("app-admin");
    private final String role;

    UserRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
