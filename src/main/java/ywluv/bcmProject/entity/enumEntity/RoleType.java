package ywluv.bcmProject.entity.enumEntity;

public enum RoleType {
        ROLE_USER("유저")
    ,   ROLE_MANAGER("매니저")
    ,   ROLE_ADMIN("어드민")
    ;

    private final String displayName;


    RoleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
