package com.example.mgt.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(name="created_at", nullable=false,updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
@JsonIgnore
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
@JsonIgnore
private Date updatedAt;
	
@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}
}
