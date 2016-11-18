/**
 * 
 */
package org.mafia.codetest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Model of a member of the mafia
 * 
 * @author igarcia
 */
public class Member {

	/** Name of the member */
	private String name;

	/** Alias of the member */
	private String alias;

	/** Date when he/she started to work for the mafia */
	private Date registration;

	/** Direct boss */
	private Member boss;

	/** List of subordinates */
	private List<Member> subordinates;

	/**
	 * Constructor: Create the registry of a new member
	 * 
	 * @param name
	 * @param alias
	 * @param boss
	 */
	public Member(String name, String alias, Member boss) {
		this.name = name;
		this.alias = alias;
		this.boss = boss;
		this.registration = new Date();
		this.subordinates = new ArrayList<Member>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the registration
	 */
	public Date getRegistration() {
		return registration;
	}

	/**
	 * @param registration
	 *            the registration to set
	 */
	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	/**
	 * @return the boss
	 */
	public Member getBoss() {
		return boss;
	}

	/**
	 * @param boss
	 *            the boss to set
	 */
	public void setBoss(Member boss) {
		this.boss = boss;
	}

	/**
	 * @return the subordinates
	 */
	public List<Member> getSubordinates() {
		return subordinates;
	}

	/**
	 * @param subordinates
	 *            the subordinates to set
	 */
	public void setSubordinates(List<Member> subordinates) {
		this.subordinates = subordinates;
	}
	
	/**
	 * @return the printable name (more readable)
	 */
	public String getPrintableName(){
		return getName() + " a.k.a " + getAlias();
	}
	
	/**
	 * Check if a member needs to a special surveillance
	 */
	public boolean hasSpecialSurveillance(){
		boolean result = false;
		if(this.getSubordinates()!=null && this.getSubordinates().size()>50){
			result = true;
		}
		return result;
	}
	
	/**
	 * String with the info of the member
	 */
	public String toString(){
		StringBuffer buffer = new StringBuffer("");
		buffer.append("Member ");
		buffer.append(this.getPrintableName());
		buffer.append(" \rBoss: ");
		if(this.getBoss()!=null){
			buffer.append(this.getBoss().getPrintableName());
		}else{
			buffer.append(" NOT. HE IS THE GODFATHER");
		}
		
		buffer.append(" \rRegistration date: ");
		buffer.append(this.getRegistration());
		
		
		List<Member> subordinates = this.getSubordinates();
		if(subordinates!=null && !subordinates.isEmpty()){
			buffer.append(" \rSubordinates: ");
			for(Member item: subordinates){
				buffer.append("\r      ");
				buffer.append(item.getPrintableName());
			}
		}
		
		buffer.append("\r---------------------------------------------");
		
		return buffer.toString();
	}


	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Member other = (Member) obj;
		if(other.getName().equalsIgnoreCase(this.getName())){
			result = true;
		}

		return result;
	}

}
