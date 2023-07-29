package input;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class NotNullParam implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (value == null) {
            throw new ParameterException("parameter " + name + " not found");
        }
    }
}
