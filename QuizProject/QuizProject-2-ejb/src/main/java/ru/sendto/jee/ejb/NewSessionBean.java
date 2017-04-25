/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sendto.jee.ejb;

import javax.ejb.Stateless;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author martin
 */
@Singleton
@LocalBean
public class NewSessionBean {

	@PostConstruct
	public void init(){
		System.out.println("++++++++++++++++++++++");
	}
	
	@Schedule(hour="*", minute="*", second="*/10")
	public void onTime(){
		System.out.println(new Date());
	}
}
