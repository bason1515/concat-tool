package pl.codinghog.tools.option;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsFactory {

    private Option getInputOptions() {
        return Option.builder("i")
                .argName("input")
                .desc("input files")
                .hasArgs()
                .required()
                .build();
    }

    private Option getOutputOption() {
        return Option.builder("o")
                .argName("output")
                .desc("output file")
                .hasArg()
                .required()
                .build();
    }
    
    private Option getSkipNewLineOption() {
        return Option.builder("s")
                .argName("-skip-new-line")
                .desc("skips new line after concatenating the file")
                .hasArg(false)
                .required(false)
                .build();
    }

    public Options createOptions() {
        Options options = new Options();
        options.addOption(getInputOptions());
        options.addOption(getOutputOption());
        options.addOption(getSkipNewLineOption());

        return options;
    }
}
