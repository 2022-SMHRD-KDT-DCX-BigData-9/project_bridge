const divs = document.querySelectorAll('#profile');
const detail = document.querySelector(".profilemodal");

divs.forEach((div) => {
    div.addEventListener('click', function() {
        const user_id = div.querySelector('#user_id').value;
        console.log(user_id);
        $.ajax({
            type: 'GET',
            url: 'matchingPage/matchingProfile',
            data: { "user_id": user_id },
            success: function(response) {      
                const user_nick = div.querySelector('#user_nick').value;
                detail.classList.remove('hidden');
                detail.innerHTML = `
                    <div class="profile_body">
                        <p>${user_id}</p>
                        <p>${user_nick}</p>
                        <div class="profilesong"></div>
                        <a href="chat"><button>채팅하기</button></a>
						<button id = "closemodal">닫기</button>
                    </div>
                `;

                const song = document.querySelector(".profilesong");

                for (let i = 0; i < response.length; i++) {
                    let list = response[i];
                    let content = `
                        <div class="text">
                            <audio controls>
                                <source src="data:audio/mp3;base64,${list.song_file}" type="audio/mpeg">
                            </audio>
                            <h4 class="heading">
                                <span>${list.user_song_name}</span>
                                <span> - </span>
                                <span>${list.user_singer}</span>
                            </h4>
                            <span class="icon-person"> 2023-12-12</span>
                        </div>
                    `;
                    song.innerHTML += content; // innerHTML로 수정
                }

            },
            error: function(error) {
                console.error(error);
            }
        });
    });
});

document.addEventListener("click", (e) => {
    if (e.target.id === "closemodal") {
        detail.classList.add('hidden');
		detail.innerHTML = "";
    }
});