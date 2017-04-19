package ru.spec.ee.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Session Bean implementation class EchoService
 */
@Stateless(mappedName = "echoBean")
@LocalBean
public class EchoService implements IEchoService {

	
//	@EJB/*(lookup="test")*/
	@Inject
	TestService testService;

	@Inject
	@Named
	double rnd;
	
    public EchoService() {
    	
    }
    
    @PostConstruct
    public void init(){
    	
    }
    
    /* (non-Javadoc)
	 * @see ru.spec.ee.ejb.IEchoService#echo(java.lang.String)
	 */
    @Override
	public String echo(String msg){
    	testService.test();
    	System.out.println(rnd);
    	
    	System.out.println("--->"+testService.getClass().getName());
    	return "re:"+msg;
    }
    
    

}
