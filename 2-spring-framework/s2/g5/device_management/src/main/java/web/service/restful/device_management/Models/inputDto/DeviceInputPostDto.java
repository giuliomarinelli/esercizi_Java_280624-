package web.service.restful.device_management.Models.inputDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DeviceInputPostDto(

        @NotBlank(message = "'type' field of device is reqquired")
        @Pattern(regexp = "^[A-Z](?:_?[A-Z])*$|^[A-Z]$\n", message = "malformed 'type' field")
        String type

) {}
