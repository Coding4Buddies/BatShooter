<h4 align=center>
    <img src="https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/main_screen/logo.png?raw=true" width="600">
    <br>
    <a href="https://github.com/Coding4Buddies/BatShooter/releases/download/v.1.0/BatShooter.v.1.0.rar">
    	<img alt="Download" src="https://img.shields.io/static/v1?label=Download&message=Jar&logoColor=white&color=yellow&style=for-the-badge">
    </a>
    <img alt="Version" src="https://img.shields.io/static/v1?label=Version&message=1.0&logoColor=white&color=yellow&style=for-the-badge">
    <br><br>
    Our <b>Task Performance</b> in First Semester Finals in both Computer Programming, Human Computer Interaction and Data Structure. We made our best in making the TP more interesting and enjoyable by adding more graphics and music.  
</h4>

## **Run the Program** 📜
 To run the program, the device must have:
 - Java JDK (Used JDK version 11.0.8)
 - IDE (Netbeans, Eclipse, Intellj)

## **Instruction of the Game** 📚
1. Click the Play button
2. Choose any level you want you play
3. At the gameplay you should kill all the bats to proceed again to choose any level
4. Every level has a different bats and different health
5. If bats are all killed a 'Congrats' message will appear at your screen.
6. And after that you will choose 'Play Again' or 'Back to Menu'
7. Play Again if you want to proceed to another level and Back to Menu if you want to exit the game.

## **Bat Stats** 🦇
We make the name of each bat related on the name of the vaccines and also Our Lead Designer design these Bats GIF!!
|      Image                                                                                | Name              | Health        | Speed X        | Speed Y     | 
| :---:                                                                                     | :----:            | :---:         |:---:           | :---:       |
| ![PfiBat](https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/PfiBat.gif)       | PfiBat            | 100           |1               | 1           |
| ![SputBat](https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/SputBat.gif)     | SputBat           | 150           |2               | 3           |
| ![ModernBat](https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/ModernBat.gif) | ModernBat         | 200           |3               | 2           |
| ![SinoBat](https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/SinoBat.gif)     | SinoBat           | 250           |3               | 3           |
| ![CoBat](https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/CoBat.gif)         | CoBat             | 300           |4               | 4           |



## **Level System** ☝️
The number of bats that are present in the game is based on the data inside the LevelJSON.json File. You can change these data inside and will affect the bats that are present in each level.
```
{
    "level 1": {
        "BgImage": "res/FBackground.jpeg",
        "PfiBat" : "10",
        "SputBat" : "0",
        "ModernBat" : "0",
        "SinoBat" : "0",
        "CoBat" : "0"
    },
    
    "level 2": {
        "BgImage": "res/FBackground.jpeg",
        "PfiBat" : "0",
        "SputBat" : "10",
        "ModernBat" : "0",
        "SinoBat" : "0",
        "CoBat" : "0"
    },
    
    "level 3": {
        "BgImage": "res/FBackground.jpeg",
        "PfiBat" : "0",
        "SputBat" : "0",
        "ModernBat" : "10",
        "SinoBat" : "0",
        "CoBat" : "0"
    },
    
    "level 4": {
        "BgImage": "res/SBackground.jpeg",
        "PfiBat" : "0",
        "SputBat" : "0",
        "ModernBat" : "0",
        "SinoBat" : "10",
        "CoBat" : "0"
    },
    
    "level 5": {
        "BgImage": "res/SBackground.jpeg",
        "PfiBat" : "0",
        "SputBat" : "0",
        "ModernBat" : "0",
        "SinoBat" : "0",
        "CoBat" : "10"
    },
    
    "level 6": {
        "BgImage": "res/SBackground.jpeg",
        "PfiBat" : "2",
        "SputBat" : "2",
        "ModernBat" : "2",
        "SinoBat" : "2",
        "CoBat" : "2"
    },
    
    "level 7": {
        "BgImage": "res/LBackground.jpg",
        "PfiBat" : "1",
        "SputBat" : "4",
        "ModernBat" : "2",
        "SinoBat" : "2",
        "CoBat" : "2"
    },
    
    "level 8": {
        "BgImage": "res/LBackground.jpg",
        "PfiBat" : "0",
        "SputBat" : "1",
        "ModernBat" : "2",
        "SinoBat" : "5",
        "CoBat" : "2"
    },
    
    "level 9": {
        "BgImage": "res/LBackground.jpg",
        "PfiBat" : "0",
        "SputBat" : "0",
        "ModernBat" : "2",
        "SinoBat" : "2",
        "CoBat" : "6"
    }
}
```
`Take Note: Follow on how the File is formatted and once you input something wrong, the program will surely crash. Ps. Didnt put Try and Catch in that line of code`

