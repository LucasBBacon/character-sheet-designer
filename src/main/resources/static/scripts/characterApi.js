const API_URL = "http://localhost:8080/characters";

async function postCharacter(character) {
    console.log('Posting character: ', character);
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: { 'Content-Type' : 'application/json' },
        body: JSON.stringify(character)
    });
    if (!response.ok) {
        throw new Error('Failed to create character');
    }
    return await response.json();
}

async function getAllCharacters() {
    const response = await fetch(API_URL);
    if (!response.ok) {
        throw new Error('Failed to fetch characters');
    }
    return await response.json();
}

// Export for testing
if (typeof module !== 'undefined') {
    module.exports = { postCharacter, getAllCharacters };
}