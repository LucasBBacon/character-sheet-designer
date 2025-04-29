document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('character-form');
    const characterList = document.getElementById('character-list');

    form.addEventListener('submit', async (event) => {
        event.preventDefault();

        const character = {
            name: document.getElementById('name').value,
            race: document.getElementById('race').value,
            characterClass: document.getElementById('class').value,
            background: document.getElementById('background').value,
            alignment: document.getElementById('alignment').value,
            strength: parseInt(document.getElementById('strength').value),
            dexterity: parseInt(document.getElementById('dexterity').value),
            constitution: parseInt(document.getElementById('constitution').value),
            intelligence: parseInt(document.getElementById('intelligence').value),
            wisdom: parseInt(document.getElementById('wisdom').value),
            charisma: parseInt(document.getElementById('charisma').value),
        };

        try {
            await postCharacter(character);
            alert('Character created successfully!');
            form.reset();
            await loadCharacters();
        } catch (error) {
            alert(error.message);
        }
    });

    async function loadCharacters() {
        characterList.innerHTML = '';
        try {
            const characters = await getAllCharacters();
            characters.forEach(c => {
                const li = document.createElement('li');
                li.textContent = `${c.name} - ${c.race} ${c.characterClass}`;
                characterList.appendChild(li);
            });
        } catch (error) {
            console.error(error);
        }
    }

    loadCharacters();
});