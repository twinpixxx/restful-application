package com.labs.restservice;

import com.labs.restservice.calculations.CalculationService;
import com.labs.restservice.exception.ApiException.ApiRequestException;
import com.labs.restservice.exception.InternalException.InternalArithmeticException;
import com.labs.restservice.triangle.Triangle;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TriangleCalculationTest {

	private static final Logger log = LoggerFactory.getLogger(TriangleCalculationTest.class);
	private CalculationService calculationService;
	private Triangle triangle;
	private int[][] testData = new int[][]{{3, 4, 5}, {15, 22, 17}, {158, 287, 357}};
	private long[][] overflowTestData = new long[][]{{1231241241, 1241235125, 1241215161}};
	private int[][] exceptionTestData = new int[][]{{1, 2, 3}, {15, 42, 17}, {158, 587, 357}};


	@Test
	public void TriangleCreation() throws ApiRequestException {
		log.info("Triangle creation test started");
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(exceptionTestData).forEach(v -> {
				triangle = new Triangle(v[0], v[1], v[2]);
			});
		});
		assertThat(thrown).isInstanceOf(ApiRequestException.class);
		assertThat(thrown.getMessage()).isNotBlank();
		log.info("Triangle creation test passed");
	}

	@Test
	public void PerimeterCalculation() {
		log.info("Perimeter calculation test started");
		Arrays.stream(testData).forEach(v -> {
			triangle = new Triangle(v[0], v[1], v[2]);
			calculationService = new CalculationService(triangle);
			long perimeter = v[0] + v[1] + v[2];
			assertEquals(perimeter, calculationService.getPerimeter());
		});
		log.info("Perimeter calculation test passed");
	}

	@Test
	public void PerimeterIntOverflow() throws InternalArithmeticException {
		log.info("Perimeter value overflow test started");
		Throwable thrown = catchThrowable(() -> {
			Arrays.stream(overflowTestData).forEach(v -> {
				triangle = new Triangle(v[0], v[1], v[2]);
				calculationService = new CalculationService(triangle);
				long perimeter = calculationService.getPerimeter();
			});
		});
		assertThat(thrown).isInstanceOf(InternalArithmeticException.class);
		assertThat(thrown.getMessage()).isNotBlank();
		log.info("Perimeter value overflow test passed");
	}

	@Test
	public void AreaCalculation() {
		log.info("Area calculation test started");
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
		log.info("Area calculation test passed");
	}

}