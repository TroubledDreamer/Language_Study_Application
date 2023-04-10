package Scr;

public class User {
    private int id;
    private int score;
    private int accuracy=0;

    public User(String name,int id,int score, int accuracy){
        this.name = name;
        this.id = id;
        this.score = score;
        this.accuracy = accuracy;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int score(){
        return score;
    }
    public int getAccuracy(){
        return accuracy;
    }

    
}
