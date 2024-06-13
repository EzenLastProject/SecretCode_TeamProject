
    function likeReview(button) {
        var bno = button.getAttribute('data-bno');
        if (!bno) {
            console.error('Bno is null');
            return;
        }
        // 좋아요 버튼을 비활성화합니다.
        button.disabled = true;
        // 해당 버튼의 형제 요소인 싫어요 버튼을 활성화합니다.
        button.nextElementSibling.disabled = false;

        console.log(`likeCountSpan_${bno}`); // 콘솔 출력

        fetch('/review/like/' + bno, {
            method: 'POST'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // 서버 응답에 따라 버튼 텍스트 업데이트
            var likeText = '👍';
            button.textContent = likeText;
            // 해당 리뷰의 공감수를 업데이트합니다.
            document.getElementById(`likeCountSpan_${bno}`).innerText = '공감수: ' + data.likes;
        })
        .catch(error => console.error('Error:', error));
    }

    function dislikeReview(button) {
        var bno = button.getAttribute('data-bno');
        if (!bno) {
            console.error('Bno is null');
            return;
        }
        // 싫어요 버튼을 비활성화합니다.
        button.disabled = true;
        // 해당 버튼의 형제 요소인 좋아요 버튼을 활성화합니다.
        button.previousElementSibling.disabled = false;

        console.log(`likeCountSpan_${bno}`); // 콘솔 출력

        fetch('/review/dislike/' + bno, {
            method: 'POST'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // 서버 응답에 따라 버튼 텍스트 업데이트
            var dislikeText = '👎';
            button.textContent = dislikeText;
            // 해당 리뷰의 공감수를 업데이트합니다.
            document.getElementById(`likeCountSpan_${bno}`).innerText = '공감수: ' + data.likes;
        })
        .catch(error => console.error('Error:', error));
    }

   /* //수정버튼

    document.getElementById("modBtn").addEventListener("click", function() {

    });*/
