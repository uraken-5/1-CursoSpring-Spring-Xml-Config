package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/ApplicationContext.xml");
		Saludo saludo = context.getBean(Saludo.class);
		saludo.saludoMañanero();

	}

}
