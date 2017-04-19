package ru.spec.ee.ejb;

import javax.ejb.Remote;

@Remote
public interface IEchoService {

	String echo(String msg);

}