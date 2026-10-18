package kz.university.facade.subsystem;

public class BitrateReader {
    public int normalize(int sourceBitrate, String targetFormat) {
        int targetBitrate = switch (targetFormat.toLowerCase()) {
            case "mp4" -> 2500;
            case "webm" -> 1800;
            case "avi" -> 2200;
            default -> throw new IllegalArgumentException(
                    "Cannot calculate bitrate for " + targetFormat);
        };

        int normalized = Math.min(sourceBitrate, targetBitrate);
        System.out.println("[BitrateReader] Normalizing bitrate: "
                + sourceBitrate + " -> " + normalized + " kbps");
        return normalized;
    }
}
