package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.LoginService;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;

	@GetMapping("/login/login")
	public String loginForm(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		return "login/loginMemberForm";
	}
	
	@PostMapping("login/login")
	public String loginById(@Valid LoginForm form, BindingResult result) {
		if(loginService.login(form)) {
			return "redirect:/";
		}
		
		return "login";
	}
}
