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
@Table(name="Task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class dataentity {
	@Id
	@Column(name="taskid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskid;
	@Column(name="taskname")
	private String taskname;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private String status;
	@Column(name="duedate")
	private String duedate;
}