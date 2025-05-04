const { postCharacter, getAllCharacters } = require('../scripts/characterApi.js');

// Mock fetch
global.fetch = jest.fn(() =>
    Promise.resolve({
        ok: true,
        json: () => Promise.resolve([{ name: 'Test Character', race: 'Elf', characterClass: 'Wizard' }])
    })
);

describe('Character API', () => {
    beforeEach(() => {
        fetch.mockClear();
    });

    test('postCharacter sends POST request and returns data', async () => {
        const character = { name: 'Test Character'}
        const result = await postCharacter(character);

        expect(fetch).toHaveBeenCalledTimes(1);
        expect(fetch).toHaveBeenCalledWith(expect.stringContaining('/characters'), expect.objectContaining({
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(character)
        }));
    });

    test('getAllCharacters sends GET request and returns data', async () => {
        const result = await getAllCharacters();

        expect(fetch).toHaveBeenCalledTimes(1);
        expect(Array.isArray(result)).toBe(true);
    });

    test('assigns standard array values to ability scores', () => {
        document.body.innerHTML = `
            <input id="strength">
            <input id="dexterity">
            <input id="constitution">
            <input id="intelligence">
            <input id="wisdom">
            <input id="charisma">
            <button id="standard-array-btn"></button>
        `;

        require('../scripts/main.js'); // Assuming main.js contains the event listener

        document.getElementById('standard-array-btn').click();

        expect(document.getElementById('strength').value).toBe('15');
        expect(document.getElementById('dexterity').value).toBe('14');
        expect(document.getElementById('constitution').value).toBe('13');
        expect(document.getElementById('intelligence').value).toBe('12');
        expect(document.getElementById('wisdom').value).toBe('10');
        expect(document.getElementById('charisma').value).toBe('8');
    });
});