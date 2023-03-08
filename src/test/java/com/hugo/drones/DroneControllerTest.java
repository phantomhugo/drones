package com.hugo.drones;

import com.hugo.drones.exceptions.DroneNotFoundException;
import com.hugo.drones.model.Drone;
import com.hugo.drones.restservice.DroneController;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author hugo
 */
@SpringBootTest
@ContextConfiguration(classes = DronesApplication.class)
//@WebMvcTest(DroneController.class)
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DroneController droneController;

    @Test
    public void getDrone() throws DroneNotFoundException, Exception {
        Drone drone = new Drone();
        drone.setSerialNumber("QWE");
        drone.setModel(0);

        given(droneController.getDrone(anyString())).willReturn(drone);

        mvc.perform(get("/drone/1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.serialNumber", is(drone.getSerialNumber())));
    }
}
