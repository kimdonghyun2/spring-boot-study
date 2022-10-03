//package jpabook.jpashop;
//
//import org.assertj.core.api.Assertions;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import jpabook.jpashop.domain.Member;
//import jpabook.jpashop.repository.MemberRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MemberRepositoryTest{
//	
//	
//	@Autowired MemberRepository memberRepository;
//	
//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testMember() throws Exception{
//		Member member = new Member();
//		member.setName("memberA");
//		
//		Long saveId = memberRepository.save(member);
//		
//		Member findMember = memberRepository.find(saveId);
//		
//		Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
//		Assertions.assertThat(member.getUsername()).isEqualTo(findMember.getUsername());
//		Assertions.assertThat(findMember).isEqualTo(member);
//	}
//}