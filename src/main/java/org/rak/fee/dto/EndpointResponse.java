package org.rak.fee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ProblemDetail;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndpointResponse<T> {

	T data;
	ProblemDetail problemDetail;

	public EndpointResponse(ProblemDetail problemDetail) {
		this.problemDetail = problemDetail;
	}
}
