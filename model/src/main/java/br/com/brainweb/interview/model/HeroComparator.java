package br.com.brainweb.interview.model;

import java.util.UUID;

public class HeroComparator {

	int strengthComparation;
	int agilityComparation;
	int dexterityComparation;
	int intelligenceComparation;
	
	public void compare(Hero hero1, Hero hero2) {
		
		HeroComparator heroComparator = comparator(hero1, hero2);
		
		System.out.println("=== Comparação entre os Heróis ===");
		System.out.println(hero1.getName() + " X " + hero2.getName());
		System.out.println("==================================");
		
		if (heroComparator.strengthComparation < 0) {
			System.out.println("O Heroi " + hero2.getName() + "possui mais força.");
		} else {
			System.out.println("O Heroi " + hero1.getName() + "possui mais força.");
		}
		
		if (heroComparator.agilityComparation < 0) {
			System.out.println("O Heroi " + hero2.getName() + "possui mais agilidade.");
		} else {
			System.out.println("O Heroi " + hero1.getName() + "possui mais agilidade.");
		}
		
		if (heroComparator.dexterityComparation < 0) {
			System.out.println("O Heroi " + hero2.getName() + "possui mais destreza.");
		} else {
			System.out.println("O Heroi " + hero1.getName() + "possui mais destreza.");
		}
		
		if (heroComparator.intelligenceComparation < 0) {
			System.out.println("O Heroi " + hero2.getName() + "possui mais inteligencia.");
		} else {
			System.out.println("O Heroi " + hero1.getName() + "possui mais inteligencia.");
		}
		
	}
	
	@SuppressWarnings("null")
	private HeroComparator comparator(Hero hero1, Hero hero2) {
		
		HeroComparator heroComparator = null;
				
		UUID powerStatsIDHero1 = hero1.getPowerStatsId();
		UUID powerStatsIDHero2 = hero2.getPowerStatsId();
		
		//Busca as estatisticas dos dois herois
		PowerStats powerStatsHero1 = null;
		PowerStats powerStatsHero2 = null;
		
		//Realiza as comparações
		setComparationResults(heroComparator, powerStatsHero1.getStrength(), 
				powerStatsHero2.getStrength(), "strengthComparation");
		
		setComparationResults(heroComparator, powerStatsHero1.getAgility(), 
				powerStatsHero2.getAgility(), "agilityComparation");
		
		setComparationResults(heroComparator, powerStatsHero1.getDexterity(), 
				powerStatsHero2.getDexterity(), "dexterityComparation");
		
		setComparationResults(heroComparator, powerStatsHero1.getIntelligence(), 
				powerStatsHero2.getIntelligence(), "intelligenceComparation");
		
		return heroComparator;
	}

	/**
	 * Realiza a conta para montar o resultado das comparações
	 * @param power1
	 * @param power2
	 * @param fieldName
	 */
	private void setComparationResults(HeroComparator heroComparator, int power1, int power2, String fieldName) {
			int comparationResult = power1 - power2;
			setResult(heroComparator, comparationResult, fieldName);
	}

	/***
	 * Seta o resultado das comparações nas variáveis
	 * @param comparationResult
	 * @param fieldName
	 */
	private void setResult(HeroComparator heroComparator, int comparationResult, String fieldName) {
	
		if(fieldName.equals("strengthComparation")) {
			heroComparator.strengthComparation = comparationResult;
		}
		
		if(fieldName.equals("agilityComparation")) {
			heroComparator.agilityComparation = comparationResult;
		}
		
		if(fieldName.equals("dexterityComparation")) {
			heroComparator.dexterityComparation = comparationResult;
		}
		
		if(fieldName.equals("intelligenceComparation")) {
			heroComparator.intelligenceComparation = comparationResult;
		}		
	}
}
