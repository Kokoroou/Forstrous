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
    private Hashtable<String, FrameImage> frameImages; 
    public Hashtable<String, Animation> animations;
    
    private CacheDataLoader() {}

    public static CacheDataLoader getCachedData(){
        if(cachedData == null) {
        	cachedData  = new CacheDataLoader();
        }
        return cachedData;
    }
    
    public Animation getAnimation(String name) {
    	try {
    		if (animations == null) {
            	LoadAnimation();
            }
    		Animation animation = cachedData.animations.get(name);
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
    		FrameImage frameImage = cachedData.frameImages.get(name);
    		return frameImage;
    	}
    	catch (Exception e) {
    		return null;
    	}

    }
    
    public void LoadData()throws IOException{
        
        LoadFrame();
        LoadAnimation();    
    }
    
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
            
            for(int i = 0; i < n; i ++){
                
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
