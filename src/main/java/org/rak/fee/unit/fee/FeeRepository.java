package org.rak.fee.unit.fee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeeRepository extends JpaRepository<Fee, Long> {

	Optional<Fee> findByTypeAndCategoryAndSubCategoryAndFrequency(String type, String category, String subCategory, String frequency);

	boolean existsByTypeAndCategoryAndSubCategoryAndFrequency(String type, String category, String subCategory, String frequency);
}
