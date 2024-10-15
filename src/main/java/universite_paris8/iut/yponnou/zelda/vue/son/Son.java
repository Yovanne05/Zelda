package universite_paris8.iut.yponnou.zelda.vue.son;


import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Son {

    private String chemin;
    private Clip clip;
    private AudioInputStream decodedAudioStream;

    public Son(String chemin){
        this.chemin = chemin;
        try {
            URL url = getClass().getResource(this.chemin);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            AudioFormat decodedFormat = getAudioFormat(audioStream);
            decodedAudioStream = AudioSystem.getAudioInputStream(decodedFormat, audioStream);
            DataLine.Info info = new DataLine.Info(Clip.class, decodedFormat);
            clip = (Clip) AudioSystem.getLine(info);
        }
        catch(UnsupportedAudioFileException| IOException | LineUnavailableException e){
            System.out.println("Son incompatbile");
        }
    }

    private static AudioFormat getAudioFormat(AudioInputStream audioStream) {
        AudioFormat baseFormat = audioStream.getFormat();
        return new AudioFormat
                (
                        AudioFormat.Encoding.PCM_SIGNED,
                        baseFormat.getSampleRate(),
                        16,
                        baseFormat.getChannels(),
                        baseFormat.getChannels() * 2,
                        baseFormat.getSampleRate(),
                        false
                );
    }

    public void jouer(float volume, int repetitions){
        if (!clip.isOpen()) {
            try {
                clip.open(decodedAudioStream);
            }catch (Exception e){
                System.out.println("Son incompatible");
            }

        }
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)){
            FloatControl volumeControleur = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControleur.setValue(volume);
        }
        if (repetitions == -1) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else if (repetitions != 0)
            clip.loop(repetitions);
        else
            clip.loop(0);

    }

    public void run(){
        if(!clip.isRunning()){
            clip.setFramePosition(0);
            clip.loop(1);
            clip.start();
        }
    }

    public void stop(){
        clip.stop();
    }
    public boolean estOuvert(){
        return clip.isOpen();
    }

}