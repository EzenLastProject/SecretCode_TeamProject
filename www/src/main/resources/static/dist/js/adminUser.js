console.log("ㅋㅋ");

document.getElementById('deleteBtn').addEventListener('click', () => {
    const memberListEmail = document.getElementById('memberListEmail').innerText;

    if (memberListEmail) {
        if (confirm('계정을 탈퇴시키겠습니까?')) {
            let cmtData = {
                email: memberListEmail
            };

            deleteUserToServer(cmtData).then(result => {
                if (result === '1') {
                    alert('탈퇴가 완료되었습니다.');
                    location.reload();
                } else {
                    alert('탈퇴 실패');
                }
            });
        }
    } else {
        alert('유효한 이메일을 찾을 수 없습니다.');
    }
});

async function deleteUserToServer(cmtData) {
    try {
        const url = '/adminRegister/delete';
        const config = {
            method: 'delete',
            headers: {
                'content-type': 'application/json; charset=utf-8'
            },
            body: JSON.stringify(cmtData)
        };

        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}
