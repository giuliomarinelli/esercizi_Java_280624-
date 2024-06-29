package web.service.restful.device_management.Models.inputDto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeviceIdInputDto(
        @NotNull(message = "'deviceId' field is required")
        UUID deviceId
) {}
