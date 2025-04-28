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
});