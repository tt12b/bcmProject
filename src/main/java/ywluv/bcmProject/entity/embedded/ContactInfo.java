package ywluv.bcmProject.entity.embedded;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactInfo {

    private String phoneNumber;
    private String email;

    public ContactInfo(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
