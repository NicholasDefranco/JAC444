package week6;

import java.io.*;

public class BinaryFile
{
    public static void copyBin(String... args)
    {
        int bytes = 0;
        long StartTime, elapsedTime = 0;
        //Used to time operations
        StartTime =  System.nanoTime();

        File fileIn = new File(args[2]);
        File fileOut =  new File(args[3]);
        //Binary inputStream
        FileInputStream streamIn = null;
        //Binary OutputStream
        FileOutputStream StreamOut = null;
        try
        {
            streamIn = new FileInputStream(fileIn);
            StreamOut =  new FileOutputStream(fileOut);
            while ((bytes = streamIn.read()) != -1)
            {
                //copies byte by byte everything from the input stream to output stream
                StreamOut.write(bytes);
            }
        } catch (IOException e)
        {
            System.out.println("Input Files Not Found");
        }
        finally
        {
            try
            {
                if(StreamOut != null) StreamOut.close();
                if(streamIn != null) streamIn.close();
            }
            catch (IOException ex)
            {
                System.out.println("File Close Error");
            }
            elapsedTime = System.nanoTime() - StartTime;

            System.out.println("File copied Success");
            System.out.println("Binary File Copy Time: " + elapsedTime / 1000000.0);
        }

    }
}
