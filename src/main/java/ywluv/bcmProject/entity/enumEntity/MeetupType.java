package ywluv.bcmProject.entity.enumEntity;

public enum MeetupType {

    badminton("배드민턴")
,   boardGame("보드게임")
,   overallGathering("전체회식")
,   partialGathering("부분회식")
,   walk("산책")
,   shopping("쇼핑")
,   etc("기타")
;

    private final String displayName;

    MeetupType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }


}