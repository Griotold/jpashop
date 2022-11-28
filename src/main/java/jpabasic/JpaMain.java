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

        // 변경 감지
        try{
            
            MemberBasic findedMember = em.find(MemberBasic.class, 4L); // mbD
            findedMember.setName("mbDD"); // mbDD로 변경
            
            // em.persist(findedMember); 하면 안됨

            tx.commit(); // 실제 쿼리가 날라가서 DB에 업데이트
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();

    }
}
