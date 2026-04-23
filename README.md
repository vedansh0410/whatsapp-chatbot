# WhatsApp Chatbot Backend — Spring Boot + PostgreSQL

## Setup

### 1. Create PostgreSQL database
```sql
CREATE DATABASE chatbot_db;
```

### 2. Update application.properties
```properties
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### 3. Run
```bash
mvn spring-boot:run
```

---

## API

### POST /webhook

**Request:**
```json
{
  "sender": "+919876543210",
  "message": "Hi"
}
```

**Response:**
```json
{
  "to": "+919876543210",
  "reply": "Hello"
}
```

### Predefined Replies

| Message | Reply   |
|---------|---------|
| Hi      | Hello   |
| Bye     | Goodbye |

---

## Test with cURL

```bash
curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"sender":"+919876543210","message":"Hi"}'

curl -X POST http://localhost:8080/webhook \
  -H "Content-Type: application/json" \
  -d '{"sender":"+919876543210","message":"Bye"}'
```
