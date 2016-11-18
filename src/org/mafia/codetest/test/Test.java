package org.mafia.codetest.test;

import org.mafia.codetest.Mafia;
import org.mafia.codetest.model.Member;


/**
 * Test the application
 * 
 * @author igarcia
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create the members
		Mafia mafia = new Mafia();
		Member m1 = mafia.addMember("Tony Soprano", "Tony");
		Member m21 = mafia.addMember("John Smith", "Johnny", m1);
		Member m22 = mafia.addMember("Matt Smith", "Mathy", m1);
		
		Member m31 = mafia.addMember("George Pasci", "George", m21);
		Member m32 = mafia.addMember("Peter Smith", "Pet", m21);
		Member m33 = mafia.addMember("Joe Gomez", "Joe", m21);
		Member m34 = mafia.addMember("Kevin B. Lopez", "Key", m22);
		Member m35 = mafia.addMember("Martin Jr. Smith", "The Kid", m22);
		
		System.out.println("**********************************************");
		System.out.println("TEST: Initial organization");
		System.out.println("**********************************************");
		
		System.out.println(m1);
		System.out.println(m21);
		System.out.println(m22);
		System.out.println(m31);
		System.out.println(m32);
		System.out.println(m33);
		System.out.println(m34);
		System.out.println(m35);
		
		System.out.println("**********************************************");
		System.out.println("TEST: " + m22.getPrintableName() + " goes to prision");
		System.out.println("**********************************************");
		mafia.memberGoesToJail(m22);
		System.out.println(m1);
		System.out.println(m21);
		System.out.println(m31);
		System.out.println(m32);
		System.out.println(m33);
		System.out.println(m34);
		System.out.println(m35);
		
		System.out.println("**********************************************");
		System.out.println("TEST: " + m22.getPrintableName() + " is released from prison");
		System.out.println("**********************************************");
		mafia.memberReleasedFromPrison(m22);
		System.out.println(m1);
		System.out.println(m21);
		System.out.println(m22);
		System.out.println(m31);
		System.out.println(m32);
		System.out.println(m33);
		System.out.println(m34);
		System.out.println(m35);
		
		
		System.out.println("**********************************************");
		System.out.println("TEST: " + m1.getPrintableName() + " goes to prision");
		System.out.println("**********************************************");
		mafia.memberGoesToJail(m1);
		System.out.println(m21);
		System.out.println(m31);
		System.out.println(m32);
		System.out.println(m33);
		System.out.println(m34);
		System.out.println(m35);
		
		
		
	}

}
