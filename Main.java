import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * This is where the main gameplay takes place,
 * 
 * @author Bryson Lee-Kwen
 * @version 2023-01-15
 */
public class Main extends World
{

    /**
     * Constructor for objects of class Main.
     * 
     */
    public boolean respawn = false;
    public boolean gates = true;
    public int worldSpeed = 3;
    public int playerSpeed = 4;
    public Main()
    {    
        super(400, 600, 1);
        prepare();
        
    }
    
    
    public void respawn() {
        
        
        for(int i =0; i < 3;i++){
            Gate gate = getObjects(Gate.class).get(0);
            gate.removeLabel();
            removeObject(gate);
        }
        
        
        
        spawnGates();
        
    }
    public void add(int n) {
        getObjects(Player.class).get(0).value += n;
        respawn();
    }
    
    public void minus(int n) {
        getObjects(Player.class).get(0).value -= n;
        respawn();
    }
    public void multiply(int n) {
        getObjects(Player.class).get(0).value *= n;
        respawn();
    }
    public void divide(int n) {
        getObjects(Player.class).get(0).value /= n;
        respawn();
    }
    public int getGate(){
        return Greenfoot.getRandomNumber(4);
    }
    
    public void spawnGates() {
        for(int i = 0; i < 3;i++ ){
            
            if (getGate() == 0){
                MinusGate gate = new MinusGate();
                addObject(gate,75 + (125*i),75);
            }
            else if (getGate() == 1){
                PlusGate gate = new PlusGate();
                addObject(gate,75 + (125*i),75);
            }
            else if (getGate() == 2){
                MultiplyGate gate = new MultiplyGate();
                addObject(gate,75 + (125*i),75);
            }
            else{
                DivideGate gate = new DivideGate();
                addObject(gate,75 + (125*i),75);
            }
            
            
        }
    }
    public void prepare() {
        // Set Background to complete darkness.
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);//Add Background color
        background.fillRect(0,0,getWidth(),getHeight());
        
        
        // Spawn in the player.
        Player player = new Player(20,this.playerSpeed);
        addObject(player,getWidth()/2,getHeight()-75);
        
        
        // Add the stars
        for (int i = 0; i < 300; i++) {
            Star star = new Star();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(star,x,y);
        }
        // Add the gates
        spawnGates();
        
        // Play background music
        GreenfootSound music = new GreenfootSound("winter.mp3");
        music.playLoop();
        
    
   
    }
    
    public void act() {

    }
}
