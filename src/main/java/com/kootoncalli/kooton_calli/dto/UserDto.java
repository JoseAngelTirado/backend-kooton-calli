package com.kootoncalli.kooton_calli.dto;

public class UserDto {

    private Integer id;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private String phone;

    public UserDto() {}

    public UserDto(Integer id, String email, String password, String name, String lastName, String phone) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;  
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserDto [");
        sb.append("id=").append(id)
        .append(", email=").append(email)
        .append(", password=").append(password)
        .append(", name=").append(name)
        .append(", lastName=").append(lastName)
        .append(", phone=").append(phone)
        .append("]");
        return sb.toString();
    }

}
