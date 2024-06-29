package web.service.restful.device_management.Models.entities;

import jakarta.persistence.*;
import lombok.*;
import web.service.restful.device_management.Models.enums.DeviceType;

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

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Device(String type) {
        try {
            this.type = DeviceType.valueOf(type);
        } catch (IllegalArgumentException e) {

        }
    }

    public Device(DeviceType type, boolean available, boolean assigned, boolean underMaintenance, boolean decommissioned, Employee employee) {
        this.type = type;
        this.available = available;
        this.assigned = assigned;
        this.underMaintenance = underMaintenance;
        this.decommissioned = decommissioned;
        this.employee = employee;
    }
}
