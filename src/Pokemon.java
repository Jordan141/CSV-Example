public class Pokemon {
    // Member fields

	private int number;
	private String name; 
	private String typeOne; 
	private String typeTwo; 
	private int total; 
	private int HP; 
	private int attack; 
	private int defense; 
	private int specialAttack; 
	private int specialDefense; 
	private int speed; 
	private int generation; 
	private boolean Legendary;
	
	// Different constructor with all parameters set to the member fields 
	
	public Pokemon(String ... attributes) {
		super();
		
        if(attributes.length == 0) throw new java.lang.Error("Attributes cannot be empty");
	
		this.number = Integer.parseInt(attributes[0]);
		this.name = attributes[1];
		this.typeOne = attributes[2];
		this.typeTwo = attributes[3].length() > 1 ? attributes[3] : "None";
		this.total = Integer.parseInt(attributes[4]);
		this.HP = Integer.parseInt(attributes[5]);
		this.attack = Integer.parseInt(attributes[6]);
		this.defense = Integer.parseInt(attributes[7]);
		this.specialAttack = Integer.parseInt(attributes[8]);
		this.specialDefense = Integer.parseInt(attributes[9]);
		this.speed = Integer.parseInt(attributes[10]);
		this.generation = Integer.parseInt(attributes[11]);
		this.Legendary = Boolean.valueOf(attributes[12]);
	}

	// Setters and getters, all public although setters should usually be private
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOne() {
		return typeOne;
	}

	public void setTypeOne(String typeOne) {
		this.typeOne = typeOne;
	}

	public String getTypeTwo() {
		return typeTwo;
	}

	public void setTypeTwo(String typeTwo) {
		this.typeTwo = typeTwo;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense) {
		this.specialDefense = specialDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public boolean isLegendary() {
		return Legendary;
	}

	public void setLegendary(boolean legendary) {
		Legendary = legendary;
	}
	public String toCSV() {
		return "" + this.getName() + ","
				+ this.getTypeOne() + ","
				+ this.getTypeTwo() + ","
				+ this.getTotal() + ","
				+ this.getHP() + ","
				+ this.getAttack() + ","
				+ this.getDefense() + ","
				+ this.getSpecialAttack() + ","
				+ this.getSpecialDefense() + ","
				+ this.getSpeed() + ","
				+ this.getGeneration() + ","
				+ this.isLegendary();
	}
	@Override
	public String toString() {
		return this.name;
	}
}