package com.udacity.pricing;

import static org.mockito.BDDMockito.*;


import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import com.udacity.pricing.service.PricingService;

//@ExtendWith(MockitoExtension.class)	
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PricingServiceApplicationTests {
//DONE ADD TEST
    // Test to check if the application context loads
	@MockBean
	PriceRepository priceRepository;

	@MockBean
	PricingService pricingService;

	@Autowired
    private MockMvc mvc;

	@Test
	public void testGetPrice() throws Exception {
		//given
		Long vehicleId = 1L;
		Price price = new Price("USD", new BigDecimal(1000), vehicleId);
		given(priceRepository.findById(vehicleId)).willReturn(Optional.of(price));
		given(pricingService.getPrice(vehicleId)).willReturn(price);
				
		//when 
		mvc.perform(MockMvcRequestBuilders.get("/services/price?vehicleId=1")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.currency").value("USD"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(1000))
		.andExpect(MockMvcResultMatchers.jsonPath("$.vehicleId").value(1));
	}
}
