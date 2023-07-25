package src.ProgramDemo;

public class User {
    private int id;
    private int accuracy=0;
    private String name;

    public User(String name,int id, int accuracy){
        this.name = name;
        this.id = id;
        this.accuracy = accuracy;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAccuracy(){
        return accuracy;
    }

    
}
