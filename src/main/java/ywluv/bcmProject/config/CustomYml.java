package ywluv.bcmProject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * application.yml의 값을 가져오는 클래스
 */
@Component
@RequiredArgsConstructor
public class CustomYml implements ApplicationListener<ApplicationStartedEvent> {

    private final Environment env;
    private static int negativeDepositLimit;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        negativeDepositLimit = Integer.parseInt(env.getProperty("custom.negativeDepositLimit"));
    }

    public static int getNegativeDepositLimit(){
        return negativeDepositLimit;
    }


}
