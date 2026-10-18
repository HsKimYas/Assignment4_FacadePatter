package kz.university.facade.facade;

import kz.university.facade.model.ConvertedMedia;
import kz.university.facade.model.MediaFile;
import kz.university.facade.subsystem.AudioMixer;
import kz.university.facade.subsystem.BitrateReader;
import kz.university.facade.subsystem.Codec;
import kz.university.facade.subsystem.CodecFactory;
import kz.university.facade.subsystem.MetadataReader;

public class MediaConversionFacade {
    private final MetadataReader metadataReader;
    private final CodecFactory codecFactory;
    private final BitrateReader bitrateReader;
    private final AudioMixer audioMixer;

    public MediaConversionFacade() {
        metadataReader = new MetadataReader();
        codecFactory = new CodecFactory();
        bitrateReader = new BitrateReader();
        audioMixer = new AudioMixer();
    }

    /**
     * Converts a media file through the complete subsystem workflow.
     * The client does not need to know the order or details of these steps.
     */
    public ConvertedMedia convert(String fileName, String targetFormat) {
        MediaFile source = metadataReader.read(fileName);
        Codec targetCodec = codecFactory.create(targetFormat);
        int bitrate = bitrateReader.normalize(source.getBitrate(), targetCodec.getFormat());
        String mixedAudio = audioMixer.fix(source.getAudioTrack());
        String encodedVideo = targetCodec.encode(source.getVideoTrack());

        String outputName = changeExtension(source.getFileName(), targetCodec.getFormat());
        String content = mixedAudio + ", " + encodedVideo;

        System.out.println("[Facade] Conversion completed: " + outputName);
        return new ConvertedMedia(outputName, targetCodec.getFormat(), bitrate, content);
    }

    private String changeExtension(String fileName, String targetFormat) {
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
        return baseName + "." + targetFormat;
    }
}
