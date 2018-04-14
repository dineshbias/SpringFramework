package com.sample.run;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.sample.core.annotation.Profile;
import com.sample.core.aop.annotation.Logging;
import com.sample.core.aop.target.Student;
import com.sample.core.collection.JavaCollection;
import com.sample.core.configuration.java.ConfigB;
import com.sample.core.configuration.java.HelloWorldAOP;
import com.sample.core.configuration.java.HelloWorldConfig;
import com.sample.core.configuration.java.OtherConfig;
import com.sample.core.configuration.java.SpellChecker;
import com.sample.core.configuration.xml.HelloAllInOne;
import com.sample.core.configuration.xml.HelloDestroy;
import com.sample.core.configuration.xml.HelloInit;
import com.sample.core.configuration.xml.HelloLazy;
import com.sample.core.configuration.xml.HelloPrototype;
import com.sample.core.configuration.xml.HelloWorld;
import com.sample.core.di.House;
import com.sample.core.di.TextEditor;
import com.sample.core.inheritence.A;
import com.sample.core.inheritence.B;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		//loadUsingBeanFactory("Beans.xml");
		//loadUsingApplicationContext("beans.xml");
		//testInheritence("customizedBeans.xml");
		//testDependencyInjection("di.xml");
		//testCollectionAndSpringBeans("collection.xml");
		//testAutoWiring("autowire.xml");
		//testAnnotation("annotation.xml");
		//testJavaBasedBeans();

		// testAOPOLDStyle("aopOldStyle1_2.xml");
		//testAOP("aop.xml");
		testAOPwithAspectJ("aopAspectJ.xml");
		// testAOPWithJavaBasedBeans();
	}
	
	// Using BeanFactory Container
		public static void loadUsingBeanFactory(String fileName)
				throws BeansException, IOException {
			Path p = Paths.get(".").toRealPath();
			System.out.println(p.toString());

			XmlBeanFactory factory = new XmlBeanFactory(new FileSystemResource(
					(p.toString() + java.io.File.separator + fileName)));

			System.out.println(" loadUsingBeanFactory...");
			HelloWorld obj1 = (HelloWorld) factory.getBean("helloWorld");
			HelloLazy obj2 = (HelloLazy) factory.getBean("helloLazy");
			HelloInit obj3 = (HelloInit) factory.getBean("helloOnInit");
			HelloDestroy obj4 = (HelloDestroy) factory.getBean("helloOnDestory");
			HelloAllInOne obj5 = (HelloAllInOne) factory.getBean("helloAllInOne");
			System.out.println(obj5.getMessage());
			obj5.setMessage("This is message to test default scope");
			System.out.println(obj5.getMessage());
			obj5 = (HelloAllInOne) factory.getBean("helloAllInOne");
			System.out.println(obj5.getMessage());
			System.out.println();

			HelloPrototype obj6 = (HelloPrototype) factory
					.getBean("helloPrototype");
			System.out.println(obj6.getMessage());
			obj6.setMessage("This is message to test default scope");
			System.out.println(obj6.getMessage());
			System.out.println("****");
			obj6 = (HelloPrototype) factory.getBean("helloPrototype");
			System.out.println(obj6.getMessage());
			System.out.println();
		}
		
	public static void loadUsingApplicationContext(String fileName)
			throws IOException {
		Path p = Paths.get(".").toRealPath();

		AbstractXmlApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		context.registerShutdownHook();

		System.out.println(" ...........loadUsingApplicationContext...");

		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj1.getMessage());
		obj1.setMessage("fjfwurwoh");
		HelloWorld obj11 = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj1.getMessage());
		System.out.println(obj11.getMessage());

		System.out.println("**********");

		HelloLazy obj2 = (HelloLazy) context.getBean("helloLazy");
		HelloInit obj3 = (HelloInit) context.getBean("helloOnInit");
		HelloDestroy obj4 = (HelloDestroy) context.getBean("helloOnDestory");

		HelloAllInOne obj5 = (HelloAllInOne) context.getBean("helloAllInOne");
		System.out.println("********** Bean received from context.");

		System.out.println(obj5.getMessage());
		obj5.setMessage("This is message to test default scope");
		System.out.println(obj5.getMessage());
		obj5 = (HelloAllInOne) context.getBean("helloAllInOne");
		System.out.println(obj5.getMessage());
		System.out.println();
		
		
		
		HelloPrototype obj6 = (HelloPrototype) context
				.getBean("helloPrototype");
		System.out.println(obj6.getMessage());
		obj6.setMessage("This is message to test default scope");
		System.out.println(obj6.getMessage());
		System.out.println("****");
		obj6 = (HelloPrototype) context.getBean("helloPrototype");
		System.out.println(obj6.getMessage());
		System.out.println();

	}

	

	public static void testDependencyInjection(String fileName)
			throws IOException {
		Path p = Paths.get(".").toRealPath();

		ApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		System.out.println(" ...........loadUsingApplicationContext...");
		TextEditor obj1 = context.getBean(TextEditor.class);
		obj1.spellCheck();

		House obj2 = context.getBean(House.class);
		System.out.println(obj2.toString());
	}

	public static void testInheritence(String fileName) throws IOException {
		Path p = Paths.get(".").toRealPath();

		ApplicationContext context = new FileSystemXmlApplicationContext(
				p.toString() + java.io.File.separator + fileName);

		System.out.println(" ...........loadUsingApplicationContext...");
		A obj1 = context.getBean(A.class);
		System.out.println(obj1.getClass() + " " + obj1.getMessage1());
		System.out.println(obj1.getClass() + " " + obj1.getMessage2());

		B obj = context.getBean(B.class);
		System.out.println(obj.getClass() + " " + obj.getMessage1());
		System.out.println(obj.getClass() + " " + obj.getMessage2());
		System.out.println(obj.getClass() + " " + obj.getMessage4());
	}

	public static void testCollectionAndSpringBeans(String filename)
			throws IOException {
		Path p = Paths.get(".").toRealPath();

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				p.toString() + File.separator + filename);
		System.out.println(" ...........loadUsingApplicationContext...");

		JavaCollection jc = ctx.getBean(JavaCollection.class);
		jc.getAddressList().forEach((s) -> System.out.print(s + " "));
		System.out.println(" .....");
		jc.getAddressSet().forEach((s) -> System.out.print(s + " "));
		System.out.println(" .....");
		jc.getAddressMap().forEach(
				(k, v) -> System.out.print(k + ":" + v + " "));
		System.out.println(" .....");
		jc.getAddressProp().forEach(
				(k, v) -> System.out.print(k + ":" + v + " "));

	}

	public static void testAutoWiring(String filename) throws IOException {
		Path p = Paths.get(".").toRealPath();

		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				p.toString() + File.separator + filename);
		System.out.println(" ...........loadUsingApplicationContext...");
		com.sample.core.autowiring.name.TextEditor editor = ctx
				.getBean(com.sample.core.autowiring.name.TextEditor.class);
		editor.spellCheck();

		com.sample.core.autowiring.type.B b = ctx
				.getBean(com.sample.core.autowiring.type.B.class);
		b.getSpellChecker();

	}

	public static void testAnnotation(String filename) throws IOException {
		Path p = Paths.get(".").toRealPath();

		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				p.toString() + File.separator + filename);
		ctx.registerShutdownHook();

		// Use bean Id to fetch bean as we have more than 1 bean configured in
		// xml file of same type.
		ctx.getBean("student1");

		com.sample.core.annotation.TextEditor editor = ctx
				.getBean(com.sample.core.annotation.TextEditor.class);
		editor.spellCheck();

		Profile profile = ctx.getBean(Profile.class);
		profile.printName();
		profile.printAge();

		ctx.getBean(com.sample.core.annotation.HelloWorld.class);

	}

	public static void testJavaBasedBeans() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(HelloWorldConfig.class);
		ctx.register(OtherConfig.class);
		ctx.register(ConfigB.class);
		ctx.refresh();
		ctx.registerShutdownHook();

		System.out
				.println(" ...........loadUsingAnnotationConfigApplicationContext...");
		
		for(String beanName :  ctx.getBeanDefinitionNames()){
			System.out.println(beanName);
		}
	
		com.sample.core.configuration.java.HelloWorld helloWorld = ctx
				.getBean(com.sample.core.configuration.java.HelloWorld.class);
		System.out.println(helloWorld.getMessage());
		helloWorld.setMessage("What are you doing?");
		
		helloWorld = ctx
				.getBean(com.sample.core.configuration.java.HelloWorld.class);
		System.out.println(helloWorld.getMessage());

		
		com.sample.core.configuration.java.HelloWorld helloWorldName = (com.sample.core.configuration.java.HelloWorld)ctx
				.getBean("getHelloWorldBean");
		System.out.println(helloWorldName.getMessage());
		helloWorldName.setMessage("What are you doing helloWorldName?");
		
		com.sample.core.configuration.java.TextEditor textEditor = ctx
				.getBean(com.sample.core.configuration.java.TextEditor.class);
		SpellChecker spellChecker = ctx.getBean(SpellChecker.class);
		com.sample.core.configuration.java.TextEditor textEditor2 = ctx
				.getBean(com.sample.core.configuration.java.TextEditor.class);
		System.out.println(textEditor + " " + textEditor2 + " " + spellChecker);
	}

	public static void testAOP(String filename) throws IOException {

		Path path = Paths.get(".").toRealPath();

		ApplicationContext ctx = new FileSystemXmlApplicationContext(path
				+ File.separator + filename);
		System.out
				.println("testAOP ...........loadUsingApplicationContext...   "
						+ path);
		Student student = ctx.getBean(Student.class);
		System.out.println("testAOP... Student retrieved   " + student);
		System.out.println("testAOP... Student Name   " + student.getName());
		System.out.println("testAOP... Set Student Name   " + student);
		student.setName("Dhampu");
		student = ctx.getBean(Student.class);
		System.out.println("testAOP... Student retrieved   " + student);
		try {
			student.printThrowException();
		} catch (Exception e) {
			System.out.println("testAOP... Tested for exception   " + e);

		}

		HelloWorld hw = ctx.getBean("helloWorld",
				com.sample.core.configuration.xml.HelloWorld.class);
		System.out.println("testAOP... HelloWorld retrieved   " + hw);
		System.out.println("testAOP... " + hw.getMessage());

	}

	public static void testAOPOLDStyle(String filename) throws IOException {

		Path path = Paths.get(".").toRealPath();

		ApplicationContext ctx = new FileSystemXmlApplicationContext(path
				+ File.separator + filename);
		System.out
				.println("testAOPOLDStyle ...........loadUsingApplicationContext...   "
						+ path);

		com.sample.core.aop.target.A a = ctx.getBean("proxy",
				com.sample.core.aop.target.A.class);

		System.out.println("testAOPOLDStyle ...........Bean Loaded...   ");

		a.m();
		a.n();
	}

	public static void testAOPwithAspectJ(String filename) throws IOException {

		Path path = Paths.get(".").toRealPath();

		ApplicationContext ctx = new FileSystemXmlApplicationContext(path
				+ File.separator + filename);
		System.out
				.println("testAOPwithAspectJ ...........loadUsingApplicationContext...   "
						+ path);
		Student student = ctx.getBean(Student.class);
		System.out.println("testAOPwithAspectJ... Student retrieved   "
				+ student);
		System.out.println("testAOPwithAspectJ... Student Name   "
				+ student.getName());
		System.out.println("testAOPwithAspectJ... Set Student Name   "
				+ student);
		student.setName("Dhampu");
		student = ctx.getBean(Student.class);
		System.out.println("testAOPwithAspectJ... Student retrieved   "
				+ student);
		try {
			student.printThrowException();
		} catch (Exception e) {
			System.out.println("testAOPwithAspectJ... Tested for exception   "
					+ e);

		}

		HelloWorld hw = ctx.getBean("helloWorld",
				com.sample.core.configuration.xml.HelloWorld.class);
		System.out.println("testAOP... HelloWorld retrieved   " + hw);
		System.out.println("testAOP... " + hw.getMessage());
	}

	public static void testAOPWithJavaBasedBeans() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(HelloWorldAOP.class);
		ctx.register(HelloWorld.class);
		
		//Registering Aspect as bean
		ctx.register(Logging.class);
		
		ctx.refresh();
		ctx.registerShutdownHook();

		System.out
				.println(" ...........loadUsingAnnotationConfigApplicationContext...");

		Student student = ctx.getBean(Student.class);
		System.out.println("testAOPWithJavaBasedBeans... Student retrieved   "
				+ student);
		System.out.println("testAOPWithJavaBasedBeans... Student Name   "
				+ student.getName());
		System.out.println("testAOPWithJavaBasedBeans... Set Student Name   "
				+ student);
		student.setName("Dhampu");
		student = ctx.getBean(Student.class);
		System.out.println("testAOPWithJavaBasedBeans... Student retrieved   "
				+ student);
		try {
			student.printThrowException();
		} catch (Exception e) {
			System.out
					.println("testAOPWithJavaBasedBeans... Tested for exception   "
							+ e);

		}

		HelloWorld hw = ctx.getBean("helloWorld",
				com.sample.core.configuration.xml.HelloWorld.class);
		System.out.println("testAOP... HelloWorld retrieved   " + hw);
		System.out.println("testAOP... " + hw.getMessage());
	}

}
