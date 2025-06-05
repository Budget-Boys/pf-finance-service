package br.com.budgetboys.pf_finance_service.income;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IncomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private UUID userId;
    private static String incomeId;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
    }

    @Test
    @Order(1)
    void shouldCreateIncome() throws Exception {
        String json = String.format("""
                    {
                        "amount": "100.0",
                        "category": "INVESTMENTS",
                        "userId": "%s"
                    }
                """, userId);
        mockMvc.perform(post("/incomes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.category").value("INVESTMENTS"));
    }

    @Test
    @Order(2)
    void shouldFindAllIncomes() throws Exception {
        String responseBody = mockMvc.perform(get("/incomes"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        incomeId = JsonPath.read(responseBody, "$[0].id");
    }

    @Test
    @Order(3)
    void shouldFindIncomeBydId() throws Exception {
        mockMvc.perform(get("/incomes/{id}", incomeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(100.0));
    }

    @Test
    @Order(4)
    void shouldDeleteIncome() throws Exception {
        mockMvc.perform(delete("/incomes/{id}", incomeId))
                .andExpect(status().isOk());
    }
}
