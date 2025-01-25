import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("image.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedImage = encoder.encodeToString(outputStream.toByteArray());

        int choice;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.printf("\n\t1 Black and White\n\t2 Red\n\t3 Green\n\t4 Blue\n\t5 Inverse\n\t6 Sepia\n\t7 Funny\n\t8 Mirror\n\t9 Flip\n\t10 Solarize\n\t0 Exit");
            System.out.printf("\n\t0-10:");
            choice = scan.nextInt();
            switch (choice) {
                case(1):
                    encodedImage = Filter.GrayscaleFilter(encodedImage);
                    break;
                case(2):
                    encodedImage = Filter.RedFilter(encodedImage);
                    break;
                case(3):
                    encodedImage = Filter.GreenFilter(encodedImage);
                    break;
                case(4):
                    encodedImage = Filter.BlueFilter(encodedImage);
                    break;
                case(5):
                    encodedImage = Filter.InverseFilter(encodedImage);
                    break;
                case(6):
                    encodedImage = Filter.SepiaFilter(encodedImage);
                    break;
                case(7):
                    encodedImage = Filter.FunnyFilter(encodedImage);
                    break;
                case(8):
                    encodedImage = Filter.MirrorFilter(encodedImage);
                    break;
                case(9):
                    encodedImage = Filter.FlipFilter(encodedImage);
                    break;
                case(10):
                    encodedImage = Filter.SolarizeFilter(encodedImage);
                    break;
                case(0): break;
                default: continue;
            }
        }while(choice!=0);

        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("UltimateImage.png") );
    }
}