package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
 // 스프링은 main 실행파일의 하위경로 안에 있는것들만 어노테이션을 지원해줄수있다.
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
