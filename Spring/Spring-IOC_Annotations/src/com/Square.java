package com;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Square implements Shape{
	@Override
	public void draw() {
		System.out.println("--- Drawing Square");
		
	}
}
