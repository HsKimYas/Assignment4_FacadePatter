package kz.university.facade.subsystem;

public class AudioMixer {
    public String fix(String audioTrack) {
        System.out.println("[AudioMixer] Normalizing and mixing audio track");
        return "mixed(" + audioTrack + "+normalized-audio)";
    }
}
