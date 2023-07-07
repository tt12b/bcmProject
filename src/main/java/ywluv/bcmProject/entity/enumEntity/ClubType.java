package ywluv.bcmProject.entity.enumEntity;

public enum ClubType {
    OBKK("오봉콕콕")
,   HRGR("할래갈래")
,   OBKKAndHRGR("오봉콕콕+할래갈래")
,   NONE("미정")
;

    private String displayName;

    ClubType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}


