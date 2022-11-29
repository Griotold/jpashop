package jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // 준영속 상태 detached
        try{
            MemberBasic findedMB = em.find(MemberBasic.class, 6L);
            findedMB.setName("mbFF");
                
            //em.detach(findedMB); // 특정 엔티티를 준영속 상태로 만들기
            em.clear(); // 영속성 컨텍스트 밀어버리기
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close(); // 종료되었으니 영속성 컨텍스트도 같이 종료
        }
        emf.close();

    }
}
