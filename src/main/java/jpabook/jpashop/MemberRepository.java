package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // 컴포넌트 스캔 대상으로 스프링 빈 컨테이너에 등록된다.
public class MemberRepository {

    @PersistenceContext // 스프링부트가 em을 주입해준다.
    private EntityManager em;

    // 리턴타입이 Member가 아니라 Long인 이유
    // 커맨드와 쿼리를 분리하라는 원칙
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 조회
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
