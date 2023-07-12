package ywluv.bcmProject.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message, Long id){
        super(message);
    }

    public UserAlreadyExistsException(String message, String userNickName){
        super(message);
    }
}
