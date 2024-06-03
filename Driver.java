public class Driver {
    public static void main(String[] args){
        // Creates an object of ImageToAscii class and pass the image path as an argument
        ImageToAscii asciiImage = new ImageToAscii("/Users/17764/Documents/Pikachu.jpeg/");

        // Calls the printAsciiMatrix method to print the ASCII art
        asciiImage.printAsciiMatrix();
    }
}
