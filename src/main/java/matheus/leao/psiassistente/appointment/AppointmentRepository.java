package matheus.leao.psiassistente.appointment;
import matheus.leao.psiassistente.appointment.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {

}
