package br.com.brainweb.interview.model.request;

import static lombok.AccessLevel.PRIVATE;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.brainweb.interview.model.enums.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = PRIVATE)
public class CreateHeroRequest {

    @NotBlank(message = "message.name.mandatory")
    @Length(min = 1, max = 255, message = "message.name.length")
    private String name;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "message.race.mandatory")
    private Race race;
	
	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

    @Min(value = 0, message = "message.powerstats.strength.min")
    @Max(value = 10, message = "message.powerstats.strength.max")
    @NotNull(message = "message.powerstats.strength.mandatory")
    private int strength;
    
    public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}


    @Min(value = 0, message = "message.powerstats.agility.min")
    @Max(value = 10, message = "message.powerstats.agility.max")
    @NotNull(message = "message.powerstats.agility.mandatory")
    private int agility;
    
    public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

    @Min(value = 0, message = "message.powerstats.dexterity.min")
    @Max(value = 10, message = "message.powerstats.dexterity.max")
    @NotNull(message = "message.powerstats.dexterity.mandatory")
    private int dexterity;
    
    public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

    @Min(value = 0, message = "message.powerstats.intelligence.min")
    @Max(value = 10, message = "message.powerstats.intelligence.max")
    @NotNull(message = "message.powerstats.intelligence.mandatory")
    private int intelligence;
    

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
}
