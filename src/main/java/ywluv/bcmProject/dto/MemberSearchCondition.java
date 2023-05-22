package ywluv.bcmProject.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ywluv.bcmProject.entity.DepositHistory;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberSearchCondition {

    private String userNickName;
    private String userName;
    private String clubName;
    private Integer depositGoe;
    private Integer depositLoe;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
