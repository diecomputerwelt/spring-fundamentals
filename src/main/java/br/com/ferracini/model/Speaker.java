package br.com.ferracini.model;

import javax.persistence.*;

@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    public Long getSpeakerId() {
        return speaker_id;
    }

    public void setSpeakerId(Long speakerId) {
        this.speaker_id = speakerId;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeakerBio() {
        return speaker_bio;
    }

    public void setSpeakerBio(String speakerBio) {
        this.speaker_bio = speakerBio;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "speakerId=" + speaker_id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", speakerBio='" + speaker_bio + '\'' +
                '}';
    }
}
