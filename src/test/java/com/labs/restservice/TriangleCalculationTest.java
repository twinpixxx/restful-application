package com.labs.restservice;

import com.labs.restservice.calculations.CalculationService;
import com.labs.restservice.exception.ApiException.ApiRequestException;
import com.labs.restservice.exception.InternalException.InternalArithmeticException;
import com.labs.restservice.triangle.Triangle;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TriangleCalculationTest {

	private CalculationService calculationService;
	private Triangle triangle;
	private int[][] testData = new int[][]{{3, 4, 5}, {15, 22, 17}, {158, 287, 357}};
	private long[][] overflowTestData = new long[][]{{1231241241, 1241235125, 1241215161}};
	private int[][] exceptionTestData = new int[][]{{1, 2, 3}, {15, 42, 17}, {158, 587, 357}};


	@Test
	public void TriangleCreation() throws ApiRequestException {
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(exceptionTestData).forEach(v -> {
				triangle = new Triangle(v[0], v[1], v[2]);
			});
		});
		assertThat(thrown).isInstanceOf(ApiRequestException.class);
		assertThat(thrown.getMessage()).isNotBlank();
	}

	@Test
	public void PerimeterCalculation() {
		Arrays.stream(testData).forEach(v -> {
			triangle = new Triangle(v[0], v[1], v[2]);
			calculationService = new CalculationService(triangle);
			long perimeter = v[0] + v[1] + v[2];
			assertEquals(perimeter, calculationService.getPerimeter());
		});
	}

	@Test
	public void PerimeterIntOverflow() throws InternalArithmeticException {
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(overflowTestData).forEach(v -> {
				triangle = new Triangle(v[0], v[1], v[2]);
				calculationService = new CalculationService(triangle);
				long perimeter = calculationService.getPerimeter();
			});
		});
		assertThat(thrown).isInstanceOf(InternalArithmeticException.class);
		assertThat(thrown.getMessage()).isNotBlank();
	}

	@Test
	public void AreaCalculation() {
		Arrays.stream(testData).forEach(v -> {
			triangle = new Triangle(v[0], v[1], v[2]);
			calculationService = new CalculationService(triangle);
			double halfPerimeter = ((v[0] + v[1] +v[2])/2);
			double area = sqrt(halfPerimeter *
					(halfPerimeter - v[0]) *
					(halfPerimeter - v[1]) *
					(halfPerimeter - v[2]));
			assertEquals(area, calculationService.getArea(), 0.0001);
		});
	}

}