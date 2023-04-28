import java.util.Scanner;
public class GameLogic {
    static Scanner scnr = new Scanner(System.in);

    static Player player;
    public static boolean isRunning;

    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
    public static String[] enemies = {"501st Clone Trooper", "321st Commander", "105th Captain", "111th Clone Trooper"};

    //method to calculate a random encounter
    public static void randomEncounter(){
        int encounter = (int) (Math.random()*encounters.length);
        if(encounters[encounter].equals("Battle")){
            randomBattle();
        }else if (encounters[encounter].equals("Rest")){
            takeRest();
        }else {shop();
        }
    }
    

    //story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Training Room", "HallWay", "Library", "High Council Chamber", "Youngling Training Room"};

    //method to get user input from console
    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scnr.next());
            } catch(Exception e) {
                input = -1;
                System.out.println("Please select a number!");
            }
        } while(input < 1 || input > userChoices);
        return input;
    }
    //method to clear console
    public static void clearConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    public static void finalBattle(){
        battle(new Enemy("ANAKIN SKYWALKER", 10000));
        Story.printEnd();
    }

    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Do you want to rest? People are counting on you.");
            System.out.println("(1)Yes, I am a lazy coward.\n(2) NO. I am strong like Master Windu believes me to be.");
            int input = readInt("->", 2);
            if (input ==1){
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1)+ 10);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp){
                        player.hp = player.maxHp;
                    System.out.println("Its time to move. You have healed enough.");
                    player.restsLeft--;
                    anythingToContinue();
                    } else {
                        System.out.println("You are at full health. You do not need rest.");
                        anythingToContinue();
                    }
                }
            }
        }
    }

    public static void shop(){
        clearConsole();
        printHeading("Would you like to purchase anything for your journey ahead?");
        int price = (int) (Math.random()*(10 + player.forceAbilities*3) + 10 + player.forceAbilities);
        System.out.println("- Force Ability: " + price + " gold");
        printSeperator(30);
        System.out.println("Would you like to purchase one?\n(1) Yes.\n(2) Maybe later.");
        int input = readInt("->", 2);
        if (input == 1){
            clearConsole();
            if (player.gold >= price){
                printHeading("You have bought a force ability. May the force be with you.");
                player.forceAbilities++;
                player.gold = player.gold - price;
                anythingToContinue();
            } else {
                printHeading("You do not have the necessary funds to purchase this.");
                anythingToContinue();
            }
        }

    }

    //method to print seperator with n length
    public static void printSeperator (int n){
        for (int i = 0; i < n; i++)
        System.out.print("-");
        System.out.println();
    }
    //method to print heading
    public static void printHeading(String title){
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue...");
        scnr.next();
    }
    //method to begin game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        
        //pint title screen
        clearConsole();

        printSeperator(40);
        printSeperator(30);
        System.out.println("STAR WARS: ESCAPE FROM ORDER 66");
        System.out.println("TEXT RPG MADE BY SEAN ERICSON FOR FINAL PROJECT");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        //getting player name
        do{
            clearConsole();
            printHeading("What is your name Padawan?");
            name = scnr.next();
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct? ");
            System.out.println("(1) Yes!\n(2) No, my name is...");
            int input = readInt("-> ", 2);
            if(input == 1){
                nameSet = true;
            }

        }while(!nameSet);

        Story.printIntro();
        //create new player object 
        player = new Player(name);

        Story.printFirstActIntro();

        isRunning = true;
        //start the main game
        gameLoop();
    }

    //method that makes sure you arent in last act
    public static void checkAct(){
        //change acts based on xp
        if(player.xp >= 10 && act == 1){
            act = 2;
            place = 1;
            Story.printFirstActOutro();
            player.chooseTrait();
            Story.printSecondActIntro();
            enemies[0] = "111th Clone Trooper";
            enemies[1] = "111th Clone Trooper";
            enemies[2] = "111th Clone Trooper";
            enemies[3] = "501st Clone Trooper";
            //new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Battle";
            //heal player
            player.hp = player.maxHp;
        }else if(player.xp >= 50 && act ==2){
            act = 3;
            place = 2;
            Story.printSecondActOutro();
            player.chooseTrait();
            Story.printThirdActIntro();
            enemies[0] = "501st Clone Trooper";
            enemies[1] = "501st Clone Trooper";
            enemies[2] = "321st Commander";
            enemies[3] = "105th Captain";
            //new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Rest";
            encounters[3] = "Battle";
            //heal player
            player.hp = player.maxHp;
        }else if(player.xp >= 100 && act == 3){
            act =4;
            place = 3;
            Story.printThirdActOutro();
            player.chooseTrait();
            Story.printFourthActIntro();
           
            //heal player
            player.hp = player.maxHp;
            //final boss!!!
            finalBattle();
        }
    }
    //method to continue journey
    public static void continueJourney(){
        checkAct();
        if(act != 4)
        randomEncounter();
    }
    //character info
    public static void characterInfo(){
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperator(20);
        System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
        printSeperator(20);
        //# of force moves available
        System.out.println("# of force abilities: " + player.forceAbilities);
        printSeperator(20);

        if(player.numAtkUpgrades > 0){
            System.out.println("Offensive traits: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperator(20);
        }
        if (player.numDefUpgrades > 0){
            System.out.println("Defensive traits: "+ player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }
    //print main menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action: ");
        printSeperator(20);
        System.out.println("(1) Continue on your journey\n(2) Character Info\n(3) Exit Game");
    }
    //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1)
                continueJourney();
            else if (input ==2)
                characterInfo();
            else
                isRunning = false;
        }
    }

    public static void randomBattle(){
        clearConsole();
        printHeading("You have been seen!");
        anythingToContinue();
        //creating new enemy wiht random name
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)],player.xp));
    }

    public static void playerDied(){
        clearConsole();
        printHeading("DEAD");
        printHeading("You earned " + player.xp + " XP on your journey. It still wasn't enough.");
        isRunning = false;
        System.exit(0);
        
    }

    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printSeperator(20);
            System.out.println("(1) Lightsaber\n(2) Force\n(3) Run.");
            int input = readInt("-> ", 3);
            if (input == 1){
                int dmg = player.attack();
                int dmgTook = enemy.attack();
                if (dmgTook < 0){
                    dmg -= dmgTook/2;
                } if (dmg > 0){
                    dmg = player.attack();

                    player.hp =  player.hp - dmgTook;
                    enemy.hp = enemy.hp - dmg;
                    

                    clearConsole();
                    printHeading("BATTLE");
                    System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                    printSeperator(20);
                    System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you!");
                    anythingToContinue();

                    //check if dead
                    
                    if(enemy.hp <= 0){
                        clearConsole();
                        printHeading("You defeated the " + enemy.name + "!");
                        //increase xp
                        player.xp += enemy.xp * 10;
                        System.out.println("You earned " + enemy.xp + "XP!");

                        boolean addRest = (Math.random()*5 + 1 <= 2.25);
                        int goldEarned = (int) (Math.random()*enemy.xp);
                        if (addRest){
                            player.restsLeft++;
                            System.out.println("You have a small chance to rest.");
                        }
                        if(goldEarned > 0){
                            player.gold += goldEarned;
                        }
                        anythingToContinue();
                    
                        break;
                    }
                    else if(player.hp <=0){
                        playerDied();
                    }
                }
            }else if (input == 2){
                clearConsole();
                if(player.forceAbilities > 0 && player.hp < player.maxHp){
                    printHeading("Do you want to use one of your healing abilities (" + player.forceAbilities + " left)?");
                    System.out.println("(1) Yes\n(2) No, perhaps later");
                    readInt("->", 2);
                    if(input == 1){
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You took a moment to calm yourself with the force. You have healed in the process. Continue on Padawan.");
                        anythingToContinue();
                    }

                }else {
                    printHeading("You have no force abilities available.");
                    anythingToContinue();
                    }
            }else{
                clearConsole();
            if (act != 4){
                if(Math.random() * 10 + 1 <= 4.5){
                    printHeading("You ran away. Master Windu would be ashamed.");
                    anythingToContinue();
                    break;
                }else{
                    printHeading("You did not escape. Coward.");
                    int dmgTook = enemy.attack();
                    System.out.println(enemy.name + " caught up to you. You have taken " + dmgTook + " damage.");
                    anythingToContinue();

                    if (player.hp <= 0){
                        playerDied();
                    }
                }
            }
            else{
                printHeading("Master Skywalker will not allow you to leave.");
                anythingToContinue();
            }
        }
        }
    }
    }
    

