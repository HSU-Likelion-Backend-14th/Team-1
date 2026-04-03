package likelion.likelion_spring.service;

import likelion.likelion_spring.domain.Member;
import likelion.likelion_spring.repository.*;
import likelion.likelion_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//  @Bean
//  public MemberRepository memberRepository(){
//      return new MemoryMemberRepository();
//      return new JdbcMemberRepository(dataSource);
//      return new JdbcTemplateMemberRepository(dataSource);
//      return new JdbcMemberRepository(em);

//  }


}
