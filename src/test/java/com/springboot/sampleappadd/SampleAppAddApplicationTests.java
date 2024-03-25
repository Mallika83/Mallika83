package com.springboot.sampleappadd;

import com.springboot.sampleappadd.Model.Inputs;
import com.springboot.sampleappadd.Service.addService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SampleAppAddApplicationTests {

	@Autowired
	private addService service;
	private Inputs inputsTest = new Inputs(456f,899f);

	@Test
	void addNumbersTest(){

		float actualSum = service.addNumbers(inputsTest);
		assertEquals(1355,actualSum,0.0f);

	}

}
