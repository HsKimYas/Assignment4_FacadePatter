package kz.university.facade.model;

public class ConvertedMedia {
    private final String fileName;
    private final String targetFormat;
    private final int bitrate;
    private final String content;

    public ConvertedMedia(String fileName, String targetFormat,
                          int bitrate, String content) {
        this.fileName = fileName;
        this.targetFormat = targetFormat;
        this.bitrate = bitrate;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ConvertedMedia{" +
                "fileName='" + fileName + '\'' +
                ", targetFormat='" + targetFormat + '\'' +
                ", bitrate=" + bitrate +
                ", content='" + content + '\'' +
                '}';
    }
}
