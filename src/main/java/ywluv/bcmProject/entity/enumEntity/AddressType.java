package ywluv.bcmProject.entity.enumEntity;

public enum AddressType {

    OBS("단지")
,   OTHER("마음은 단지")
,   UNKNOWN("알수없음")
;

    private String displayName;


    AddressType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}