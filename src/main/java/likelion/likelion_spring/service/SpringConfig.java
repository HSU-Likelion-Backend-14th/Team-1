package likelion.likelion_spring.service;

import jakarta.persistence.EntityManager;
import likelion.likelion_spring.repository.*;
import likelion.likelion_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em=em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    //  return new MemoryMEmberREpository();
    //  return new JdbcMemberRepository(dataSource);
    //  return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
