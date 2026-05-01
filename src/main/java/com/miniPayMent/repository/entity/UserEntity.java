package com.miniPayMent.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private Integer age;

    @Column(name = "personal_id", length = 10)
    private String personalId;
    private String status;

    @Column(name = "create_at")
    private Date createAt;
}
