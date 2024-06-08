// 날짜 스크립트
var today = new Date();
const date = document.querySelector(".date");
var year = today.getFullYear();
var month = ('0' + (today.getMonth() + 1)).slice(-2);
var day = ('0' + today.getDate()).slice(-2);
var dateString = year + '-' + month + '-' + day;
date.innerText = `${dateString}`;

//----------------------------------------------------------------------지도
// 기본 좌표 설정 (예: 서울 시청)
var defaultLat = 37.5665;
var defaultLng = 126.9780;

// 입력된 위도와 경도 값을 가져오거나 기본값 사용
var lat = parseFloat(document.getElementById('road_latitude').value)
var lng = parseFloat(document.getElementById('road_longitude').value)

var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(lng, lat), // 지도의 중심좌표를 미리 불러온 lat, lng로 설정
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption);
// 마커를 미리 생성
var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(lng, lat),
    map: map
});

// 주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();

function sample5_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            var addr = data.address; // 최종 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            document.getElementById("sample5_address").value = addr; // 주소 정보를 해당 필드에 넣는다.

            // 주소로 상세 정보를 검색
            geocoder.addressSearch(addr, function (results, status) {
                if (status === daum.maps.services.Status.OK) {
                    var result = results[0]; // 첫번째 결과의 값을 활용

                    const coords = new daum.maps.LatLng(result.y, result.x);
                    map.setCenter(coords); // 지도 중심을 변경
                    marker.setPosition(coords); // 마커 위치를 변경

                    // 폼 작성 시 위도 경도 데이터 보낼 변수 선언
                    document.getElementById("latitude").value = result.x;
                    document.getElementById("longitude").value = result.y;

                    // 사용자가 선택한 주소가 도로명 타입일 때 참고항목을 조합
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraRoadAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraRoadAddr !== '') {
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                    }
                    // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                    if (extraRoadAddr !== '') {
                        document.getElementById("sample5_extraAddress").value = extraRoadAddr;
                    } else {
                        document.getElementById("sample5_extraAddress").value = '';
                    }
                }
            });
        }
    }).open();
}









