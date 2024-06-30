package web.service.restful.device_management.controllers;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.restful.device_management.Models.entities.Device;
import web.service.restful.device_management.Models.entities.Employee;
import web.service.restful.device_management.Models.inputDto.DeviceIdInputDto;
import web.service.restful.device_management.Models.inputDto.EmployeeInputDto;
import web.service.restful.device_management.Models.outputDto.ConfirmOutputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.InternalServerErrorException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.exception_handling.Validation;
import web.service.restful.device_management.services.CloudinaryService;
import web.service.restful.device_management.services.EmployeeService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping
    public Page<Employee> findAll(Pageable pageable) {
        return employeeService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable UUID id) throws NotFoundException {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee create(@RequestBody @Validated EmployeeInputDto employeeInputDto, BindingResult validation) throws BadRequestException, InternalServerErrorException {
        Validation.validate(validation);
        return employeeService.create(employeeInputDto);
    }

    @PutMapping("/{id}")
    public Employee updateById(@RequestBody @Validated EmployeeInputDto employeeInputDto, BindingResult validation, @PathVariable UUID id) throws BadRequestException, NotFoundException, InternalServerErrorException {
        Validation.validate(validation);
        return employeeService.updateById(employeeInputDto, id);
    }

    @DeleteMapping("/{id}")
    public ConfirmOutputDto deleteById(@PathVariable UUID id) throws NotFoundException {
        return employeeService.deleteById(id);
    }

    @PatchMapping("/{id}/assign-device")
    public ConfirmOutputDto assignDeviceToEmployee(@RequestBody @Validated DeviceIdInputDto deviceIdInputDto, BindingResult validation, @PathVariable UUID id) throws NotFoundException, BadRequestException {
        Validation.validate(validation);
        return employeeService.assignDeviceToEmployee(deviceIdInputDto.deviceId(), id);
    }

    @PatchMapping("/{id}/upload-profile-image")
    public ConfirmOutputDto uploadProfileImage(@RequestParam("image") MultipartFile image, @PathVariable UUID id) throws IOException, NotFoundException, BadRequestException {
        Employee employee = employeeService.findById(id);
        if (employee.getProfilePictureUrl() != null)
            throw new BadRequestException("Cannot upload profile image because a profile image has been already uploaded, you should delete it");
        String url = (String) cloudinary.uploader().upload(image.getBytes(), new HashMap<>()).get("url");
        employeeService.updateEmployeeAfterProfileImageUpload(employee, url);
        return new ConfirmOutputDto(HttpStatus.OK.value(), "Profile image successfully uploaded");
    }

    @DeleteMapping("/{id}/delete-profile-image")
    public ConfirmOutputDto deleteProfileImage(@PathVariable UUID id) throws IOException, NotFoundException, BadRequestException {
        Employee employee = employeeService.findById(id);
        if (employee.getProfilePictureUrl() == null)
            throw new BadRequestException("Cannot delete profile image because no profile image is online");
        String url = employee.getProfilePictureUrl();
        cloudinaryService.deleteImageByUrl(url);
        employeeService.updateEmployeeAfterProfileImageUpload(employee, null);
        return new ConfirmOutputDto(HttpStatus.OK.value(), "Profile image successfully deleted");
    }

    @GetMapping("/{id}/devices")
    public List<Device> findDevicesByEmployeeId(@PathVariable UUID id) throws NotFoundException {
        return employeeService.findDevicesByEmployeeId(id);
    }


}
