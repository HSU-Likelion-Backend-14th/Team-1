package hello.hello_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(HelloSpringApplication.class, args);

		String[] beanNames = ac.getBeanDefinitionNames();
		for (String beanName:beanNames){
			System.out.println("빈 이름 : "+beanName);
		}
	}

}
