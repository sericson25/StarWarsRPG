default: Character.java Enemy.java Main.java GameLogic.java Player.java Story.java
	javac Character.java Enemy.java Main.java GameLogic.java Player.java Story.java

run: Character.class Enemy.class Main.class GameLogic.class	Player.class Story.class
	java Main

clean:
	rm -f *.class