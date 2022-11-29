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

        // 플러쉬
        try{
            MemberBasic mb = new MemberBasic(6L, "mbF");
            em.persist(mb);
            // 커밋전에 sql이 날라가는 걸 보고 싶으면 직접 호출
            em.flush();
            System.out.println("============");

            tx.commit(); // 플러시 자동 호출인데, 위에서 호출해줬으므로 이때는 호출 안함.
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();

    }
}
