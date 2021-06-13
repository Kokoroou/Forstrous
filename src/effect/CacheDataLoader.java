package effect;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import javax.imageio.ImageIO;

/**
 * The CacheDataLoader is the class that store frame and animation of all items and characters
 *
 */
public class CacheDataLoader {
    
    private static CacheDataLoader cachedData = null;
    
    private String framefile = "image/frame.txt";
    private String animationfile = "image/animation.txt";
//    private String physmapfile = "data/phys_map.txt";
//    private String backgroundmapfile = "data/background_map.txt";
//    private String soundfile = "data/sounds.txt";
    
    private Hashtable<String, FrameImage> frameImages; 
    public Hashtable<String, Animation> animations;
//    private Hashtable<String, AudioClip> sounds;
//    
//    private int[][] phys_map;
//    private int[][] background_map;
//    
    private CacheDataLoader() {}

    public static CacheDataLoader getCachedData(){
        if(cachedData == null) {
//        	System.out.println(cachedData == null);
        	cachedData  = new CacheDataLoader();
//        	LoadAnimation();
        }
//        System.out.println(cachedData == null);
        return cachedData;
    }
    
//    public AudioClip getSound(String name){
//        return instance.sounds.get(name);
//    }
    
    public Animation getAnimation(String name) {
//        System.out.println(name);
//        System.out.println(this == null);
        
//        System.out.println(System.getProperty("user.dir"));
    	try {
    		if (animations == null) {
            	LoadAnimation();
            }
    		
//    		Animation animation = new Animation(cachedData.animations.get(name));
    		Animation animation = cachedData.animations.get(name);
//    		System.out.println(animation);
            return animation;
    	}
    	catch (Exception e) {
    		System.out.println(e);
    		return null;
    	}
                
    }
    
    public FrameImage getFrameImage(String name){
    	try {
    		if (frameImages == null) {
            	LoadFrame();
            }
    		FrameImage frameImage = new FrameImage(cachedData.frameImages.get(name));
    		return frameImage;
    	}
    	catch (Exception e) {
    		return null;
    	}

    }
    
//    public int[][] getPhysicalMap(){
//        return instance.phys_map;
//    }
//    
//    public int[][] getBackgroundMap(){
//        return instance.background_map;
//    }
    
