package web.service.restful.device_management.Models.inputDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EmployeeInputDto(

        @NotBlank(message = "'firstName' field is required")
        String firstName,
        @NotBlank(message = "'lastName' field is required")
        String lastName,
        @NotBlank(message = "'username' field is required")
        String username,
        @NotBlank(message = "'email' field is required")
        @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "malformed 'email' field")
        String email

) {}
