package com.eberts.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class EbertsShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbertsShopApplication.class, args);

		Map<String, PasswordEncoder> encoders = new HashMap<>();
		Pbkdf2PasswordEncoder pbkdf2Encoder = new Pbkdf2PasswordEncoder("",8,185000, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
		encoders.put("pbkdf2", pbkdf2Encoder);
		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);

		String cryptoP = passwordEncoder.encode("admin123");
		System.out.println(cryptoP);
		String cryptoPuser = passwordEncoder.encode("user123");
		System.out.println(cryptoPuser);
		String cryptoPclient = passwordEncoder.encode("client123");
		System.out.println(cryptoPclient);
	}

}
