package matheus.leao.psiassistente.appointment.dtos;


import matheus.leao.psiassistente.appointment.entities.MedsTreatment;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class CreateAppointmentDto {
    String cpf;
    Date date;
    String notes;
    List<MedsTreatment> medsTreatment;

    public CreateAppointmentDto(String cpf, Date date, String notes, List<MedsTreatment> medsTreatment) {
        this.cpf = cpf;
        this.date = date;
        this.notes = notes;
        this.medsTreatment = medsTreatment;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void setMedsTreatment(List<MedsTreatment> medsTreatment) {
        this.medsTreatment = medsTreatment;
    }
}

