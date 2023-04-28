public class Player extends Character{

    //Integers to store # of upgrades/skills

    public int numAtkUpgrades, numDefUpgrades;
    public int gold, restsLeft, forceAbilities;
    
    public String[] atkUpgrades = {"Force Abilities", "LightSaber Abilities", "Speed", "Intelligence"};
    public String[] defUpgrades = {"LightSaber Defense", "Force Defence", "Endurance", "Scale Armor"};
    //player specific
    public Player(String name){
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        this.gold = 5;
        this.restsLeft = 1;
        this.forceAbilities = 5;

        //let player choose trait when creating character
        chooseTrait();
    }



    
    public int attack(){
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 +3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }
    
    public int defend(){
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 +3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    //let player choose trait
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("-> ", 2);

        //deal with both choices
        if(input == 1){
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
        
    }

}