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

        // 데이터베이스 스키마 자동 생성
        try{

            tx.commit();
        } catch(Exception e){
            tx.rollback();
        } finally{
            em.close();
        }
        emf.close();

    }
}
