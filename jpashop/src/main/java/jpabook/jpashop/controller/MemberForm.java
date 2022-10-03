package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

	@NotEmpty(message = "회원 id는 필수 입니다")
	private String userid;
	
	@NotEmpty(message = "회원 비밀번호는 필수 입니다")
	private String password;
	
	@NotEmpty(message = "회원 주민번호는 필수 입니다")
	private String rrn;
	
    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;
    

    private String city;
    private String street;
    private String zipcode;
}
