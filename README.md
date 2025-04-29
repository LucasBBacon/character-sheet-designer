# Character Sheet Designer
![Build](https://github.com/LucasBBacon/character-sheet-designer/actions/workflows/ci.yml/badge.svg)

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

## API Endpoints:
| Method | Endpoint                      | Description                           |
|:------:|:------------------------------|:--------------------------------------|
|  POST  | `/characters`                 | Create a new character                |
|  GET   | `/characters/{id}`            | Retrieve character                    |
|  PUT   | `/characters/{id}`            | Update character                      |
| DELETE | `/characters/{id}`            | Delete character                      |
|  GET   | `/characters`                 | List all characters                   |
|  GET   | `/characters/races`           | List all allowed races                |
|  GET   | `/characters/races/{race}`    | List all characters filtered by race  |
|  GET   | `/characters/classes`         | List all allowed classes              |
|  GET   | `/characters/classes/{class}` | List all characters filtered by class |

Use these endpoints to dynamically fetch allowed values:
- `GET /characters/races` -> Returns a list of allowed Races
- `GET /characters/classes` -> Returns a list of allowed Classes

---

## Validation Rules

### When creating a character:

- **Name** must not be blank and maximum of 50 characters
- **Race** must be one of:
  - HUMAN
  - ELF
  - DWARF
  - HALFLING
  - ORC
  - GOBLIN
  - TIEFLING
  - DRAGONBORN
  - AASIMAR
  - GENASI
  - KOBOLD
  - BUGBEAR
  - FIRBOLG
  - TABAXI
  - TORTLE
  - LIZARDFOLK
  - CENTAUR
  - MINOTAUR
  - SATYR
  - YUAN_TI
- **Class** must be one of:
  - BARBARIAN
  - BARD
  - CLERIC
  - DRUID
  - FIGHTER
  - MONK
  - PALADIN
  - RANGER
  - ROGUE
  - SORCERER
  - WARLOCK
  - WIZARD
  - ARTIFICER
  - BLOOD_HUNTER
- **Background** must not be blank
- **Alignment** must not be blank
- **Ability Scores** (Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma) must be between 1 and 20

If any validation rule is violated, the server will respond with **400 Bad Request** and detailed error message.

---

## Example Request

### Create a new character:

POST `/characters`

Body:
```json
{
  "name": "John", 
  "race": "HUMAN", 
  "characterClass": "WARRIOR",
  "background": "Soldier",
  "alignment": "Lawful Good",
  "strength": 15,
  "dexterity": 12,
  "constitution": 14,
  "intelligence": 10,
  "wisdom": 8,
  "charisma": 13
}
```

### Updating a character:
PUT `/characters/{id}`

Body: (Similar to post but updated fields)

### Delete a character:
DELETE `/characters/{id}`

No body required.

### Retrieve a Character:
```bash
curl http://localhost:8080/characters/1
```

### Filtering by Race or Class

GET `/characters/race/{race}`

GET `/characters/class/{characterClass}`

---

## Running Tests:

```bash
mvn test
```

---

## Future Ideas

- Add ability score generation methods (point buy, dice roll, standard array)
- Calculate ability modifiers based on scores
- Background and equipment
- Support saving/loading characters from a database
- Build a simple frontend to interact with the API
- Export character sheets as PDF

---

## License

This project is for personal and educational use with friends.
Feel free to fork and modify for your own campaigns!