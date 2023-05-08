package ywluv.bcmProject.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.bcmProject.entity.baseEntity.BaseTimeEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.time.LocalDateTime;
import java.util.Optional;

@Profile("test")
@Component
@RequiredArgsConstructor
public class testInit {

    private final InitData initData;

    //bean 초기화 시점에 실행
    @PostConstruct
    public void init() {

        System.out.println("===PostContruct===");
        initData.init();
        System.out.println("===PostContruct===");
    }

    // 스프링 라이플 사이클 특성상, @PostConstruct와 @Transactional 을 분리
    //테스트용 데이터 초기화 할 내부 클래스 생성
    @Component
    static class InitData {
        @Autowired EntityManager em;

        @Transactional
        public void init() {
            Club clubA = new Club("clubA");
            Club clubB = new Club("clubB");

            em.persist(clubA);
            em.persist(clubB);

            String createdBy = "테스트";

            for (int i = 1; i <= 100; i++) {
                Member member = new Member("닉네임 " + i, "이름"+i);
                AddressType addressType;

                Club selectedClub;
                if (i % 2 == 0) {
                    selectedClub = clubB;
                    addressType = AddressType.OBS;
                } else {
                    selectedClub = clubA;
                    addressType = AddressType.OTHER;
                }

                MemberClub memberClub = new MemberClub(member, selectedClub);
                member.changeAddressType(addressType);
                member.getMemberClubs().add(memberClub);
                selectedClub.getMemberClubs().add(memberClub);

                em.persist(member);
                em.persist(memberClub);
            }
        }

        //AuditorAware을 Bean으로 등록하게 되면 Auditor를 추출해     @CreatedBy/lastModifiedBy에 매핑
        @Bean
        public AuditorAware<String> auditorProvider() {
            return () -> Optional.of("테스트");
        }

    }
}
