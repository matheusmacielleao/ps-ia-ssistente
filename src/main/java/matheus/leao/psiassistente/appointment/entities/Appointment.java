package matheus.leao.psiassistente.appointment.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import matheus.leao.psiassistente.patient.Patient;

import java.util.Date;
import java.util.List;

@Entity
public class Appointment {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    String id;
    @ManyToOne()
    @JsonIgnore
    Patient pacient;
    @Column
    Date date;
    @Column(columnDefinition="TEXT")
    String notes;
    @OneToMany(mappedBy = "appointment", fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    List<MedsTreatment> medsTreatment;

    public Appointment(Patient pacient, Date date, String notes, List<MedsTreatment> medsTreatment) {
        this.pacient = pacient;
        this.date = date;
        this.notes = notes;
        this.medsTreatment = medsTreatment;
    }

    public Appointment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Patient getPacient() {
        return pacient;
    }

    public void setPacient(Patient pacient) {
        this.pacient = pacient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<MedsTreatment> getMedsTreatment() {
        return medsTreatment;
    }

    public void setMedsTreatment(List <MedsTreatment> medsTreatment) {
        this.medsTreatment = medsTreatment;
    }
}


