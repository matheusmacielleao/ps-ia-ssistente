package matheus.leao.psiassistente.patient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import matheus.leao.psiassistente.appointment.entities.Appointment;

import java.util.Date;
import java.util.List;

@Entity
public class Patient {

    @Id
    private String cpf;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String gender;
    @Column
    private Date birthDate;
    @OneToMany(mappedBy = "pacient")
    @JsonIgnore
    private List<Appointment> appointments;

    public Patient(String cpf, String name, String gender,String email, String phone,Date birthDate){
        this.cpf = cpf;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Patient() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
