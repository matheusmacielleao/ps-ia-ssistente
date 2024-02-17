package matheus.leao.psiassistente.patient;

import matheus.leao.psiassistente.patient.useCases.CreatePatient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patient")
public class PatientController {
    private final CreatePatient createPatient;

    public PatientController(CreatePatient createPatient) {
        this.createPatient = createPatient;
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patientData){
        Patient newPatient = createPatient.execute(patientData.getCpf(), patientData.getName(), patientData.getEmail(), patientData.getGender() ,patientData.getPhone(), patientData.getBirthDate());
        return newPatient;
    }
}
