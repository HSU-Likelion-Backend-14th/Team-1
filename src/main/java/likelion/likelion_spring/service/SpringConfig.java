package likelion.likelion_spring.service;

import likelion.likelion_spring.repository.MemberRepository;
import likelion.likelion_spring.repository.MemoryMemberRepository;
import likelion.likelion_spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
