public class Enemy extends Character{
    int playerXp;

    //enemy constructer
    public Enemy(String name, int playerXp){
        super(name,(int) (Math.random()*playerXp + playerXp/3+5), (int) (Math.random()*(playerXp/4+2)+1));
        //assign variable
        this.playerXp = playerXp;
    }

    public int attack(){
        return (int) (Math.random() * (playerXp / 4+1) + xp/4 + 3);
    }
    
    public int defend(){
        return (int) (Math.random() * (playerXp / 4+1) + xp/4 + 3);
    }
}
