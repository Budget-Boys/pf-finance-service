package br.com.budgetboys.pf_finance_service.expense;

import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.ExpenseCategory;
import br.com.budgetboys.pf_finance_service.adapters.outbound.entities.enums.IncomeCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ExpenseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private UUID userId;

    @BeforeEach
    void setUp() {
        this.userId = UUID.randomUUID();
    }

    @Test
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
                .andExpect(jsonPath("$.category").value("FUEL"));
    }
}
