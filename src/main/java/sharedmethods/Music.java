/*
    Date: January 25, 2021
    Created by: Jookie262
    Purpose: Sound Class for the Game
*/

package sharedmethods;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Music {

    // Method that creates a sound effect
    public void soundEffect(String soundName, float volume, boolean loop){
        try {
            // Setting up the Audio for Background Music
            AudioInputStream audioInputStream2 = AudioSystem.getAudioInputStream(new File(soundName));
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioInputStream2);
            // For Looping
            if(loop) clip2.loop(Clip.LOOP_CONTINUOUSLY);
            // Adjust Sound
            FloatControl gainControl =  (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume);
            // Start the Audio
            clip2.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    // Sound when the user click anywhere
    public void shootEffect(JPanel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                soundEffect("res/sound/shoot.wav", -20f, false);
            }
        });
    }

    public void backgroundMusic() {
        soundEffect("res/sound/background.wav", -18f, true);
    }
}
