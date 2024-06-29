package web.service.restful.device_management.exception_handling;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public class Validation {

    private static String getMessage(BindingResult validation) {
        return validation.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(". "));
    }

    public static void validate(BindingResult validation) throws BadRequestException {
        if (validation.hasErrors())
            throw new BadRequestException(getMessage(validation));
    }

}
