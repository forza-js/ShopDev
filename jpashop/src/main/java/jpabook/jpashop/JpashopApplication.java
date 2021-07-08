package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args) {
		
		/* lombok 설정 완료 */
		hello h = new hello();
		h.setData("hello");
		String data = h.getData();
		System.out.println(data);
		SpringApplication.run(JpashopApplication.class, args);
	}

}
