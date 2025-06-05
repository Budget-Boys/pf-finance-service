
# 💸 Pull Request – pf-finance-service

## 📋 Descrição do que foi feito

<!-- Explique claramente o que essa PR entrega -->
<!-- Ex: Adicionado endpoint POST /transactions para registrar novas transações -->

---

## 🧪 Como testar

Compilar projeto:

```bash
mvn clean package
```
Subir o projeto:

```bash
docker-compose up --build
```

Testes manuais sugeridos:
- [ ] POST /expenses registra corretamente
- [ ] GET /expenses retorna lista esperada
- [ ] GET /expenses/{id} retorna despesa esperada 

---

## ✅ Checklist

- [ ] PR não introduz breaking changes em endpoints existentes
- [ ] Código está formatado e indentado corretamente
- [ ] Docker sobe sem erro
- [ ] Atualizou `application.properties`,  `docker-compose.yml` ou `.env`' se necessário

---

## 🔧 Testes automatizados

- [ ] Adicionou testes de unidade/integração
- [ ] Executou `mvn test` com sucesso

---
