package com.example.springpracticetamerlan.model;

import java.time.LocalDate;

import java.util.Objects;

public class User {
        private String email;
        private String nickname;
        private LocalDate birthdate;
        private String country;

        public User(String email, String nickname, LocalDate birthdate, String country) {
            this.email = email;
            this.nickname = nickname;
            this.birthdate = birthdate;
            this.country = country;
        }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }


}

