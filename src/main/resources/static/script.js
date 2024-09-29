(async () => {
    const response = await fetch ("/api/songs");
    const songs = await response.json();
    const songsUl = document.getElementById("songs");

    for (const song of songs){
        songsUl.innerHTML += ` <li>${song.id}.${song.title}.${song.type} (${song.length}  min)</li>` ;
    }
})();