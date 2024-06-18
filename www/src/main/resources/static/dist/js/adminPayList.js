console.log('hi');


document.addEventListener('DOMContentLoaded', () => {
    document.addEventListener('click', (e) => {
        if (e.target.classList.contains('hwanboolBtn')) {
            const row = e.target.closest('tr');
            const reservationNum = row.cells[0].textContent;

            hwanbool(reservationNum).then(result => {
                console.log(result);
                alert('정말 환불처리를 하시겠습니까?');
                if (result === '1') {
                    alert('환불 처리가 성공적으로 완료되었습니다');
                    window.location.reload();
                }
            });
        }
    });

    async function hwanbool(reservationNum) {
        try {
            const url = `/portOnePay/${reservationNum}`;
            const config = {
                method: "delete",
                headers: {
                    "content-type": "application/json; charset=utf-8"
                }
            };

            const resp = await fetch(url, config);
            const result = await resp.text();
            return result;
        } catch (error) {
            console.log(error);
        }
    }
});
