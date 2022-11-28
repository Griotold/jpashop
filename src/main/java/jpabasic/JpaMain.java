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

        // JPQL
        try{
            List<MemberBasic> resultList = em.createQuery("SELECT m FROM MemberBasic as m", MemberBasic.class)
                    .getResultList();
            for (MemberBasic memberBasic : resultList) {
                System.out.println("memberBasic.getName() = " + memberBasic.getName());
            }
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();

    }
}
