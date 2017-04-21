package ru.spec.ee.ejb;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Stateless
public class TestService {

	public void test(){
		System.out.println("TEST");
	}

	@Produces
	@UserIdGenerator
	public double getRnd(){
		return Math.random();
	}
	
	@Produces
	@Named("a1")
	public double getRnd100(){
		return Math.random()*100;
	}
}
