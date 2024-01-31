package org.rak.fee.fee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rak.fee.unit.fee.Fee;
import org.rak.fee.unit.fee.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest

public class FeeRepoTest {

    @Autowired
    private FeeRepository feeRepository;

    @BeforeEach
    void setUp() {
        String type = "Type";
        String category = "Category";
        String subCategory = "SubCategory";
        String frequency = "Frequency";
        feeRepository.save(Fee.builder().id(1L).uuid("123").frequency(frequency).type(type).amount("12")
                .category(category)
                .description("alpha").subCategory(subCategory).build());
    }

    @Test
    public void testFindByTypeAndCategoryAndSubCategoryAndFrequency() {
        // Given
        String type = "Type";
        String category = "Category";
        String subCategory = "SubCategory";
        String frequency = "Frequency";

        Fee feeEntity = Fee.builder().id(1L).uuid("123").frequency(frequency).type(type).amount("12")
                .category(category)
                .description("alpha").subCategory(subCategory).build();

        Optional<Fee> result = feeRepository.findByTypeAndCategoryAndSubCategoryAndFrequency(type, category, subCategory, frequency);

        assertTrue(result.isPresent());
        assertEquals(feeEntity, result.get());
    }

    @Test
    public void testExistsByTypeAndCategoryAndSubCategoryAndFrequency() {
        // Given
        String type = "Type";
        String category = "Category";
        String subCategory = "SubCategory";
        String frequency = "Frequency";


        boolean result = feeRepository.existsByTypeAndCategoryAndSubCategoryAndFrequency(type, category, subCategory, frequency);

        assertTrue(result);
    }

}
