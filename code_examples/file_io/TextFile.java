package week6;

import java.io.*;

public class TextFile
{
    public static void copyText(String...args) throws IOException {

        long StartTime, elapsedTime = 0;
        StartTime =  System.nanoTime();
        try
        {
            //Create link to input and output file
            File input = new File(args[0]);
            File output = new File(args[1]);

            //Reader for Text
            FileReader in = null;
            //Writer for text
            FileWriter out = null;
            //number returns -1 if end of stream is reached
            // used to the reader
            int c = 0;
            try
            {
                //link reader to file for reading
                in = new FileReader(input);
                //link reader to file for writing
                out = new FileWriter(output);
                //while the reader input stream != -1 write the byte to the file
                while ((c = in.read()) != -1)
                {
                    out.write(c);
                }
            } catch (IOException e)
            {
                System.out.println("File not found");
                e.printStackTrace();
            } finally
            {
                in.close();
                out.close();
                System.out.println("Copy Successful");
            }
            elapsedTime = System.nanoTime() - StartTime;
            //Now read from the copy file using a buffer to stream text to console
            try
            {
                //File reader to link to copied file
                FileReader newIn =  new FileReader(args[1]);
                //Buffered reader which can be streamed to a String for printing
                BufferedReader readerIN =  new BufferedReader(newIn);
                //get the first line of the text file
                String line = readerIN.readLine();
                //while the line has character print the line
                while(line != null)
                {
                    System.out.println(line);
                    // get the next line, if null loop will terminate
                    line = readerIN.readLine();
                }

                if(newIn != null) newIn.close();
                if(readerIN != null) readerIN.close();
            }catch (IOException e)
            {
                System.out.println("Reader File not Found");
            }

        }
        catch (ArrayIndexOutOfBoundsException | FileNotFoundException ex)
        {
            System.out.println("Files not found");
        }


        System.out.println("***************");
        System.out.println("Duration of operation (Copy text File)");
        System.out.println("Elapsed Time (Milleseconds) : " + (elapsedTime/1000000.0));
    }
}