## **Application of Data Structure in the Game** 💾
In the game, we used two ADT. One is a Linked List, which is responsible for storing, displaying and removing the bats in the game, and the other is a linked hash map, which is used to read the JSON file mentioned above.

   ### Linked List (PlayPanel.java)
   ```
    LinkedList<Bat> batList = new LinkedList<>();
   ```
   ```
    // Method that insert the bats in the LinkedList based on the JSON file
    public void addBats(){
        IntStream.range(0, Integer.parseInt((String) batReference.get("PfiBat"))).forEach(i -> batList.add(new PfiBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SputBat"))).forEach(i -> batList.add(new SputBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("ModernBat"))).forEach(i -> batList.add(new ModernBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SinoBat"))).forEach(i -> batList.add(new SinoBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("CoBat"))).forEach(i -> batList.add(new CoBat()));
    }
   ```
   ```
    // Shows/Paints the bat based on the number inside the batList Linked List
    for(Bat bat: batList) {
        bat.paint(g2d);
        move(bat);
        
        if (!isClick) {
            clickBat(bat);
            if (bat == batList.getLast()) {
                isClick = true;
            }
        }
        repaint();
    }
   ```
   ```
   // Remove the Bats from Linked List when health reach to 0 or negative
   if(bats.getHealth() <= 0){
      batList.remove(bats);
   }
   ```
   ### Linked Hash Map (LevelSystem, LevelPanel, PlayPanel)
   ```
   // Uses Dependecy to Get the Data in JSON File and Store inside the Level Map
   Map<String, Object> level;
      
   public LevelSystem() {
    try {  
        ObjectMapper mapper = new ObjectMapper(); 
        fileObj = new File("data/LevelJSON.json");
        level = mapper.readValue(fileObj, new TypeReference<Map<String, Object>>(){}); 
    } catch (Exception e) {  
        e.printStackTrace();
    }
   }
   ```
   ```
    // Passed the Linked Hash Map from Level Panel to Play Panel to Make the Panel Dynamic
    LinkedHashMap<String, Object> numBats = new ObjectMapper().convertValue(
                levelSystem.getLevel().get(jlabel.getText()), LinkedHashMap.class);
    mainScreen.showView(new PlayPanel(mainScreen, numBats));
   ```
   ```
    // Initialize LinkedHashMap
    LinkedHashMap<String, Object> batReference;
    
    // Get the Data from the Level Panel and put it in the initialize Linked Hash Map of the Play Panel
    public PlayPanel(MainScreen gameFrame, LinkedHashMap<String, Object> batReference){
        this.batReference = batReference;
    }
    
    // Get the Number of Bats in JSON file and insert to the Linked List
    public void addBats(){
        IntStream.range(0, Integer.parseInt((String) batReference.get("PfiBat"))).forEach(i -> batList.add(new PfiBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SputBat"))).forEach(i -> batList.add(new SputBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("ModernBat"))).forEach(i -> batList.add(new ModernBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("SinoBat"))).forEach(i -> batList.add(new SinoBat()));
        IntStream.range(0, Integer.parseInt((String) batReference.get("CoBat"))).forEach(i -> batList.add(new CoBat()));
    }
    
    // Get the BgImage key in JSON and Set in the Play Panel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image i = new ImageIcon((String) batReference.get("BgImage")).getImage();
        g.drawImage(i,0,0, width, height, null);
    }
   ```
