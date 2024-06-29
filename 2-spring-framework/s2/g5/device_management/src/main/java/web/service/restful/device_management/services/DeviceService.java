package web.service.restful.device_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import web.service.restful.device_management.Models.entities.Device;
import web.service.restful.device_management.Models.enums.DeviceType;
import web.service.restful.device_management.Models.inputDto.DeviceInputPostDto;
import web.service.restful.device_management.Models.inputDto.DeviceInputPutDto;
import web.service.restful.device_management.Models.outputDto.ConfirmOutputDto;
import web.service.restful.device_management.exception_handling.BadRequestException;
import web.service.restful.device_management.exception_handling.NotFoundException;
import web.service.restful.device_management.repositories.DeviceRepository;

import java.util.UUID;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Page<Device> findAll(Pageable pageable) {
        return deviceRepository.findAll(pageable).map(p -> {
            p.setEmployeeId(p.getEmployee().getId());
            return p;
        });
    }

    public Device findById(UUID id) throws NotFoundException {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Device with id='" + id + "' not found")
        );
        device.setEmployeeId(device.getEmployee().getId());
        return device;
    }

    public Device create(DeviceInputPostDto deviceInputPostDto) throws BadRequestException {
        Device device = new Device(deviceInputPostDto.type());
        deviceRepository.save(device);
        device.setEmployeeId(device.getEmployee().getId());
        return device;
    }

    public Device updateById(DeviceInputPutDto deviceInputPutDto, UUID id) throws NotFoundException, BadRequestException {
        Device device = deviceRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Device with id='" + id + "' not found. Cannot update")
        );

        DeviceType type;

        try {
            type = DeviceType.valueOf(deviceInputPutDto.type());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid device type");
        }

        device.setType(type);
        device.setAvailable(deviceInputPutDto.available());
        device.setUnderMaintenance(deviceInputPutDto.underMaintenance());
        device.setDecommissioned(deviceInputPutDto.decommissioned());

        device.setEmployeeId(device.getEmployee().getId());
        return device;

    }

    public ConfirmOutputDto deleteById(UUID id) {
        deviceRepository.deleteById(id);
        return new ConfirmOutputDto(HttpStatus.OK.value(),
                "Device with id='" + id + "' successfully deleted");
    }

}
