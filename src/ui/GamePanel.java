package com.kdat.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.kdat.effect.*;
import com.kdat.object.*;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	private Thread thread;
	private boolean isRunning;
	private InputManager inputManager;
	private BufferedImage bufImage;
	private Graphics2D bufG2D;
	private GameWorld gameWorld;
	
	public GamePanel() {
		gameWorld = new GameWorld();
		inputManager = new InputManager(gameWorld);
		bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	}
	
	@Override
	public void paint (Graphics g) {
		g.drawImage(bufImage, 0, 0, this);
		
	}
	
	public void UpdateGame() {
		gameWorld.update();
	}
	
	public void RenderGame() {
		if(bufImage == null)
			bufImage = new BufferedImage(GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
		
		if(bufImage != null) {
			bufG2D = (Graphics2D) bufImage.getGraphics();
		}
		
		if(bufG2D != null) {
			bufG2D.setColor(Color.white);
			bufG2D.fillRect(0, 0, GameFrame.SCREEN_WIDTH, GameFrame.SCREEN_HEIGHT);
		}
		
		//draw object game here
		gameWorld.drawGameWorld(bufG2D);
		
	}
	
	public void startGame() {
		if(thread == null) {
			isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {

        long previousTime = System.nanoTime();
        long currentTime;
        long sleepTime;

        long period = 1000000000/30;

        while(isRunning){

            UpdateGame();
            RenderGame();
        	
            repaint();

            currentTime = System.nanoTime();
            sleepTime = period - (currentTime - previousTime);
            try{

                    if(sleepTime > 0)
                            Thread.sleep(sleepTime/1000000);
                    else Thread.sleep(period/2000000);

            }catch(Exception e){}

            previousTime = System.nanoTime();
        }

    }

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		inputManager.processKeyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		inputManager.processKeyReleaseed(e.getKeyCode());
	}
}