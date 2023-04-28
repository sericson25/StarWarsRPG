public class Story {
    //class that does nothing but store methods to print out the whole story

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("It's been hours. Master Windu told you to wait in in the training room while he went to arrest the chancelor");
        System.out.println("You have only been his Padawan for a year, but the knowledge he has gifted you has been invaluable");
        System.out.println("A sharp pain pierces your heart as you hear thousands of voices shut out in an instant\nSomething is wrong in the force.");
        System.out.println("You walk over to the window overlooking the launch pad to see the Clones firing shots at your fellow Padawans");
        System.out.println("Why are they doing this?\n You have no choice but to take action\nYou don your hood, gripping your saber as you walk towards the door into an unknown hell");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("You slowly open the door as you listen for any footsteps coming your way");
        System.out.println("You hear the fighting all around you as your heart begins to pound");
        System.out.println("You move through the hallways hoping to not be seen");
        System.out.println("You approach the door to the High Council Chamber");
        System.out.println("Suddenly you hear the sounds of another Jedi struggling to the sound of a blaster firing");
        System.out.println("You open the door");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("The other Jedi didn't make it");
        System.out.println("You cover their face out of respect\n Why are the clones turning against us?");
        System.out.println("You leave the High Council Chamber, Yearning for the force to guide you");
        System.out.println("You have gained XP to learn another trait.");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("You sneak past multiple troops of clones as you make your way towards the library");
        System.out.println("You travel through the temple witnessing the bloodshed of an ultimate betrayel");
        System.out.println("You reach the Library, seeing the Librarian face flat. Unmoving. She was too king for such a fate.");
        System.out.println("You enter the slightly cracked door to see what is ahead of you");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("Master Windu's training is the only thing keeping me alive.");
        System.out.println("I hope I will get to see him again. He would know what to do.");
        System.out.println("You leave the library\n Something in the force has shifted.");
        System.out.println("A crushing feeling encompasses your whole body. Is this the dark side?");
        System.out.println("A realization hits you... the younglings");
        System.out.println("You sprint to go find them");
        System.out.println("You have gained XP to learn another trait.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("You leave the library, it's crucial you help the younglings");
        System.out.println("The closer you get to the Younglings training room, the larger presence of evil you feel");
        System.out.println("You get closer to the door when you see Master Anakin approaching the same door");
        System.out.println("You let out a sigh of relief, Master Anakin can take care of all of these clones by himself.");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("You edge towards the door to see what is going on");
        System.out.println("You hear a youngling pleading to Master Skywalker");
        System.out.println("Master Skywalker, there are too many of them! What are we going to do?");
        System.out.println("You hear the ignition of a lightsaber, what could he be doing?");
        System.out.println("You have gained XP for another trait. You will need it.");
        GameLogic.anythingToContinue();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("You can't believe it.\nMaster Skywalker has just murdered the younglings.");
        System.out.println("What are you to do?");
        System.out.println("His head snaps back, he has sensed you.");
        System.out.println("Frozen in fear he locks eyes with you.\nThey are a deep, disgusting yellow.");
        GameLogic.printHeading("FINAL BOSS: ANAKIN SKYWALKER");
        GameLogic.anythingToContinue();
        
    }

    public static void printEnd(){
        GameLogic.clearConsole();
        GameLogic.printSeperator(30);
        System.out.println("DEAD.");
        System.out.println("Thank you for playing!");
    }
}
