package effect;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The Animation is the class that draws moving animation of Characters.
 *
 */
public class Animation {
    public String name;
    
    private boolean isRepeated;
    
    public ArrayList<FrameImage> frameImages;
    public int currentFrame;
    
    public ArrayList<Double> delayFrames;
    public long beginTime;

    private boolean drawRectFrame;
    
    public Animation(){
        delayFrames = new ArrayList<Double>();
        beginTime = 0;
        currentFrame = 0;
        
        frameImages = new ArrayList<FrameImage>();
        
        drawRectFrame = false;
        
        isRepeated = true;
    }
    
    public void setIsRepeated(boolean isRepeated){
        this.isRepeated = isRepeated;
    }
    
    public boolean getIsRepeated(){
        return isRepeated;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setCurrentFrame(int currentFrame){
        if(currentFrame >= 0 && currentFrame < frameImages.size())
            this.currentFrame = currentFrame;
        else this.currentFrame = 0;
    }
    public int getCurrentFrame(){
        return this.currentFrame;
    }
    
    public void reset(){
        currentFrame = 0;
        beginTime = 0;
    }
    
    public void add(FrameImage frameImage, double timeToNextFrame){

        frameImages.add(frameImage);
        delayFrames.add(new Double(timeToNextFrame));
        
    }
    
    public void setDrawRectFrame(boolean b){
        drawRectFrame = b;
    }

    
    public BufferedImage getCurrentImage(){
        return frameImages.get(currentFrame).getImage();
    }
    
    public void Update(long deltaTime) {
        if(beginTime == 0) beginTime = deltaTime;
        else{
            if(deltaTime - beginTime > delayFrames.get(currentFrame)){
                nextFrame();
                beginTime = deltaTime;
            }
        }
        
    }

    public boolean isLastFrame(){
        if(currentFrame == frameImages.size() - 1)
            return true;
        else return false;
    }
    
    private void nextFrame(){
        
        if(currentFrame >= frameImages.size() - 1){
            
            if(isRepeated) currentFrame = 0;
        }
        else currentFrame++;
        
    }
    
    public void draw(int x, int y, Graphics2D g2){
        BufferedImage image = getCurrentImage();
        g2.drawImage(image, x, y, null);
        if(drawRectFrame) {
        	g2.drawRect(x, x, image.getWidth(), image.getHeight());
        }
    }   
}