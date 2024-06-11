//전화번호 자동 하이픈 생성
const autoHyphen2 = (target) => {
    target.value = target.value
      .replace(/[^0-9]/g, '')
     .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
   }
   


var IMP = window.IMP;
IMP.init("imp40772235");


function calculatePrice() {
    var selectElement = document.getElementById("participants");
    var selectedValue = selectElement.value;
    console.log(selectedValue);
    var price = 0;

    // 인원수에 따라 가격 설정
    switch(selectedValue) {
        case "1":
            price = 25000;
            break;
        case "2":
            price = 46000;
            break;
        case "3":
            price = 60000;
            break;
        case "4":
            price = 72000;
            break;
        case "5":
            price = 85000;
            break;
        case "6":
            price = 90000;
            break;
        default:
            price = 25000;
    }

    // 가격을 화면에 표시
    document.getElementById("price").value = price;
}

document.getElementById("participants").addEventListener('change',()=>{
// 페이지 로드시 초기화
calculatePrice();
});

//  //결제 후 예약 DB 작업 비동기 메서드
//  async function phoneToServer(date, time, theme, name, phone, email, participants, price){
//     try {
//         const url = "/portOnePay/reservation/"+date+"/"+time+"/"+theme+"/"+name+"/"+phone+"/"+email+"/"+participants+"/"+price;
//         const resp = await fetch(url);
//         const result = await resp.text();

//         return result;
//     } catch (error) {
//         console.log(error);
//     }
//   }



function requestPay() {
    let date = document.getElementById('date').value; //예약일
    let time = document.getElementById('time').value; //시간
    let theme = document.getElementById('theme').value; //테마명
    let name = document.getElementById('name').value; //예약자
    let phone = document.getElementById('phone').value; //휴대폰번호
    let email = document.getElementById('email').value; //이메일
    let participants = document.getElementById('participants').value; //인원수
    let price = document.getElementById('price').value; //가격

  
    
    IMP.request_pay(
        {
            pg: "html5_inicis",		//KG이니시스 pg파라미터 값
            pay_method: "card",		//결제 방법
            merchant_uid: date+time+participants,//주문번호
            name: theme,		//상품 명
            amount: price,			//금액
              buyer_email: email,
              buyer_name: name,
              buyer_tel: phone,
        },
        function (rsp) {
              //rsp.imp_uid 값으로 결제 단건조회 API를 호출하여 결제결과를 판단합니다.
            if (rsp.success) {
                //서버 검증 요청 부분
                $.ajax({
                    url: "/payment/validate/" + rsp.imp_uid,
                    method: "GET",
                    contentType: "application/json",
                    data: JSON.stringify({
                        imp_uid: rsp.imp_uid,            // 결제 고유번호
                        merchant_uid: rsp.merchant_uid,   // 주문번호
                        amount: rsp.paid_amount
                    }),
                }).done(function (data) {
                    // 가맹점 서버 결제 API 성공시 로직












                })

            } else {
                alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
            }
        }
    );
}