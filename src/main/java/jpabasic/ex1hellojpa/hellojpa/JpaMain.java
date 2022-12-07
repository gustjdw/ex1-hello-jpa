package jpabasic.ex1hellojpa.hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

/*            // 비영속 상태
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            // 이 시점에 영속 상태
            System.out.println("=== Before persist ===");
            em.persist(member);
            System.out.println("=== After persist ===");

            Member findMember = em.find(Member.class, 101L);  // 얘는 1차 캐시에서 조회했기 때문에 select 쿼리 안 나감
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());

            Member findMember2 = em.find(Member.class, 100L);  // 얘는 DB에서 조회했기 때문에 select 쿼리 나감
            System.out.println("findMember2.getId() = " + findMember2.getId());
            System.out.println("findMember2.getName() = " + findMember2.getName());

            System.out.println("=== Before commit ===");
            tx.commit();
            System.out.println("=== After commit ===");*/

/*            // select 쿼리가 1번만 나가야 함
            Member findMember1 = em.find(Member.class, 101L);  // DB에서 조회, select 쿼리 나감
            Member findMember2 = em.find(Member.class, 101L);  // 1차 캐시에서 조회, select 쿼리 안 나감*/

/*            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            System.out.println("===========================================");

            tx.commit();*/

            Member member = new Member(200L, "member200");
            em.persist(member);
            em.flush();
            System.out.println("=============================================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            System.out.println("=== finally {em.close()}; ===");
            em.close();
        }
        System.out.println("=== emf.close(); ===");
        emf.close();
    }
}
