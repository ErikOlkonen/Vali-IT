package ee.bcs.valiit.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BankControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createAccount() throws Exception {
        // http://localhost:8080/bank/createAccount?accountNr=EE123&customer_id=1
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/createAccount?accountNr=EE123&customer_id=1")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void accountBalance() throws Exception {
        // http://localhost:8080/bank/accountBalance?accountNr=EE124
        mockMvc.perform(MockMvcRequestBuilders.get("/bank/accountBalance?accountNr=EE123")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void depositMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/depositMoney?accountNr=EE123&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    void withdrawMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/withdrawMoney?accountNr=EE123&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void transferMoney() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/transferMoney?fromAccount=EE123&toAccount=EE124&amount=12")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void createCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bank/createCustomer?firstName=Peeter&lastName=Puu")
                .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}