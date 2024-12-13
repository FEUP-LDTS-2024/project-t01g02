package com.t01g02.project.menu;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Music {
    private Clip clip;
    protected AudioInputStream in;
    private String currentTrack;

    public void play(String filePath, boolean loop) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
       //Stop current track if it´s already playing
        if (clip != null && clip.isRunning()){
            if (filePath.equals(currentTrack)){
                return;  //If the same track is already playing it should do nothing
            }
            stop();
        }



        // Start music playback in a separate thread to avoid blocking the main thread
        new Thread(() -> {
            try{
                URL url = getClass().getResource(filePath);
                if (url == null){
                    throw new FileNotFoundException("Audio file not found" + filePath);
                }
                in = AudioSystem.getAudioInputStream(url);
                clip = AudioSystem.getClip();
                clip.open(in);

                clip.start();
                if(loop){
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                currentTrack = filePath;
            }catch(Exception e){
                e.printStackTrace();
            }

        }).start();
    }

    public void stop(){
        if(clip!=null && clip.isRunning()){
            clip.stop();
            clip.close();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    public String getCurrentTrack() {
        return currentTrack;
    }
}
