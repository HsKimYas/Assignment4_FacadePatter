package kz.university.facade.subsystem;

public class CodecFactory {
    public Codec create(String targetFormat) {
        if (targetFormat == null || targetFormat.isBlank()) {
            throw new IllegalArgumentException("Target format cannot be empty");
        }

        return switch (targetFormat.toLowerCase()) {
            case "mp4" -> new SimpleCodec("mp4");
            case "webm" -> new SimpleCodec("webm");
            case "avi" -> new SimpleCodec("avi");
            default -> throw new IllegalArgumentException(
                    "Unsupported target format: " + targetFormat);
        };
    }

    private static class SimpleCodec implements Codec {
        private final String format;

        private SimpleCodec(String format) {
            this.format = format;
        }

        @Override
        public String getFormat() {
            return format;
        }

        @Override
        public String encode(String videoTrack) {
            System.out.println("[Codec] Encoding video using " + format + " codec");
            return "encoded(" + format + ":" + videoTrack + ")";
        }
    }
}
