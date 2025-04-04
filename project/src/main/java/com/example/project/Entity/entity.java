package com.example.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class entity {
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	@Column(name="pname")
	private String pname;
	@Column(name="pdescription")
	private String pdescription;
	@Column(name="owner")
	private String owner;
}