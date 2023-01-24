package facade.videoConverter;

import facade.videoConverter.facade.VideoConversionFacade;

import java.io.File;

// As classes da aplicação não dependem de um bilhão de classes
// fornecidas por um framework complexo. Também, se você decidir
// trocar de frameworks, você só precisa reescrever a classe
// fachada.
public class Main {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        System.out.println();
        File oggVideo = converter.convertVideo("youtubevideo.mp4", "ogg");
    }
}
