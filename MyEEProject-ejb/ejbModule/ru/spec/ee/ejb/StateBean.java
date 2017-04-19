package ru.spec.ee.ejb;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class StateBean
 */
@Stateful(mappedName = "StateBean")
@LocalBean
public class StateBean implements Serializable, IStateBean {

	int count=0;
	
	public int incrementAndGet(){
		return ++count;
	}
	
	
	@PostActivate
	@PrePassivate
	@Remove
	public void remove(){
		
	}

}
