import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends World
{

    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        GreenfootImage background = getBackground();//Create Image
        background.setColor(new Color(33,13,64));//Add Background color
        background.fillRect(0,0,getWidth(),getHeight());
        
        
        // Add the stars
        for (int i = 0; i < 300; i++) {
            Star star = new Star();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(star,x,y);
        }
        
        // Add the Logo
        Logo logo = new Logo();
        addObject(logo,getWidth()/2,getHeight()/2);
        
        
        // Display the Red and Blue pills to allow user to select (Red starts game, blue restarts title sequence).
        Red red = new Red();
        Blue blue = new Blue();
        
        addObject(red,300,500);
        addObject(blue,500,520);
    }
}
