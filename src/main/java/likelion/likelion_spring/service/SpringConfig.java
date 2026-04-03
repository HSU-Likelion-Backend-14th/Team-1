package likelion.likelion_spring.service;

import likelion.likelion_spring.repository.JdbcMemberRepository;
import likelion.likelion_spring.repository.JdbcTemplateMemberRepository;
import likelion.likelion_spring.repository.MemberRepository;
import likelion.likelion_spring.repository.MemoryMemberRepository;
import likelion.likelion_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;


@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    //  return new MemoryMEmberREpository();
    //  return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
