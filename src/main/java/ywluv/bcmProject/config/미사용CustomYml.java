package ywluv.bcmProject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class 미사용CustomYml implements ApplicationRunner {

    @Value("${custom.negativeDepositLimit}")
    private int negativeDepositLimit1;
    private static int negativeDepositLimit2;

    public static int getNegativeDepositLimit(){
        return negativeDepositLimit2;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.negativeDepositLimit2 = negativeDepositLimit1;
    }
}
