package web.service.restful.device_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.service.restful.device_management.Models.entities.Employee;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID>, PagingAndSortingRepository<Employee, UUID> {

    @Query("SELECT e.email FROM Employee e")
    public List<String> getAllEmails();

    @Query("SELECT e.username FROM Employee e")
    public List<String> getAllUsernames();


}
