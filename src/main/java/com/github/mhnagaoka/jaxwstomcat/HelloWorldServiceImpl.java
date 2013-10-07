package com.github.mhnagaoka.jaxwstomcat;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.github.mhnagaoka.jaxwstomcat.ws.HelloWorldPortType;

@WebService(name = "HelloWorldPortType", targetNamespace = "http://github.com/mhnagaoka/jaxws-tomcat/service")
public class HelloWorldServiceImpl implements HelloWorldPortType {

	@Override
	@WebMethod(action = "http://github.com/mhnagaoka/jaxws-tomcat/service/sayHelloWorld")
	@WebResult(name = "result", targetNamespace = "")
	@RequestWrapper(localName = "sayHelloWorld", targetNamespace = "http://github.com/mhnagaoka/jaxws-tomcat/service", className = "com.github.mhnagaoka.jaxwstomcat.ws.SayHelloWorld")
	@ResponseWrapper(localName = "sayHelloWorldResponse", targetNamespace = "http://github.com/mhnagaoka/jaxws-tomcat/service", className = "com.github.mhnagaoka.jaxwstomcat.ws.SayHelloWorldResponse")
	public String sayHelloWorld(
			@WebParam(name = "message", targetNamespace = "") String message) {
		return message;
	}

	/**
	 * Publishes this web service as a standalone application.
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9090/ws/helloWorld",
				new HelloWorldServiceImpl());

	}

}
