
// document.getElementById("reservationBtn").addEventListener('click',()=>{

//     let merchantUid = document.getElementById('merchantUid').value;

//     if(!merchantUid){
//         alert("주문번호를 넣어주세요.");
//     }else{

//         merchantUidToServer(merchantUid).then(result =>{
//             console.log(result);
//             if(!merchantUid){
//                 alert('주문번호를 다시 확인해주세요.')
//             }else{
//                 alert('주문번호를 확인하였습니다.')
//             }


//         });


//     }

// });

// //주문번호 비동기로 보내기
// async function merchantUidToServer(merchantUid){
//     try {
//         const url = "/portOnePay/reservationCheck/"+merchantUid;
//         const resp = await fetch(url);
//         const result = resp.json();

//         return result;
//     } catch (error) {
//         console.log(error);
//     }
// }

