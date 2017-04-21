package ru.spec.ee.ejb;

import javax.ejb.Remote;

@Remote
public interface IMySingleton {

	String echo(String msg);

	String echoTextMsg(String msg);

}
