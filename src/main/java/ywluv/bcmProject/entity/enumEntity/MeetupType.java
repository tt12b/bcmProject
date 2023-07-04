package ywluv.bcmProject.entity.enumEntity;

public enum MeetupType {

    badminton
,   boardGame
,   overallGathering//전체 회식
,   partialGathering//부분 회식
,   walk            //산책
,   shopping        //쇼핑
,   etc             //기타
;

    public String getDisplayName() {
        switch (this) {
            case badminton:
                return "배드민턴";
            case boardGame:
                return "보드게임";
            case overallGathering:
                return "전체회식";
            case partialGathering:
                return "부분회식";
            case walk:
                return "산책";
            case shopping:
                return "쇼핑";
            case etc:
                return "기타";
            default:
                return "";
        }
    }
}
