const divs = document.querySelectorAll('#profile');

divs.forEach((div) => {
	div.addEventListener('click', function() {
		const userid = div.querySelector('#userId').value;
		const usernick = div.querySelector('#userNick').value;
		console.log(userid);
		$.ajax({
			type: 'GET',  // 또는 'GET' (컨트롤러 메서드에 따라 다름)
			url: 'matchingPage/matchingProfile',  // 실제 엔드포인트로 교체
			data: { "userId": userid ,
				    "userNick" : usernick},
			success: function(response) {
				console.log(response)
				const detail = document.querySelector("#profileModal")
				detail.classList.remove('hidden');
				detail.html("");
				let content = `
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h1 class="modal-title fs-5" id="exampleModalLabel">의 프로필카드</h1>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
							</div>
						<div class="modal-body">
					<br> <br>
				</div>
				<div class="modal-footer">
					<a href="chat/"><button type="button" class="btn btn-primary">채팅하기</button></a>
				</div>
			</div>
		</div>
				`;
			detail.append(content);
			},
			error: function(error) {
				console.error(error);
			}
		});
	});
});