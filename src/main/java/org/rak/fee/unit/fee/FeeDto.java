package org.rak.fee.unit.fee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class FeeDto {

	@JsonProperty("uuid") private String uuid;
	@NotBlank @JsonProperty("description") private String description;
	@NotBlank @JsonProperty("type") private String type;
	@NotBlank @JsonProperty("subCategory") private String subCategory;
	@NotBlank @JsonProperty("frequency") private String frequency;
	@NotBlank @JsonProperty("category") private String category;
	@NotBlank @JsonProperty("amount") private String amount;
}
