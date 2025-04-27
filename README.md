# Character Sheet Designer

An online backend service for creating Dungeons and Dragons homebrew characters, built with Java and Spring Boot.

---

## Features (MVP)

- Create a new character (name, race, class)
- Retrieve character information by ID
- With TDD (Test Driven Development)
- Easy to extend with homebrew rules

---

## Tech Stack

- Java 17
- Spring Boot 3
- Maven
- JUnit 5

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+

### Running Locally

1. Clone the project:

```bash
git clone https://github.com/lucasbbacon/character-sheet-deisgner.git
cd character-sheet-designer
```

2. Build the project:

```bash
mvn spring-boot:run
```
Application will run on http://localhost:8080

---

### API Endpoints:
- `POST /api/characters` - Create a new character
- `GET /api/characters/{id}` - Retrieve character information by ID

---

### Example Request

Create a new character:
```bash
curl -X POST http://localhost:8080/characters \
    -H "Content-Type: application/json" \
    -d '{"name": "John", "race": "Human", "characterClass": "Warrior"}'
```

Retrieve a Character:
```bash
curl http://localhost:8080/characters/1
```

---

### Running Tests:

```bash
mvn test
```

---

## Future Ideas

- Add ability scores, background, and equipment
- Support saving/loading characters from a database
- Build a simple frontend to interact with the API
- Export character sheets as PDF

---

## License

This project is for personal and educational use with friends.
Feel free to fork and modify for your own campaigns!