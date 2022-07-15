package entity;

import java.util.Date;
import java.util.Objects;

public class Users {
    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String email;
    private boolean isActive;
    private boolean isDeleted;
    private boolean isBlocked;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    private Date created_at;
    private Date updated_at;

    public Users(Long id, String username, String fullName, String password, String phoneNumber, String email, boolean isActive, boolean isDeleted, boolean isBlocked, Date created_at, Date updated_at) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isActive = isActive;
        this.isDeleted = isDeleted;
        this.isBlocked = isBlocked;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Users(Long id, String username,
                 String fullName, String password,
                 String phoneNumber, String email,
                 Date created_at,
                 Date updated_at)
    {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Users(String username,
                 String fullName,
                 String password, String phoneNumber,
                 String email, Date created_at,
                 Date updated_at)
    {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", isDeleted=" + isDeleted +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return username.equals(users.username)
                && fullName.equals(users.fullName)
                && password.equals(users.password) &&
                phoneNumber.equals(users.phoneNumber) &&
                email.equals(users.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fullName, password, phoneNumber, email);
    }
}

