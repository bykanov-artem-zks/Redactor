import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

public class Filter {
    public static String GrayscaleFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            int avg = (r + g + b) / 3;
            p = (a << 24) | (avg << 16) | (avg << 8) | avg;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String RedFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            if (r>200 & g>200 & b>200) continue;
            r = r + 40;
            p = (a << 24) | (r << 16) | (g << 8) | b;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String GreenFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            if (r>180 & g>180 & b>180) continue;
            g = g + 40;
            p = (a << 24) | (r << 16) | (g << 8) | b;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }


    public static String BlueFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            if (r>180 & g>180 & b>180) continue;
            b = b + 40;
            p = (a << 24) | (r << 16) | (g << 8) | b;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String InverseFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            r = 225 - r;
            g = 225 - g;
            b = 225 - b;
            p = (a << 24) | (r << 16) | (g << 8) | b;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String SepiaFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            if (r>160 & g>160 & b>160) continue;
            int newRed = (int) (0.393*r + 0.769*g + 0.189*b);
            int newGreen = (int) (0.349*r + 0.686*g + 0.168*b);
            int newBlue = (int) (0.272*r + 0.534*g + 0.131*b);
            p = (a << 24) | (newRed << 16) | (newGreen << 8) | newBlue;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String FunnyFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        for(int y=1; y<height; y++) {
            for(int x=1; x<width/2; x++){
                img.setRGB(x, y, img.getRGB(width-x, y));
            }
        }
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String MirrorFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int buffer;
        for(int y=1; y<height; y++) {
            for(int x=1; x<width/2; x++){
                buffer = img.getRGB(x,y);
                img.setRGB(x, y, img.getRGB(width-x, y));
                img.setRGB(width-x, y, buffer);
            }
        }
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String FlipFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int buffer;
        for(int y=1; y<height/2; y++) {
            for(int x=1; x<width; x++){
                buffer = img.getRGB(x,y);
                img.setRGB(x, y, img.getRGB(x, height-y));
                img.setRGB(x, height-y, buffer);
            }
        }
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

    public static String SolarizeFilter(String encodedImage) throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        String imageDataBytes = encodedImage.substring(encodedImage.indexOf(",")+1);
        byte[] data = decoder.decode(imageDataBytes);
        try (
                OutputStream stream = new FileOutputStream("base64.png")) {
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ByteArrayInputStream inStreambj = new ByteArrayInputStream(data);
        BufferedImage newImage = ImageIO.read(inStreambj);
        ImageIO.write(newImage, "png", new File("OutputImage.png") );
        BufferedImage img = null;
        File f = null;
        try {
            f = new File(
                    "OutputImage.png");
            img = ImageIO.read(f);
        } catch (IOException e) {
            System.out.println(e);
        }
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);
        for(int i=0; i<pixels.length; i++){
            int p = pixels[i];
            int a = (p >> 24) & 0xff;
            int r = (p >> 16) & 0xff;
            int g = (p >> 8) & 0xff;
            int b = p & 0xff;
            if (r<215) r += 40;
            if (g<215) g += 40;
            if (b<215) b += 40;
            p = (a << 24) | (r << 16) | (g << 8) | b;
            pixels[i] = p;
        }
        img.setRGB(0, 0, width, height, pixels, 0, width);
        try {
            f = new File(
                    "OutputImage.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            System.out.println(e);
        }
        BufferedImage image = ImageIO.read(new File("OutputImage.png"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        Base64.Encoder encoder = Base64.getEncoder();
        String processedImage = encoder.encodeToString(outputStream.toByteArray());
        return processedImage;
    }

}
