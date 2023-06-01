package ywluv.bcmProject.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.AppConfig;
import ywluv.bcmProject.service.MemberService;

@SpringBootTest
@Transactional
class MeetupDtoTest {

    @Autowired MemberService memberService;
    @Autowired private ApplicationContext context;

    @Test
    public void test() {

//            String[] beanNames = context.getBeanDefinitionNames();
//
//            for (String beanName : beanNames) {
//                System.out.println("Bean Name: " + beanName);
//                System.out.println("Bean Type: " + context.getType(beanName));
//                System.out.println("Bean Instance: " + context.getBean(beanName));
//                System.out.println("-------------------------");
//            }
//
//        MeetupDto meetupDto = new MeetupDto();
//
//
//        System.out.println("=====================");
//        System.out.println(memberService);
//        System.out.println("=====================");
//        System.out.println(meetupDto.memberService);

    }





}