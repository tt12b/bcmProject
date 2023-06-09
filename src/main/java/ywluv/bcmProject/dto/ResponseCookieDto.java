package ywluv.bcmProject.dto;

import lombok.Getter;

@Getter
public class ResponseCookieDto {

    private final String username;
    private final String session_id;

    public ResponseCookieDto(String username, String session_id){
        this.username = username;
        this.session_id = session_id;
    }
}
