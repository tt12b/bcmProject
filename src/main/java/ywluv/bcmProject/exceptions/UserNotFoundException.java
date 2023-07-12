package ywluv.bcmProject.exceptions;

public class UserNotFoundException extends RuntimeException{

    private Long userId;
    private String userNickName;

    public UserNotFoundException(String message, Long userId){
        super(message);
        this.userId=userId;
    }

    public UserNotFoundException(String message, String userNickName){
        super(message);
        this.userNickName=userNickName;
    }


    public Long getUserId() {
        return userId;
    }

    public String getUserNickName() {
        return userNickName;
    }
}
