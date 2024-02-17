package matheus.leao.psiassistente.patient.useCases;
import matheus.leao.psiassistente.patient.Patient;
import matheus.leao.psiassistente.patient.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CreatePatient {
    private final PatientRepository patientRepository;

    public CreatePatient(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient execute(String cpf, String name, String email, String gender,String phone, Date birthDate) {
        this.validateUniqueCpf(cpf);

        Patient patient = new Patient(cpf, name, gender,email ,phone, birthDate);
        this.patientRepository.save(patient);
        return patient;
    }

    private void validateUniqueCpf(String cpf) {
        if (this.patientRepository.existsById(cpf)) {
            throw new RuntimeException("CPF already exists");
        }
    }
}