    public void LoadData()throws IOException{
        
        LoadFrame();
        LoadAnimation();
//        LoadPhysMap();
//        LoadBackgroundMap();
//        LoadSounds();
        
    }
    
//    public void LoadSounds() throws IOException{
//        sounds = new Hashtable<String, AudioClip>();
//        
//        FileReader fr = new FileReader(soundfile);
//        BufferedReader br = new BufferedReader(fr);
//        
//        String line = null;
//        
//        if(br.readLine()==null) { // no line = "" or something like that
//            System.out.println("No data");
//            throw new IOException();
//        }
//        else {
//            
//            fr = new FileReader(soundfile);
//            br = new BufferedReader(fr);
//            
//            while((line = br.readLine()).equals(""));
//            
//            int n = Integer.parseInt(line);
//            
//            for(int i = 0;i < n; i ++){
//                
//                AudioClip audioClip = null;
//                while((line = br.readLine()).equals(""));
//
//                String[] str = line.split(" ");
//                String name = str[0];
//                
//                String path = str[1];
//
//                try {
//                   audioClip =  Applet.newAudioClip(new URL("file","",str[1]));
//
//                } catch (MalformedURLException ex) {}
//                
//                instance.sounds.put(name, audioClip);
//            }
//            
//        }
//        
//        br.close();
//        
//    }
    
//    public void LoadBackgroundMap() throws IOException{
//        
//        FileReader fr = new FileReader(backgroundmapfile);
//        BufferedReader br = new BufferedReader(fr);
//        
//        String line = null;
//        
//        line = br.readLine();
//        int numberOfRows = Integer.parseInt(line);
//        line = br.readLine();
//        int numberOfColumns = Integer.parseInt(line);
//            
//        
//        instance.background_map = new int[numberOfRows][numberOfColumns];
//        
//        for(int i = 0;i < numberOfRows;i++){
//            line = br.readLine();
//            String [] str = line.split(" |  ");
//            for(int j = 0;j<numberOfColumns;j++)
//                instance.background_map[i][j] = Integer.parseInt(str[j]);
//        }
//        
//        for(int i = 0;i < numberOfRows;i++){
//            
//            for(int j = 0;j<numberOfColumns;j++)
//                System.out.print(" "+instance.background_map[i][j]);
//            
//            System.out.println();
//        }
//        
//        br.close();
//        
//    }
    
//    public void LoadPhysMap() throws IOException{
//        
//        FileReader fr = new FileReader(physmapfile);
//        BufferedReader br = new BufferedReader(fr);
//        
//        String line = null;
//        
//        line = br.readLine();
//        int numberOfRows = Integer.parseInt(line);
//        line = br.readLine();
//        int numberOfColumns = Integer.parseInt(line);
//            
//        
//        instance.phys_map = new int[numberOfRows][numberOfColumns];
//        
//        for(int i = 0;i < numberOfRows;i++){
//            line = br.readLine();
//            String [] str = line.split(" ");
//            for(int j = 0;j<numberOfColumns;j++)
//                instance.phys_map[i][j] = Integer.parseInt(str[j]);
//        }
//        
//        for(int i = 0;i < numberOfRows;i++){
//            
//            for(int j = 0;j<numberOfColumns;j++)
//                System.out.print(" "+instance.phys_map[i][j]);
//            
//            System.out.println();
//        }
//        
//        br.close();
//        
//    }
    public void LoadAnimation() throws IOException {
        
        animations = new Hashtable<String, Animation>();
        
        FileReader fr = new FileReader(animationfile);
        BufferedReader br = new BufferedReader(fr);
        
        String line = null;
        
        if(br.readLine()==null) {
            System.out.println("No data");
            throw new IOException();
        }
        else {
            
            fr = new FileReader(animationfile);
            br = new BufferedReader(fr);
            
            while((line = br.readLine()).equals(""));
            int n = Integer.parseInt(line);
            
            for(int i = 0;i < n; i ++){
                
                Animation animation = new Animation();
                
                while((line = br.readLine()).equals(""));
                animation.setName(line);
                
                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                
                for(int j = 0;j<str.length;j+=2)
                    animation.add(getFrameImage(str[j]), Double.parseDouble(str[j+1]));
                
                cachedData.animations.put(animation.getName(), animation);
                
            }
            
        }
        
        br.close();
    }
    
    public void LoadFrame() throws IOException{
        
        frameImages = new Hashtable<String, FrameImage>();
        
        FileReader fr = new FileReader(framefile);
        BufferedReader br = new BufferedReader(fr);
        
        String line = null;
        
        if(br.readLine()==null) {
            System.out.println("No data");
            throw new IOException();
        }
        else {
            
            fr = new FileReader(framefile);
            br = new BufferedReader(fr);
            
            while((line = br.readLine()).equals(""));
            
            int n = Integer.parseInt(line);
            
            for(int i = 0;i < n; i ++){
                
                FrameImage frame = new FrameImage();
                while((line = br.readLine()).equals(""));
                frame.setName(line);
                
                while((line = br.readLine()).equals(""));
                String[] str = line.split(" ");
                String path = str[1];
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int x = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int y = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int w = Integer.parseInt(str[1]);
                
                while((line = br.readLine()).equals(""));
                str = line.split(" ");
                int h = Integer.parseInt(str[1]);
                
                BufferedImage imageData = ImageIO.read(new File(path));
                BufferedImage image = imageData.getSubimage(x, y, w, h);
                frame.setImage(image);
                
                cachedData.frameImages.put(frame.getName(), frame);
            }
            
        }
        
        br.close();
        
    }
    
}
