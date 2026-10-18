# Assignment #4 — Facade Pattern

Language: Java 17  
Pattern: Facade  
Option: A — Media/File Conversion Facade

## 1. Idea

The project demonstrates the **Facade** structural design pattern. A media conversion operation requires several subsystem classes: metadata reading, codec selection/encoding, bitrate normalization, and audio processing.

Without a facade, a client would have to know the correct order of all these operations. `MediaConversionFacade` provides one simple method:

```java
convert(fileName, targetFormat)
```

The client (`Main`) uses only the facade and never creates or calls subsystem classes directly.

## 2. Structure

- `MediaConversionFacade` — coordinates the conversion workflow.
- `MetadataReader` — validates the file name and reads simulated media metadata.
- `CodecFactory` — selects a codec for the requested target format.
- `BitrateReader` — calculates and applies a target bitrate.
- `AudioMixer` — normalizes/mixes the audio track.
- `Codec` — abstraction for encoding.
- `MediaFile` — source media data.
- `ConvertedMedia` — conversion result.
- `Main` — client that depends only on the facade.

## 3. Run

Requirements: JDK 17 and Maven 3.9+.

```bash
mvn clean compile exec:java
```

Expected output contains the following workflow:

1. Metadata is read.
2. Target codec is selected.
3. Bitrate is normalized.
4. Audio is processed.
5. Video is encoded.
6. Conversion result is returned.

## 4. Why this is a Facade

The subsystem classes do not know that the facade exists. They can still be used directly by an advanced client. The facade only simplifies the common use case by hiding orchestration details.

## 5. Clean Code principles

1. **Meaningful names** — `MediaConversionFacade.convert`, `MetadataReader.read`, `BitrateReader.normalize`, and `AudioMixer.fix` describe intent.
2. **Single Responsibility** — each subsystem owns one conversion concern; the facade coordinates instead of reimplementing them.
3. **No leaking subsystem details** — the client receives `ConvertedMedia` rather than a collection of internal subsystem objects.
4. **Small focused classes** — each subsystem has a narrow responsibility.
5. **Error handling** — invalid source/target formats are rejected with `IllegalArgumentException` before conversion can proceed with invalid data.
