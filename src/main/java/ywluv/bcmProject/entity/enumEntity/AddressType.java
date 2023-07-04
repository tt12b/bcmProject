package ywluv.bcmProject.entity.enumEntity;

public enum AddressType {
    OBS
,   OTHER
,   UNKNOWN
;
    public String getDisplayName() {
        switch (this) {
            case OBS:
                return "단지";
            case OTHER:
                return "마음은 단지";
            case UNKNOWN:
                return "알수없음";
            default:
                return "";
        }
    }
}
