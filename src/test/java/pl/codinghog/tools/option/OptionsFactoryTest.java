package pl.codinghog.tools.option;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class OptionsFactoryTest {

    @Test
    public void testInputOption() {
        // With
        OptionsFactory of = new OptionsFactory();
        Options options = of.createOptions();

        // Given
        Option option = options.getOption("i");

        // Assert
        assertThat(option, notNullValue());
        assertThat(option.getArgName(), is("input"));
        assertThat(option.isRequired(), is(true));
        assertThat(option.hasArgs(), is(true));
    }

    @Test
    public void testOutputOption() {
        // With
        OptionsFactory of = new OptionsFactory();
        Options options = of.createOptions();

        // Given
        Option option = options.getOption("o");

        // Assert
        assertThat(option, notNullValue());
        assertThat(option.getArgName(), is("output"));
        assertThat(option.isRequired(), is(true));
        assertThat(option.hasArg(), is(true));
    }
}