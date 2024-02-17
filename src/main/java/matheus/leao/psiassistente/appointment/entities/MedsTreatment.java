package matheus.leao.psiassistente.appointment.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class MedsTreatment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name="appointment_id")
    Appointment appointment;
    @Column
    String medication;
    @Column
    Integer doseInMg;
    @Column
    Integer frequencyPerDay;

    public MedsTreatment(Appointment appointment, String medication, Integer doseInMg, Integer frequencyPerDay) {
        this.appointment = appointment;
        this.medication = medication;
        this.doseInMg = doseInMg;
        this.frequencyPerDay = frequencyPerDay;
    }

    public MedsTreatment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public Integer getDoseInMg() {
        return doseInMg;
    }

    public void setDoseInMg(Integer doseInMg) {
        this.doseInMg = doseInMg;
    }

    public Integer getFrequencyPerDay() {
        return frequencyPerDay;
    }

    public void setFrequencyPerDay(Integer frequencyPerDay) {
        this.frequencyPerDay = frequencyPerDay;
    }
}
