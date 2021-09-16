package com.maheshb.springbootkafkaintro.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Data
public class TagEntity implements Persistable<UUID> {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private UUID id;

	@Column(name = "timestamp")
	private Long timestamp;

	@Column(name = "value")
	private Double value;

	@Column(name = "tagName")
	private String tagName;
	
	@CreatedDate
	private LocalDateTime createdDate;

	public TagEntity(Long timestamp, Double value, String tagName) {
		super();
		this.timestamp = timestamp;
		this.value = value;
		this.tagName = tagName;
	}

	@Override
	public boolean isNew() {
		return true;
	}

}
