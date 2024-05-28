console.log("rrrr");





    document.getElementById("isSecret").addEventListener("change", function() {
        // 체크박스가 체크되었는지 확인
        var isChecked = this.checked;
    console.log(isChecked);
    console.log(document.getElementById("isSecret").value);
        // 체크박스 상태에 따라 값을 설정
        if (isChecked) {
            this.value = "true";
        } else {
            this.value = "false";
        }
    });



