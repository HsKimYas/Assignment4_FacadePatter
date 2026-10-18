package kz.university.facade.model;

public class MediaFile {
    private final String fileName;
    private final String format;
    private final int bitrate;
    private final String audioTrack;
    private final String videoTrack;

    public MediaFile(String fileName, String format, int bitrate,
                     String audioTrack, String videoTrack) {
        this.fileName = fileName;
        this.format = format;
        this.bitrate = bitrate;
        this.audioTrack = audioTrack;
        this.videoTrack = videoTrack;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFormat() {
        return format;
    }

    public int getBitrate() {
        return bitrate;
    }

    public String getAudioTrack() {
        return audioTrack;
    }

    public String getVideoTrack() {
        return videoTrack;
    }
}
