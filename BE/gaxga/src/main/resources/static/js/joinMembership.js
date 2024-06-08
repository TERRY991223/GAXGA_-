const findAddressBtn = document.querySelector("#find_Address");

findAddressBtn.addEventListener("click", sample6_execDaumPostcode);
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("postal").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}


document.getElementById("submitBtn").addEventListener("click", function (){
    const userEmail = document.getElementById("userEmail").value;
    const emailType = document.getElementById("emailType").value;
    document.getElementById("combinedEmail").value = userEmail + "@" + emailType;
    console.log(userEmail + "@" + emailType);
});

function validateForm() {
    const gaId = document.getElementById("gaId").value;
    const gaPass = document.getElementById("gaPass").value;
    const gaNick = document.getElementById("gaNick").value;
    const gaPhone = document.getElementById("gaPhone").value;
    if (gaId.length < 4 || gaId.length > 12) {
        alert("아이디는 4~12글자여야 합니다.");
        document.getElementById("gaId").focus();
        return false;
    }else if (gaPass.length < 8 || gaPass.length > 12) {
        alert("비밀번호는 8~12글자여야 합니다.");
        document.getElementById("gaPass").focus();
        return false;
    }else if (gaNick.length < 4 || gaNick.length > 12) {
        alert("닉네임는 4~12글자여야 합니다.");
        document.getElementById("gaNick").focus();
        return false;
    }else if (gaPhone.length !== 13) {
        alert("핸드폰 입력이 잘못되었습니다.");
        document.getElementById("gaPhone").focus();
        return false;
    }
    return true;
}
