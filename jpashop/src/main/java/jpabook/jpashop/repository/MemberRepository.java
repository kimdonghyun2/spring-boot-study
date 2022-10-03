package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
        
    }
    
    public List<Member> login(Member member) {
    	
    	return em.createQuery("select m from Member m where m.userid = :userid and m.password = :password", Member.class)
    			.setParameter("userid", member.getUserid())
    			.setParameter("password", member.getPassword())
    			.getResultList();
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    
    public List<Member> findByUserId(String userid) {
        return em.createQuery("select m from Member m where m.userid = :userid", Member.class)
                .setParameter("userid", userid)
                .getResultList();
    }
    
    public List<Member> findByPassword(String password) {
        return em.createQuery("select m from Member m where m.password = :password", Member.class)
                .setParameter("password", password)
                .getResultList();
    }
    
    public List<Member> findByRrn(String rrn) {
        return em.createQuery("select m from Member m where m.rrn = :rrn", Member.class)
                .setParameter("rrn", rrn)
                .getResultList();
    }
}
