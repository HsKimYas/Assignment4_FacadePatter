package kz.university.facade.subsystem;

import kz.university.facade.model.MediaFile;

public class MetadataReader {
    public MediaFile read(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }

        String extension = extractExtension(fileName);
        int bitrate = switch (extension) {
            case "mp4" -> 3200;
            case "mkv" -> 4000;
            case "avi" -> 2500;
            default -> throw new IllegalArgumentException(
                    "Unsupported source format: " + extension);
        };

        System.out.println("[MetadataReader] Reading metadata from " + fileName);
        return new MediaFile(
                fileName,
                extension,
                bitrate,
                "original-audio-track",
                "original-video-track"
        );
    }

    private String extractExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex < 0 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException("File must have an extension");
        }
        return fileName.substring(dotIndex + 1).toLowerCase();
    }
}
