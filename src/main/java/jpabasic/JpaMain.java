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

        // IDENTITY 전략은 persist()때 바로 insert 쿼리를 날린다.
        try{
            MemberBasic mb = new MemberBasic();
            mb.setAge(18);
            mb.setUsername("b");
            System.out.println("===========");
            em.persist(mb); // 이 때 insert 쿼리 날라감
            System.out.println("=============");

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();

    }
}
