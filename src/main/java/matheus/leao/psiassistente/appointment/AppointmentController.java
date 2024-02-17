package matheus.leao.psiassistente.appointment;

import matheus.leao.psiassistente.appointment.dtos.CreateAppointmentDto;
import matheus.leao.psiassistente.appointment.entities.Appointment;
import matheus.leao.psiassistente.appointment.useCases.CreateAppointment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    private final CreateAppointment createAppointment;

    public AppointmentController(CreateAppointment createAppointment) {
        this.createAppointment = createAppointment;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody CreateAppointmentDto appointmentData){
        return createAppointment.execute(appointmentData.getCpf(), appointmentData.getDate(), appointmentData.getNotes(), appointmentData.getMedsTreatment());
    }
}
