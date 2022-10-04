package jpabook.jpashop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashop.controller.LoginForm;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {
	
	private final MemberRepository memberRepository;
	//검색
    public boolean login(LoginForm form) {
        
    	Member findMember = memberRepository.findOneById(form.getUserid());
    	
    	if(findMember == null) {
    		return false;
    	}
    	
    	if(!findMember.getPassword().equals(form.getPassword())) {
    		return false;
    	}
    	return true;
    	
    }
	
}
