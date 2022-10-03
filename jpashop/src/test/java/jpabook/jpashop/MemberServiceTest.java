package jpabook.jpashop;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;
	
	@Test
	//@Rollback(false)
	public void 회원가입() throws Exception{
		Member member = new Member();
		member.setName("kim");
		
		Long saveId = memberService.join(member);
	
		assertEquals(member, memberRepository.findOne(saveId));
	}
	
	@Test(expected = IllegalStateException.class)
	public void 중복_회원_예외() throws Exception{
		Member member1 = new Member();
		member1.setName("kim");
		
		Member member2 = new Member();
		member2.setName("kim");
		
		memberService.join(member1);
		memberService.join(member2); //예외가 발생해야 한다!!
		
		fail("예외가 발생해야 한다.");
	}
}
