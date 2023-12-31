package com.hackathon.diasporadialog.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hackathon.diasporadialog.domain.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "verification_link")
    private String verificationLink;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    @ColumnDefault("true")
    private boolean enabled;

    @Column(name = "is_verified", columnDefinition = "boolean default false")
    @ColumnDefault("false")
    private boolean verified;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    private List<MessageEntity> messages;
}