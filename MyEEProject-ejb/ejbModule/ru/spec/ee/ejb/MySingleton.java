package ru.spec.ee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class MySingleton
 */
@Singleton(mappedName = "singleton")
@LocalBean
public class MySingleton implements IMySingleton {

	
	int count=0;
    /**
     * Default constructor. 
     */
    public MySingleton() {
       System.out.println("+++++++MySingleton "+Thread.currentThread());
    }
    
    @PostConstruct
    void init(){
    	System.out.println("+++--->MySingleton.init "+Thread.currentThread());
    }
    
    @Override
    @Lock(LockType.READ)
    public String echo(String msg){
    	return msg;
    }

}
