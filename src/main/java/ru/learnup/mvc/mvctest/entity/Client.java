package ru.learnup.mvc.mvctest.entity;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long clientID;

    @Column(name = "initials_client")
    private String initialsClient;

    @Column(name = "birth_date")
    private String birthDate;

    public Client() {
    }

    public Client(String initialsClient, String birthDate) {
        this.initialsClient = initialsClient;
        this.birthDate = birthDate;
    }

    public String getInitialsClient() {
        return initialsClient;
    }

    public void setInitialsClient(String initialsClient) {
        this.initialsClient = initialsClient;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}