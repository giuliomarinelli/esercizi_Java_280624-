package web.service.restful.device_management.Models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import web.service.restful.device_management.Models.enums.DeviceType;
import web.service.restful.device_management.exception_handling.BadRequestException;

import java.util.UUID;

@Entity
@Table(name = "devices")
@Data
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    private boolean available = true;

    private boolean assigned = false;

    private boolean underMaintenance = false;

    private boolean decommissioned = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Transient
    private UUID employeeId;

    public Device(String type) throws BadRequestException {
        try {
            this.type = DeviceType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid device type");
        }
    }

    public Device(String type, boolean available, boolean assigned, boolean underMaintenance, boolean decommissioned, Employee employee) throws BadRequestException {
        try {
            this.type = DeviceType.valueOf(type);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid device type");
        }
        this.available = available;
        this.assigned = assigned;
        this.underMaintenance = underMaintenance;
        this.decommissioned = decommissioned;
        this.employee = employee;
    }
}
