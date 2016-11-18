package org.mafia.codetest;

import java.util.List;

import org.mafia.codetest.model.Member;
import org.mafia.codetest.model.Organization;

/**
 * 
 * Mafia: Management of the data of the mafia
 * 
 * @author igarcia
 * 
 */
public class Mafia {

	
	private Organization organization = null;
	
	/**
	 * Constructor: Create the mafia registry
	 */
	public Mafia() {
		organization = new Organization(null);
	}
	
	/**
	 * Constructor: Create the mafia registry
	 */
	public Mafia(Member godfather) {
		organization = new Organization(godfather);
	}
	
	/**
	 * Add a new member to the mafia
	 */
	public Member addMember(String name, String alias, Member boss){
		Member item = new Member(name, alias, boss);
		addSubordinate(boss, item);
		return item;
	}
	
	/**
	 * Add a new member to the mafia (godfather)
	 */
	public Member addMember(String name, String alias){
		Member item = new Member(name, alias, null);
		organization.setGodfather(item);
		return item;
	}
	
	/**
	 * A member of the mafia goes to jail.
	 * @param member New prisioner
	 */
	public void memberGoesToJail(Member member){
		
		//First: another member in prision
		List<Member> list = this.organization.getImprisonedMembers();
		list.add(member);
		
		//Disappear from the list of his boss
		//If the boss is not null
		List<Member> sameLevelMembers = null;
		Member newBossForSubordinates = null;
		Member boss = member.getBoss();
		if(boss!=null){
			sameLevelMembers = boss.getSubordinates();
			sameLevelMembers.remove(member);
			
			if(sameLevelMembers.size()>0){
				newBossForSubordinates = sameLevelMembers.get(0);
			}
		}
		
		//His subordinates have to change the boss
		List<Member> subordinates = member.getSubordinates();
		if(subordinates!=null && !subordinates.isEmpty()){
			//Two options
			//1-There is a new boss for the subordinates
			if(newBossForSubordinates!=null){
				for(Member item: subordinates){
					//Set the new boss
					addSubordinate(newBossForSubordinates, item);
					item.setBoss(newBossForSubordinates);
				}
			
			//2- The oldest subordinate has to promote
			}else{
				Member first = subordinates.get(0);
				subordinates.remove(first);
				if(boss!=null){
					addSubordinate(boss, first);
					first.setBoss(boss);
				}else{
					//We have a new godfather
					first.setBoss(null);
					this.organization.setGodfather(first);
				}
				
				//Change the structure
				for(Member item: subordinates){
					addSubordinate(first, item);
					item.setBoss(first);
				}
			}
		}
	}
	
	
	/**
	 * Check if a member needs to a special surveillance
	 * @param member
	 * @return
	 */
	public boolean hasSpecialSurveillance(Member member){
		return member.hasSpecialSurveillance();
	}

	
	/**
	 * Code to run if a member is released from prision
	 * @param member who has been released from prison
	 */
	public void memberReleasedFromPrison(Member member){
	
		//First, change the boss of the former subordinates
		List<Member> subordinates = member.getSubordinates();
		if(subordinates!=null){
			for(Member subordinate: subordinates){
				List<Member> colleagues = subordinate.getBoss().getSubordinates();
				colleagues.remove(subordinate);
				subordinate.setBoss(member);
			}
		}
		
		//Second, recover his position
		Member boss = member.getBoss();
		//The godfather does not have boss
		if(boss!=null){
			addSubordinate(boss, member);
		}
		
		//Last: remove the member of the imprisoned list
		List<Member> list = this.organization.getImprisonedMembers();
		list.remove(member);
		
	}
		
	////////////////////////////////////////
	// AUXILIAR METHODS
	////////////////////////////////////////
	
	
	/**
	 * Add a new subordinate to the list of his boss.
	 * The member is added to the list in order (registration date 
	 * in the organization)
	 * 
	 * @param boss
	 * @param subordinate
	 */
	private void addSubordinate(Member boss, Member member){
		List<Member> subordinates = boss.getSubordinates();
		if(subordinates!=null){
			int position = getPosition(subordinates, member);
			subordinates.add(position, member);
		}
	}
	
	/**
	 * Get the position to insert the member into the list
	 * @param subordinates
	 * @param member
	 * @return
	 */
	private int getPosition(List<Member> subordinates, Member member){
		int index = 0;
		for(index = 0; index<subordinates.size(); index++){
			Member item = subordinates.get(index);
			if(item.getRegistration().compareTo(member.getRegistration())>0){
				break;
			}
		}
		return index;
	}
	
	

}