## **Application of Object Oriented in the Game**
Since there are 5 bats in the game that shares the same attributes and methods, we create a Bat parent class to handle this.
```
+-- Bat (Parent Class)
|   +-- PfiBat      
|   +-- SputBat 
|   +-- ModernBat
|   +-- SinoBat
|   +-- CoBat

```

Here are the attributes and methods for the Bat Parent Class

```
public class Bat {
    private int w = 1080, h = 720;
    private Point location, speed;
    private Image image;
    private int health, max_health;
    private Color healthBar;
    private String sound;

    public Bat() { 
        this.location = new Point(random(w - 200), random(h - 200));
    }
    
    public int random(int i) {
        return (int) Math.round(Math.random() * i);
    }
    
    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getLocation() {
        return location;
    }

    public Point getSpeed() {
        return speed;
    }

    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMax_health() {
        return max_health;
    }
    
    public void setMax_health(int max_health) {
        this.max_health = max_health;
    }
    
    public Color getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(Color healthBar) {
        this.healthBar = healthBar;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void createHealthBar(Graphics2D g, Bat bat) {
        Point p = bat.getLocation();
        g.setColor(getHealthBar());
        g.fillRect(p.x + 28, p.y + 145, (100 * bat.getHealth()) / bat.getMax_health(), 5);
        g.drawRect(p.x + 28, p.y + 145, 100, 5);
    }

    public void paint(Graphics2D g) {
        Point p = getLocation();
        if(p != null) {
            g.drawImage(getImage(), p.x, p.y, null);
            createHealthBar(g, this);
        }
    }
}

```

## **Application of Computer Programming and HCI in the Game** ☀️
We combined the lessons we learn from the HCI course on how to create the design and Computer Programming to bring the design to life.
<p float="center">
	<img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/1.png" width="400">
	<img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/2.png" width="400">
    <img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/3.png" width="400">
    <img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/4.png" width="400">
    <img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/5.png" width="400">
    <img src = "https://github.com/Coding4Buddies/BatShooter-Assets/blob/main/screen_shot/6.png" width="400">
</p>

## **Video Presentation** 🎥
Here is the video link of our Game: <a href="https://github.com/Coding4Buddies/BatShooter-Assets/raw/main/video_presentation/Bat%20Shooter%20Video1.m4v">Bat Shooter Presentation</a>

## **Members** 🧑🏻‍🤝‍🧑🏻
|                                                                                           | Username                                     | Position         |  
| :---:                                                                                     | :----:                                       |:----:            | 
| ![Jookie262](https://avatars.githubusercontent.com/u/62915062?s=70&v=4)                   | [Jookie262](https://github.com/Jookie262)    |Lead Programmer   | 
| ![Jazzy](https://avatars.githubusercontent.com/u/92165870?s=70&v=4)                       | [Jazzy](https://github.com/jazzy-bella)      |Lead Designer     |
| ![MinPen](https://avatars.githubusercontent.com/u/93776264?s=70&v=4)                      | [MinPen](https://github.com/nickichann01)    |Graphics          |
| ![OmiAtsu](https://avatars.githubusercontent.com/u/98083930?s=70&v=4)                     | [OmiAtsu](https://github.com/OmiAtsu)        |Tester            |

## **Disclaimer** ✨
The background music and graphics are not our property. We credited it to the rightful owner. Only for Educational Purposes.

## **Contribution** 🔥
If you wish to help improve this project, fork this repo and submit your own pull request. If you discover a problem with this project, please report it to the issue page. Thank you very much   😊.

## **Thank you** 💖
If you like this project just click ⭐ and share it with others.
