public class ImageToAscii {
    
    // ImageProcessor object to process the image
    private ImageProcessor processor;
    private static final String ASCIICHARS = ".,':;!i1l|-~+_?][}{)(/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    // "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$"

    // Costructor that takes the full path of the image as an input
    public ImageToAscii(String imageFullPath){
        processor = new ImageProcessor(imageFullPath);
    }

    // Method prints the ASCII art
    public void printAsciiMatrix(){
        char[][] pixels = setAsciiMatrix(processor.getBrightnessMatrix());
        // Iterates over the ASCII matrix
        for(int i = 0; i < pixels.length; i+=2){
            for(int j = 0; j < pixels[0].length; j++){
                System.out.print(pixels[i][j]);
            }
            // Moves to the next line
            System.out.println();
        }
    }

    // Method to set the ASCII matrix using the brightness matrix
    private static char[][] setAsciiMatrix(int[][] brightnessMatrix){
        char[][] asciiMatrix = new char[brightnessMatrix.length][];
        int rowCount = 0;
        // Iterate over the brightness matrix
        for(int[] row : brightnessMatrix){
            char[] asciiRow = new char[row.length];
            int cellCount = 0;
            for(int cell : row){
                asciiRow[cellCount] = convertToAscii(cell);
                cellCount++;
            }
            asciiMatrix[rowCount] = asciiRow;
            rowCount++;
        }
        return asciiMatrix;
    }

    // Helper method that converts the brightness value to an ASCII character
    private static char convertToAscii(int brightnessValue){
        char asciiValue;
        int asciiIndex;
        // Maps the brightness value to an index in the ASCII characters string
        asciiIndex = (int) ((ASCIICHARS.length()-1) * (brightnessValue/255.0));
        // Gets the ASCII character from the string using index
        asciiValue = ASCIICHARS.charAt(asciiIndex);
        return asciiValue;
    }
}
