package net.softsociety.merukari.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.merukari.dao.MemberDAO;
import net.softsociety.merukari.domain.Member;


@Service
@Slf4j
public class MemberSeviceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	@Autowired
	private PasswordEncoder pe;
   
	@Override
	public int join(Member m) {
		String pw = pe.encode(m.getMemberpw());
		
		log.debug("암호화 전 : {}", m.getMemberpw());
		log.debug("암호화 후 : {}", pw);
		
		m.setMemberpw(pw);
		int n = dao.memberInsert(m);
		return n;
	}
}
