package pl.codinghog.tools;

import org.apache.commons.cli.*;
import pl.codinghog.tools.option.OptionsFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        OptionsFactory of = new OptionsFactory();
        Options options = of.createOptions();

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("concat-tool", options);

            System.exit(1);
            return;
        }

        String[] inputFilePaths = cmd.getOptionValues("i");
        String outputFilePath = cmd.getOptionValue("o");
	boolean skipNewLine = cmd.hasOption("s");

        System.out.println(outputFilePath);

        Stream.of(inputFilePaths).forEach(e -> App.append(e, outputFilePath));
        System.out.println("DONE");
    }

    private static void append(String filename, String outputname, boolean skipNewLine) {
        System.out.println(filename);

        Path outputPath = Paths.get(outputname);
        Path inputPath = Paths.get(filename);


        String header = String.join(
                "\n",
                "--------------------------------------------------------------------------------",
                "-- " + inputPath.getFileName(),
                "--------------------------------------------------------------------------------",
                ""
        );

        try {
            byte[] inputBytes = Files.readAllBytes(inputPath);

            Files.write(outputPath, header.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.write(outputPath, inputBytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            if(!skipNewLine && inputBytes[inputBytes.length-1] != 10) { 
		Files.write(outputPath, System.lineSeparator().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	    }
        } catch (IOException e) {
            System.out.println("ERROR");
        }
    }
}
