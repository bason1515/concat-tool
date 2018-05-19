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

    public Options createOptions() {
        Options options = new Options();
        options.addOption(getInputOptions());
        options.addOption(getOutputOption());

        return options;
    }
}
