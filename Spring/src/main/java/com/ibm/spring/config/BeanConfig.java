package com.ibm.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.spring.beans.SpellChecker;
import com.ibm.spring.beans.TextEditor;

// use configuartion so we can create beans in file instead of xml file but make sure <context:annotation-config /> is in xml file 
@Configuration
public class BeanConfig {
//	textEditor id is used in context.getBean() to create that bean 
	@Bean("textEditor")  
	public TextEditor getTextEditor(){
		return new TextEditor();
	}
	
	@Bean
	public SpellChecker getSpellChecker() {
		return new SpellChecker();
	}
}
