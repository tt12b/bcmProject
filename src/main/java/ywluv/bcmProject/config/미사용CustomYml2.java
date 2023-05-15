package ywluv.bcmProject.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//세터로 값을 바꿀 가능성이 있음
@Component
@ConfigurationProperties(prefix = "custom")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class 미사용CustomYml2 {
    private int negativeDepositLimit;
}
