package jpabook.jpashop.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpabook.jpashop.api.MemberApiController.UpdateMemberRequest;
import jpabook.jpashop.api.MemberApiController.UpdateMemberResponse;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ProxyTest {
	
	private final MemberService memberService;
	private final EntityManager em;
	
	@GetMapping("/api/real/members/{id}")
	public void realMemberDB(@PathVariable("id") Long id){
		
//		Member findMember1 = em.find(Member.class, id);
//		System.out.println("fimdMember1.id = " + findMember1.getId());
//		System.out.println("fimdMember1.class = " + findMember1.getClass());
		
		Member findMember2 = em.getReference(Member.class, id);
		System.out.println("fimdMember2.id = " + findMember2.getId());
		System.out.println("fimdMember2.class = " + findMember2.getClass());
		
	}
	
}
