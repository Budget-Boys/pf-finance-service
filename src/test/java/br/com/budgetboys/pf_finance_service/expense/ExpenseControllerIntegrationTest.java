package br.com.budgetboys.pf_finance_service.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import javax.print.attribute.standard.Media;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExpenseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private UUID userId;
    private static String expenseId;

    @BeforeEach
    public void setUp() {
        userId = UUID.randomUUID();
    }

    @Test
    @Order(1)
    void shouldCreateExpense() throws Exception {
        String json = String.format("""
                    {
                        "amount": 100.0,
                        "category": "FUEL",
                        "userId": "%s"
                    }
                """, userId);
        mockMvc.perform(post("/expenses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath(    "$.category").value("FUEL"));
    }

    @Test
    @Order(2)
    void shouldFindAllExpenses() throws Exception {
        String responseBody = mockMvc.perform(get("/expenses"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        expenseId = JsonPath.read(responseBody, "$[0].id");
    }

    @Test
    @Order(3)
    void shouldFindExpenseById() throws Exception {
        mockMvc.perform(get("/expenses/{id}", expenseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount").value(100.0));
    }

    @Test
    @Order(4)
    void shouldDeleteExpense() throws Exception {
        mockMvc.perform(delete("/expenses/{id}", expenseId))
                .andExpect(status().isOk());
    }

}
