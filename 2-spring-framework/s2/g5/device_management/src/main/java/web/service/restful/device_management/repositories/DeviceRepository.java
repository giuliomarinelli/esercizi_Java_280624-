package web.service.restful.device_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.service.restful.device_management.Models.entities.Device;
import web.service.restful.device_management.Models.entities.Employee;
import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID>, PagingAndSortingRepository<Device, UUID> {

}
