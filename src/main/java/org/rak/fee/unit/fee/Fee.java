package org.rak.fee.unit.fee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * @author Hamza
 * @created 1/23/2024 - 12:51 AM
 * @project Microservices-assessment
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity
@Table(name = "fee")
public class Fee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uuid") private String uuid;
	@Column(name = "description") private String description;
	@Column(name = "type") private String type;
	@Column(name = "sub_category") private String subCategory;
	@Column(name = "frequency") private String frequency;
	@Column(name = "category") private String category;
	@Column(name = "amount") private String amount;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Fee fee = (Fee) o;
		return id != null && Objects.equals(id, fee.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
