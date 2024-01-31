package org.rak.fee.fee;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.rak.fee.unit.fee.FeeController;
import org.rak.fee.unit.fee.FeeDto;
import org.rak.fee.unit.fee.FeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FeeControllerTest.class)
public class FeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private FeeServiceImpl feeService;
    @Autowired
    private ObjectMapper objectMapper;

    @InjectMocks
    private FeeController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }


    @Test
    void testGetFee() throws Exception {
        // Mocked FeeDto from service
        FeeDto mockedFeeDto = new FeeDto("mockedUUID", "Mocked Description", "Mocked Type", "Mocked SubCategory", "Mocked Frequency", "Mocked Category", "Mocked Amount");

        // Mocking feeService.getFee
        when(feeService.getFee(anyString(), anyString(), anyString(), anyString())).thenReturn(mockedFeeDto);

        // Perform and verify
        mockMvc.perform(get("http://localhost:8082/fee/type/{type}/category/{category}/sub-category/{subCategory}/frequency/{frequency}", "type", "category", "subCategory", "frequency"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.uuid").value("mockedUUID"))
                .andExpect(jsonPath("$.data.description").value("Mocked Description"))
                .andExpect(jsonPath("$.data.type").value("Mocked Type"))
                .andExpect(jsonPath("$.data.subCategory").value("Mocked SubCategory"))
                .andExpect(jsonPath("$.data.frequency").value("Mocked Frequency"))
                .andExpect(jsonPath("$.data.category").value("Mocked Category"))
                .andExpect(jsonPath("$.data.amount").value("Mocked Amount"));
    }

    @Test
    void testAddFee() throws Exception {
        // Input FeeDto for the POST request
        FeeDto inputDto = new FeeDto("inputUUID", "Input Description", "Input Type", "Input SubCategory", "Input Frequency", "Input Category", "Input Amount");

        // Mocking businessService.create
        when(feeService.create(any(FeeDto.class))).thenReturn(inputDto);

        // Perform and verify
        mockMvc.perform(post("http://localhost:8082/fee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.uuid").value("inputUUID"))
                .andExpect(jsonPath("$.data.description").value("Input Description"))
                .andExpect(jsonPath("$.data.type").value("Input Type"))
                .andExpect(jsonPath("$.data.subCategory").value("Input SubCategory"))
                .andExpect(jsonPath("$.data.frequency").value("Input Frequency"))
                .andExpect(jsonPath("$.data.category").value("Input Category"))
                .andExpect(jsonPath("$.data.amount").value("Input Amount"));
    }


}


