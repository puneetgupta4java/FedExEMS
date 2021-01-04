package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootEmsApplication implements CommandLineRunner {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User();
		u1.setId("106210");
		u1.setName("Puneet gupta");
		u1.setMail("puneet1.gupta@infogain.com");
		u1.setDesignation("Software Engineer Trainee");
		u1.setExtension("4806");
		u1.setProject("FedEx-eCommercials_Jun18-Nov18");
		u1.setOracleid("32534");
		u1.setSeat("GDC1/FF/053");
		u1.setImg("106210.jpeg");
		u1.setImgurl("\\\\172.18.80.161\\Photos\\106210.jpeg");
		u1.setDu("DU2");
		userRepository.save(u1);
		User u2 = new User();
		u2.setId("100258");
		u2.setName("Himanshu gupta");
		u2.setMail("Himanshu.Gupta@infogain.com");
		u2.setDesignation("Technology Lead");
		u2.setExtension("4801");
		u2.setProject("FedEx-FPOS-RDA_Jun18-Nov18");
		u2.setOracleid("32534");
		u2.setSeat("GDC1/FF/029");
		u2.setImg("2100725.jpg");
		u2.setImgurl("\\\\172.18.80.161\\Photos\\2100725.jpg");
		u2.setDu("DU2");
		userRepository.save(u2);
		User u3 = new User();
		u3.setId("106211");
		u3.setName("Puneet gupta");
		u3.setMail("puneet2.gupta@infogain.com");
		u3.setDesignation("Software Engineer Trainee");
		u3.setExtension("4806");
		u3.setProject("FedEx-OE_Jun18-Nov18");
		u3.setOracleid("32534");
		u3.setSeat("GDC1/FF/050");
		u3.setImg("106211.jpeg");
		u3.setImgurl("\\\\172.18.80.161\\Photos\\106211.jpeg");
		u3.setDu("DU2");
		userRepository.save(u3);
	}
}
