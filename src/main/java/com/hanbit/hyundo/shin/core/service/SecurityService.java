package com.hanbit.hyundo.shin.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanbit.hyundo.shin.core.dao.MemberDAO;

@Service
public class SecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	private static PasswordEncoder encoder = new BCryptPasswordEncoder(4);

	@Autowired
	private MemberDAO memberDAO;

	public String encryptPassword(String password) {
		return encoder.encode(password);
	}

	public boolean matchPassword(String rawPassword, String encryptedPassword) {
		return encoder.matches(rawPassword, encryptedPassword);
	}

	public int getValidMemberId(String email, String password) {
		int memberId = -1;

		try {
			memberId = memberDAO.selectMemberId(email);
		}
		catch (Exception e) {
			throw new RuntimeException("가입되지 않은 이메일입니다.");
		}

		String encryptedPassword = memberDAO.selectPassword(memberId);

		if (!matchPassword(password, encryptedPassword)) {
			throw new RuntimeException("패스워드가 일치하지 않습니다.");
		}

		return memberId;
	}


}
