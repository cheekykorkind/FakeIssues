package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hello.Member;
import hello.UserMapper;

@Service
public class MemberSeeder {

	@Autowired
	UserMapper registerMemberMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

	public void registerMember() {
        Member member = new Member();
        member.setUsername("user3");
        member.setPassword(passwordEncoder.encode("password"));
		member.setName("안보여");

		registerMemberMapper.insertUser(member);
	}
}