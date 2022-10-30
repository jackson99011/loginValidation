package com.example.password;

import com.example.password.valid.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ValidatorConfig {

	@Bean
	public PasswordValid lengthValidator(){
		return new ValidLength();
	}
	
	@Bean
	public PasswordValid lowerAndDigitsValidator(){
		return new ValidLowerAndDigits();
	}
	
	@Bean
	public PasswordValid lowerAndDigitsOnceValidator(){
		return new ValidLowerAndDigitsOnce();
	}
	
	@Bean
	public PasswordValid notRepeatSequenceValidator(){
		return new ValidNotRepeatSequence();
	}
	
	@Bean
	public List<PasswordValid> validators(){
		List<PasswordValid> validators  = new ArrayList<>();
		validators.add(lengthValidator());
		validators.add(lowerAndDigitsValidator());
		validators.add(lowerAndDigitsOnceValidator());
		validators.add(notRepeatSequenceValidator());
		return validators;
	}
}
