import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;

public class ImageProcessor {
    private ImageType imageType;
    private String imagePath;

    // constructor which sets the image path and creates an instance of ImageType
    public ImageProcessor(String imageFullPath){
        imagePath = imageFullPath;
        imageType = new ImageType(imagePath);
    }    

    // gets the brightness matrix of the image
    public int[][] getBrightnessMatrix(){
        BufferedImage image = getImage(imagePath);
        int[][] pixels = getPixelsFromImage(image);
        return setBrightnessMatrix(pixels);
    }

    // helper method that gets the BufferedImage from the given path
    private BufferedImage getImage(String imageFullPath){
        BufferedImage buffImage = null;
        try{
            if(imageFullPath == null){
                throw new NullPointerException("Image full path cannot be null or empty.");
            }
            boolean isImage = imageType.isFileValidImage();
            if(!isImage){
                throw new ImagingOpException(ImageType.IMAGE_ALLOW_TYPES);
            }
            String tempImagePath = imageFullPath;
            buffImage = ImageIO.read(new File(tempImagePath));
        } catch(Exception e){
            e.printStackTrace();
        }
        return buffImage;
    }

    // helper method that gets the pixels of the image as a 2d int array
    private static int[][] getPixelsFromImage(BufferedImage buffImage){
        if(buffImage == null){
            throw new IllegalArgumentException();
        }
        int h = buffImage.getHeight();
        int w = buffImage.getWidth();
        int [][] pixels = new int[h][w];
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                pixels[j][i] = buffImage.getRGB(i,j);
            }
        }
        return pixels;
    }

    // helper method that calculates the brightness matrix from the 2d int array of pixels
    private static int[][] setBrightnessMatrix(int[][] pixels){
        int r, g, b;
        int average;
        int[][] avg = new int[pixels.length][pixels[0].length];
        for(int i = 0; i < pixels.length; i++){
            for(int j = 0; j < pixels[0].length; j++){
                // gets the red, green, and blue values of current pixel using bitshift, bitmask, and bitwise operators
                r = (pixels[i][j]>>16) & 0xff;
                g = (pixels[i][j]>>8) & 0xff;
                b = (pixels[i][j]) & 0xff;
                average = (r+g+b)/3;
                avg[i][j] = average;
            }
        }
        return avg;
    }
}
