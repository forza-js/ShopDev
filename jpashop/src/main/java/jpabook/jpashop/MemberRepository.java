package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public Long save(Member member) {
		em.persist(member);
		return member.getId(); //커맨드와 쿼리를 분리하기 위해 member가 아니라 id만 리턴.
	}
	
	public Member find(Long id) {
		return em.find(Member.class, id);
	}
	
}
