package org.mafia.codetest.model;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Structure of the organization
 * 
 * @author igarcia
 * 
 */
public class Organization {

	/** Highest level in the organization */
	private Member godfather = null;

	/** List of members who are now in prision */
	private List<Member> imprisonedMembers = null;
	
	
	/**
	 * Constructor: Create the organization
	 */
	public Organization(Member godfather) {
		this.godfather = godfather;
		this.imprisonedMembers = new ArrayList<Member>();
	}

	/**
	 * @return the godfather
	 */
	public Member getGodfather() {
		return godfather;
	}

	/**
	 * @param godfather
	 *            the godfather to set
	 */
	public void setGodfather(Member godfather) {
		this.godfather = godfather;
	}

	/**
	 * @return the imprisonedMembers
	 */
	public List<Member> getImprisonedMembers() {
		return imprisonedMembers;
	}

	/**
	 * @param imprisonedMembers
	 *            the imprisonedMembers to set
	 */
	public void setImprisonedMembers(List<Member> imprisonedMembers) {
		this.imprisonedMembers = imprisonedMembers;
	}

}
