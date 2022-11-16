package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext // JPA가 제공하는 표준 어노테이션
    private final EntityManager em;

    // 회원 등록
    public void save(Member member){
        // 영속성 컨텍스트에 member객체를 집어넣어 놓고 있다가.
        // 트랜잭션 때에 insert쿼리가 날라가서 db에 저장된다.
        em.persist(member);
    }

    // 단건 조회 : id
    public Member findOne(Long id) {
        // em.find(리턴타입, PK);
        return em.find(Member.class, id);
    }

    // 모든 회원 조회
    public List<Member> findAll() {
        // em.createQuery(JPQL, 리턴타입)
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();
    }
    // 단건 조회 : name
    public List<Member> findByName(String name){
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name"
                , Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
