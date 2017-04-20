package ru.spec.ee.ejb;

import java.math.BigInteger;
import java.util.concurrent.Future;

import javax.ejb.Remote;

@Remote
public interface IEchoService {

	String echo(String msg);

	int incrementAndGet();

	Future<BigInteger> getFibonacciElement(int index);

}