package ywluv.bcmProject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
@Slf4j
//@Component 수동빈으로 등록
public class TimeTraceAop {
    @Around("execution(* ywluv.bcmProject.controller..*.*(..)) || execution(* ywluv.bcmProject.service.*.*(..))")       //테스트용도로 모든 컨트롤러를 대상으로 추가
//    @Around("execution(* ywluv.bcmProject.controller.*.*(..)) || execution(* ywluv.bcmProject.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("START : " + joinPoint.toString()+" 메소드가 실행 시작");
        long start = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        } finally {

            long finish = System.currentTimeMillis();
            long timeMs = finish - start ;

            log.info("START : " + joinPoint.toString()+" 메소드가 실행종료 (" +joinPoint.getSignature() + ":  실행 시간: " + timeMs + "ms)");
        }
    }
}
