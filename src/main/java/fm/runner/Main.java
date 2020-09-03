package fm.runner;

import fm.actions.Actions;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author talbn on 9/2/2020
 **/
public class Main {

    public static void main(String[] args) throws IOException {

        final List<String> ACTIONS = Arrays.asList("sort", "shuffle", "reverse");

        if(args.length != 3) {
            System.out.println("input should be: <file1> <file2> <action>");
            System.exit(0);
        }
        else if(!ACTIONS.contains(args[2])){
            System.out.println("Action not available");
            System.exit(0);
        }

        final String PATH_INPUT = "c:/temp/"+args[0];
        final String PATH_OUTPUT = "c:/temp/"+args[1];
        File inputFile = new File(PATH_INPUT);
        File outputFile = new File(PATH_OUTPUT);

        if(!inputFile.exists()){
            System.out.println("Input file do not exists");
            System.exit(0);
        }
        else if (!outputFile.exists()){
            System.out.println("Output file do not exists");
            System.exit(0);
        }
        Actions.action(args[2],PATH_INPUT, PATH_OUTPUT);
    }
}
