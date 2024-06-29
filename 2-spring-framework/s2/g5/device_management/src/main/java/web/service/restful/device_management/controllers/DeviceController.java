package web.service.restful.device_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.service.restful.device_management.Models.entities.Device;
import web.service.restful.device_management.Models.inputDto.DeviceInputPostDto;
import web.service.restful.device_management.Models.inputDto.DeviceInputPutDto;
import web.service.restful.device_management.Models.outputDto.ConfirmOutputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.exception_handling.Validation;
import web.service.restful.device_management.repositories.DeviceRepository;
import web.service.restful.device_management.services.DeviceService;
import web.service.restful.device_management.services.EmployeeService;

import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Page<Device> findAll(Pageable pageable) {
        return deviceService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Device findById(@PathVariable UUID id) throws NotFoundException {
        return deviceService.findById(id);
    }

    @PostMapping
    public Device create(@RequestBody @Validated DeviceInputPostDto deviceInputPostDto, BindingResult validation) throws BadRequestException {
        Validation.validate(validation);
        return deviceService.create(deviceInputPostDto);
    }

    @PutMapping("/{id}")
    public Device updateById(@RequestBody @Validated DeviceInputPutDto deviceInputPutDto, BindingResult validation, @PathVariable UUID id) throws BadRequestException, NotFoundException {
        Validation.validate(validation);
        return deviceService.updateById(deviceInputPutDto, id);
    }

    @DeleteMapping("/{id}")
    public ConfirmOutputDto deleteById(@PathVariable UUID id) {
        return deviceService.deleteById(id);
    }

    @PatchMapping("/{id}/remove-employee")
    public ConfirmOutputDto removeEmployeeFromDevice(@PathVariable UUID id) throws NotFoundException {
        return employeeService.removeDeviceFromEmployee(id);
    }

}
