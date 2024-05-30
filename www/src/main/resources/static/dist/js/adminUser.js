console.log("ㅋㅋ");

document.getElementById('deleteBtn').addEventListener('click', ()=>{
    const memberListEmail = document.getElementById('memberListEmail').value;

    if(memberListEmail){
        alert('계정을 탈퇴시키겠습니까?');
        return false;
    }
    else{
        let cmtData = {
            email : memberListEmail

        }
        deleteUserToServer(cmtData).then(result => {
            if(result === '1'){
                alert('탈퇴가 완료되었습니다.');
            }
            else {
                alert('탈퇴 실패');
            }
        });
        
    }
    
})







async function deleteUserToServer(cmtData){

    try {
        const url = '/delete';
        const config ={
            method : 'delete',
            headers : {
                'content-type' : 'application/json; charset = utf-8'
            },
            body : JSON.stringify(cmtData)
        };

        const resp = await fetch(url, config);
        const result = await resp.text();
        return result;
    } catch (error) {
        console.log(error);
    }
}

