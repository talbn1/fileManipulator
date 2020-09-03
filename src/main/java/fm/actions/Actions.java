package fm.actions;

import java.io.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import fm.repository.Repository;

/**
 * @author talbn on 9/3/2020
 **/
public class Actions {

    private Actions() {
    }

    public static void action(String action,
                              String inputPath,
                              String outputFile) throws IOException {

        BufferedReader input = null;
        PrintWriter output = null;

        try {
            input = new BufferedReader( new FileReader(inputPath));
            output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));

            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            input.close();

            switch (action) {
                case "sort":
                    System.out.println("Sorting");
                    Collections.sort(list);
                    break;
                case "reverse":
                    System.out.println("Reversing");
                    Collections.reverse(list);
                    break;
                case "shuffle":
                    System.out.println("Shuffling");
                    Collections.shuffle(list);

                    break;
                default:
                    System.out.println("Action do not exists yet");
                    break;
            }
            Repository.insertRecord(action,inputPath,outputFile);

            for (Iterator<String> i = list.iterator(); i.hasNext();) {
                output.println( i.next());
            }
            output.close();
        }catch (NullPointerException | IOException exception){
            exception.printStackTrace();
        } finally{
            if (input!= null){
                input.close();
            }
            if (output != null){
                output.close();

            }
        }
    }
}