public abstract class Character {

    //attributes for all characters
    public String name;
    public int maxHp, hp, xp;

    //constructer for character
    public Character(String name, int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    //methods for every character
    public abstract int attack();
    public abstract int defend();

}
