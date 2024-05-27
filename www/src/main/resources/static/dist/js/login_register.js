const signUpBtn = document.getElementById("signUp");
const signInBtn = document.getElementById("signIn");
const container = document.querySelector(".containerLR");

signUpBtn.addEventListener("click", () => {
  container.classList.add("right-panel-active");
});
signInBtn.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

// 아이디 중복체크
document.getElementById('checkBtn').addEventListener('click',(e)=>{
    let email = document.getElementById("email").value;
    let check = document.getElementById('check');
    let checkBtn = document.getElementById('checkBtn');
    console.log(email);
    emailToServer(email).then(result =>{
        console.log(result);
        if(result == 1){
            alert("사용불가 아이디 입니다.");
            check.innerHTML = "";
            check.innerHTML = `<p class="text-danger">중복된 아이디 입니다.</p>`;

        }else{
            check.innerHTML = "";
            check.innerHTML = `<p class="text-success ischeckid">사용 가능 아이디 입니다.</p>`;
            checkBtn.style.display="none";
           

        }
    })

});

document.getElementById('email').addEventListener('keyup',()=>{
    checkBtn.style.display="";
    check.innerHTML = "";
});

//아이디 중복체크 비동기 메서드
async function emailToServer(email){
    try {
        const url = "/member/emailCheck/"+email;
        const resp = await fetch(url);
        const result = resp.text();

        return result;
    } catch (error) {
        console.log(error);
    }
}

//비밀번호 이중 확인 및 회원가입 버튼 관리
document.getElementById('pwdCheck').addEventListener('keyup',()=>{
    let pwd = document.getElementById('pwd').value;
    let pwdCheck = document.getElementById("pwdCheck").value;
    let checkpwd = document.getElementById('checkpwd');
    if(pwd == pwdCheck){
        document.getElementById("pwd").style.color = "green";
        pwdCheck = document.getElementById("pwdCheck").style.color = "green";
        pwdCheck.innerHTML = "";
        checkpwd.innerHTML = `<p class="text-success ischeckpwd">비밀번호 체크 완료되었습니다.</p>`;
    }else{
        document.getElementById("pwd").style.color = "red";
        pwdCheck = document.getElementById("pwdCheck").style.color = "red";
                pwdCheck.innerHTML = "";
                checkpwd.innerHTML = `<p class="text-danger">비밀번호를 다시 확인해주세요.</p>`;
    }

});

//회원가입 버튼 관리
document.addEventListener('keyup',()=>{

    let nickName = document.getElementById('nickName').value;
    let phone = document.getElementById('phone').value;
    let idcheck = document.querySelector('.ischeckid').innerText; //아이디 중복체크 성공했을 때 생김
    let pwdcheck = document.querySelector('.ischeckpwd').innerText; //비밀번호 체크 성공했을 떄 생김
    console.log(nickName);
    console.log(phone);
    console.log(idcheck);
    console.log(pwdcheck);

    if((idcheck !== null)&&(pwdcheck !== null)&&(nickName !== "")&&(phone !== "")){
        document.querySelector(".form_btn").disabled = false;
    }
    


});