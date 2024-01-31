package org.rak.fee.unit.fee;

import org.rak.fee.dto.EndpointResponse;
import org.rak.fee.interfaces.BusinessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fee")
public class FeeController {

	private BusinessService<FeeDto> businessService;
	private FeeServiceImpl feeService;

	public FeeController(BusinessService<FeeDto> businessService, FeeServiceImpl feeService) {
		this.businessService = businessService;
		this.feeService = feeService;
	}


	@GetMapping("/type/{type}/category/{category}/sub-category/{subCategory}/frequency/{frequency}")
	EndpointResponse<FeeDto> getFee(@PathVariable String type,
															@PathVariable String category,
															@PathVariable String subCategory,
															@PathVariable String frequency){
		return new EndpointResponse<>(feeService.getFee(type, category, subCategory, frequency),null);
	}

	@PostMapping
	EndpointResponse<FeeDto> addFee(@RequestBody FeeDto feeDto){
		return new EndpointResponse<>(feeService.create(feeDto), null);
	}

}
