
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
function confirmDelete() {
    // 삭제 전에 확인 알림창을 띄웁니다.
    if (confirm('정말로 삭제하시겠습니까?')) {
        // 사용자가 확인을 선택한 경우에만 true를 반환합니다.
        // 여기에 삭제를 처리하는 코드를 작성합니다.
        console.log('사용자가 확인을 선택했습니다.');
        // 여기에 삭제를 처리하는 로직을 추가할 수 있습니다.
    } else {
        // 사용자가 취소를 선택한 경우에 대한 처리를 할 수 있습니다.
        console.log('사용자가 취소를 선택했습니다.');
    }
}
function confirmUpdate() {
    // 수정 전에 확인 알림창을 띄웁니다.
    if (confirm('정말로 수정하시겠습니까?')) {
        // 사용자가 확인을 선택한 경우에만 true를 반환합니다.
        // 여기에 수정을 처리하는 코드를 작성합니다.
        console.log('사용자가 확인을 선택했습니다.');
        // 여기에 수정을 처리하는 로직을 추가할 수 있습니다.
    } else {

        // 사용자가 취소를 선택한 경우에 대한 처리를 할 수 있습니다.
        console.log('사용자가 취소를 선택했습니다.');
    }
}
  function submitForm() {
        document.getElementById('themeForm').submit();
    }



