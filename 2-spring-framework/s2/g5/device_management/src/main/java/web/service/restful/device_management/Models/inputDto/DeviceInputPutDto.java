package web.service.restful.device_management.Models.inputDto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import web.service.restful.device_management.Models.enums.DeviceType;

public record DeviceInputPutDto(

        @NotBlank(message = "'type' field of device is required")
        @Pattern(regexp = "^[A-Z](?:_?[A-Z])*$|^[A-Z]$\n", message = "malformed 'type' field")
        String type,

        @NotNull(message = "'' field is required")
        Boolean available,

        @NotNull(message = "'' field is required")
        Boolean underMaintenance,

        @NotNull(message = "'' field is required")
        Boolean decommissioned

) {}
