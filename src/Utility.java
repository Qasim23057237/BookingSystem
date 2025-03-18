import  java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {
     public static int getnextid(String filename)
     {
         List<Integer> allids = new ArrayList<>();
         try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
             String line;
             while ((line = br.readLine()) != null)
             {
                 String[] parts = line.split(",");
                 if (parts.length > 0)
                 {
                     try {
                         int id = Integer.parseInt(parts[0].trim());
                         allids.add(id);

                     }
                     catch (NumberFormatException e)
                     {
                     }
                     }


                 }

             }
         catch (IOException e)
         {
             e.printStackTrace();
         }
         catch (NumberFormatException e)
         {
           e.printStackTrace();
         }
          int maxid = 0;
         for(Integer id : allids)
         {

             if(id > maxid)
             {
                 maxid = id + 1;
             }
         }
         return maxid;


     }
}
