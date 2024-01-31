package org.rak.fee.fee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rak.fee.unit.fee.Fee;
import org.rak.fee.unit.fee.FeeDto;
import org.rak.fee.unit.fee.FeeMapperImpl;
import org.rak.fee.unit.fee.FeeRepository;
import org.rak.fee.unit.fee.FeeRequestValidatorImpl;
import org.rak.fee.unit.fee.FeeServiceImpl;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class FeeServiceTest {

    @InjectMocks
    private FeeServiceImpl feeService;

    @Mock
    private FeeRepository feeRepository;

    @Mock
    private FeeMapperImpl feeMapper;

    @Mock
    private FeeRequestValidatorImpl validator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        FeeDto inputDto = new FeeDto(/* add necessary fields */);
        Fee savedEntity = new Fee(/* add necessary fields */);
        when(validator.validateRequest(any(FeeDto.class))).thenReturn(true);
        when(feeMapper.toEntity(any(FeeDto.class))).thenReturn(savedEntity);
        when(feeRepository.save(any(Fee.class))).thenReturn(savedEntity);
        when(feeMapper.toDto(any(Fee.class))).thenReturn(inputDto);

        FeeDto resultDto = feeService.create(inputDto);

        assertNotNull(resultDto);

        verify(validator, times(1)).validateRequest(inputDto);
        verify(feeMapper, times(1)).toEntity(inputDto);
        verify(feeRepository, times(1)).save(savedEntity);
        verify(feeMapper, times(1)).toDto(savedEntity);
    }

    @Test
    void testGetFee() {
        // Given
        String type = "Type";
        String category = "Category";
        String subCategory = "SubCategory";
        String frequency = "Frequency";

        Fee feeEntity = new Fee(/* add necessary fields */);
        FeeDto expectedDto = new FeeDto(/* add necessary fields */);

        // Mocking behavior
        when(feeRepository.findByTypeAndCategoryAndSubCategoryAndFrequency(type, category, subCategory, frequency))
                .thenReturn(Optional.of(feeEntity));
        when(feeMapper.toDto(feeEntity)).thenReturn(expectedDto);

        // When
        FeeDto resultDto = feeService.getFee(type, category, subCategory, frequency);

        // Then
        assertNotNull(resultDto);
        assertEquals(expectedDto, resultDto);

        // Verify that repository method and mapper method were called with the correct arguments
        verify(feeRepository, times(1)).findByTypeAndCategoryAndSubCategoryAndFrequency(type, category, subCategory, frequency);
        verify(feeMapper, times(1)).toDto(feeEntity);
    }
}

