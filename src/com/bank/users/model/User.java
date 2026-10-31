package com.bank.users.model;

import java.util.Set;

/**
 * Core user class. Other modules (Account, Wallet, Request, Loan) should
 * hold a reference to a User (or its id), e.g.  private User owner;
 */
public class User {

    private long id;
    private String username;
    private String email;
    private String password; // always the PBKDF2 hash, never the raw password
    private Role role;
    private String phoneNumber;

    public User(long id, String username, String email, String password, Role role, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    /** Authorities of this user, e.g. {"ROLE_USER"}. */
    public Set<String> getAuthorities() {
        return Set.of("ROLE_" + role.name());
    }

    public boolean hasRole(Role... roles) {
        for (Role r : roles) {
            if (this.role == r) return true;
        }
        return false;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    /** Safe to print: does not include the password hash. */
    @Override
    public String toString() {
        return "User{id=" + id + ", username='" + username + "', email='" + email
                + "', role=" + role + ", phoneNumber='" + phoneNumber + "'}";
    }
}
