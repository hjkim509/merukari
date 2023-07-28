package net.softsociety.merukari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.merukari.domain.Member;
import net.softsociety.merukari.service.MemberService;


/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired	
	MemberService service;
	
	//회원가입 폼으로 이동
	@GetMapping("join")
	public String join() {
		return "joinForm";
	}
	
	//회원가입 처리
	@PostMapping("join")
	public String join(Member m) {
		//log.debug("{}", m);
		service.join(m);
		return "redirect:/";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public String loginForm() {
		return "loginForm";
	}
	
}
