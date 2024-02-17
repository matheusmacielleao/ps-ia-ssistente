package matheus.leao.psiassistente.appointment.useCases;

import matheus.leao.psiassistente.appointment.entities.Appointment;
import matheus.leao.psiassistente.appointment.AppointmentRepository;
import matheus.leao.psiassistente.appointment.entities.MedsTreatment;
import matheus.leao.psiassistente.openai.OpenAiService;
import matheus.leao.psiassistente.patient.Patient;
import matheus.leao.psiassistente.patient.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CreateAppointment {
    private final OpenAiService openAiService;
    private final AppointmentRepository appointmentRepository;

    private final PatientRepository patientRepository;

    public CreateAppointment(OpenAiService openAiService, AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.openAiService = openAiService;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public Appointment execute(String cpf, Date date, String notes, List<MedsTreatment> medsTreatment) {
        Patient patientExists = patientRepository.getReferenceById(cpf);
        String processedNotes = this.processNotes(notes);
        Appointment appointment = new Appointment();
        appointment.setPacient(patientExists);
        appointment.setDate(date);
        appointment.setNotes(processedNotes);
        List<MedsTreatment> mappedMeds = new ArrayList<>();
        for(MedsTreatment meds : medsTreatment){
            MedsTreatment med = new MedsTreatment();
            med.setAppointment(appointment);
            med.setMedication(meds.getMedication());
            med.setDoseInMg(meds.getDoseInMg());
            med.setFrequencyPerDay(meds.getFrequencyPerDay());
            mappedMeds.add(med);
        }
        appointment.setMedsTreatment(mappedMeds);
        appointmentRepository.save(appointment);
        return appointment;
    }

    private String processNotes(String notes) {
        return this.openAiService.getAnswer("monte um resumo em bullet points das notas do paciente, separe os por ';':" + notes);
    }

}
