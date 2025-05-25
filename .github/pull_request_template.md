```
# 💸 Pull Request – pf-finance-service

## 📋 Descrição do que foi feito

<!-- Explique claramente o que essa PR entrega -->
<!-- Ex: Adicionado endpoint POST /transactions para registrar novas transações -->

---

## 🧪 Como testar

Subir o projeto:

```bash
docker compose up --build
```

Testes manuais sugeridos:
- [ ] POST /transactions registra corretamente
- [ ] GET /transactions retorna lista esperada

---

## ✅ Checklist

- [ ] PR não introduz breaking changes em endpoints existentes
- [ ] Código está formatado e indentado corretamente
- [ ] Docker sobe sem erro
- [ ] Atualizou `application.properties` ou `docker-compose.yml` se necessário

---

## 🔧 Testes automatizados

- [ ] Adicionou testes de unidade/integração
- [ ] Executou `./gradlew test` com sucesso

---

```