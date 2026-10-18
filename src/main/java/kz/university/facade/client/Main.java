package kz.university.facade.client;

import kz.university.facade.facade.MediaConversionFacade;
import kz.university.facade.model.ConvertedMedia;

public class Main {
    public static void main(String[] args) {
        MediaConversionFacade converter = new MediaConversionFacade();

        ConvertedMedia result = converter.convert("lecture.mkv", "mp4");

        System.out.println();
        System.out.println("Result: " + result);
    }
}
