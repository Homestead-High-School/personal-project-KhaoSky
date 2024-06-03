import java.util.*;
import java.io.File;


public class ImageType {
    private static String imageFullPath;
    private static final String IMAGE_EXT_JPG = "jpg";
    private static final String IMAGE_EXT_JPEG = "jpeg";
    private static final String IMAGE_EXT_PNG = "png";
    private static final String IMAGE_EXT_GIF = "gif";

    // constant string to hold allowed image types
    public static final String IMAGE_ALLOW_TYPES = "Image types allowed: " + IMAGE_EXT_JPG + ", " + IMAGE_EXT_JPEG + ", " + IMAGE_EXT_PNG + ", " + IMAGE_EXT_GIF;

    // constructor to set the full path of the image
    public ImageType(String imageFullPath){
        this.imageFullPath = imageFullPath;
    }

    // checks the image type
    public boolean isFileValidImage(){
        if(imageFullPath == null){
            throw new NullPointerException();
        }
        // gets the file extension
        File imageFile = new File(imageFullPath);
        String ext = getFileExtension(imageFile);
        // checks if it is a valid extension
        if(IMAGE_EXT_JPG.equalsIgnoreCase(ext) || IMAGE_EXT_JPEG.equalsIgnoreCase(ext)|| IMAGE_EXT_PNG.equalsIgnoreCase(ext) || IMAGE_EXT_GIF.equalsIgnoreCase(ext)){
            return true;
        }
        return false;
    }

    // helper method to get the file extension
    private static String getFileExtension(File imageFile){
        // validates that imageFullPath is not null
        if(imageFile == null){
            throw new NullPointerException("Image file cannot be null.");
        }
        // get the file name and extension
        String name = imageFile.getName();
        int lastDotIndex = name.lastIndexOf(".");
        if(lastDotIndex > 0 && lastDotIndex < (name.length() -1)){
            return name.substring(lastDotIndex + 1).toLowerCase();
        }
        return "";
    }

    
}
