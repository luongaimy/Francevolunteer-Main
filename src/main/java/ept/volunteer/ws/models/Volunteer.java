package ept.volunteer.ws.models;

import javax.persistence.Id;

public class Volunteer {

    @Id
    private Long volunteerId;

    private String gender;

    private String firstName;

    private String lastName;

    private String dob;
    private String address;

    private String postalCode;

    private String city;
    private String country;

    private String phoneNumber;

    private String actionArea;

    private String missionType;
    private String availability;

    private String professionalSituation;

    private String professionalDetail;

    private String possiableDisplacement;

    private String travelType;

    private String email;
    private String password;

    private Integer privacyRequiredRule;

    private Integer privacyGetPromotion;

    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getActionArea() {
        return actionArea;
    }

    public void setActionArea(String actionArea) {
        this.actionArea = actionArea;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getProfessionalSituation() {
        return professionalSituation;
    }

    public void setProfessionalSituation(String professionalSituation) {
        this.professionalSituation = professionalSituation;
    }

    public String getProfessionalDetail() {
        return professionalDetail;
    }

    public void setProfessionalDetail(String professionalDetail) {
        this.professionalDetail = professionalDetail;
    }

    public String getPossiableDisplacement() {
        return possiableDisplacement;
    }

    public void setPossiableDisplacement(String possiableDisplacement) {
        this.possiableDisplacement = possiableDisplacement;
    }

    public String getTravelType() {
        return travelType;
    }

    public void setTravelType(String travelType) {
        this.travelType = travelType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPrivacyRequiredRule() {
        return privacyRequiredRule;
    }

    public void setPrivacyRequiredRule(Integer privacyRequiredRule) {
        this.privacyRequiredRule = privacyRequiredRule;
    }

    public Integer getPrivacyGetPromotion() {
        return privacyGetPromotion;
    }

    public void setPrivacyGetPromotion(Integer privacyGetPromotion) {
        this.privacyGetPromotion = privacyGetPromotion;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "volunteerId=" + volunteerId +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", actionArea='" + actionArea + '\'' +
                ", missionType='" + missionType + '\'' +
                ", availability='" + availability + '\'' +
                ", professionalSituation='" + professionalSituation + '\'' +
                ", professionalDetail='" + professionalDetail + '\'' +
                ", possiableDisplacement='" + possiableDisplacement + '\'' +
                ", travelType='" + travelType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", privacyRequiredRule=" + privacyRequiredRule +
                ", privacyGetPromotion=" + privacyGetPromotion +
                '}';
    }
}
