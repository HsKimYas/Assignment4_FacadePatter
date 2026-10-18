package kz.university.facade.subsystem;

public interface Codec {
    String getFormat();
    String encode(String videoTrack);
}
