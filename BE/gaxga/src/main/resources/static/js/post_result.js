document.addEventListener("DOMContentLoaded", function() {
    const sliderWrap = document.querySelector(".slider__wrap");
    const imageNames = document.querySelector(".slider__img").innerText;

    if (imageNames) {
        const images = imageNames.split(',').map(imageName => `/upload/${encodeURIComponent(imageName.trim())}`);
        imageSlider(sliderWrap, images);
    } else {
        console.error('슬라이더 이미지를 찾을 수 없습니다.');
    }
});

function imageSlider(parent, images) {
    let currentIndex = 0;
    let slider = {
        parent: parent,
        images: parent.querySelector(".slider__img"),
        thumbnails: parent.querySelector(".slider__thumb"),
        prevBtn: parent.querySelector(".slider__btn .prev"),
        nextBtn: parent.querySelector(".slider__btn .next")
    };

    slider.images.innerHTML = images.map((image, index) => {
        return `<img src="${image}" alt="이미지${index}">`;
    }).join("");

    let imageNodes = slider.images.querySelectorAll("img");
    imageNodes[currentIndex].classList.add("active");

    slider.thumbnails.innerHTML = slider.images.innerHTML;
    let thumbnailNodes = slider.thumbnails.querySelectorAll("img");
    thumbnailNodes[currentIndex].classList.add("active");

    thumbnailNodes.forEach((thumb, index) => {
        thumb.addEventListener("click", function() {
            thumbnailNodes[currentIndex].classList.remove("active");
            thumbnailNodes[index].classList.add("active");
            imageNodes[currentIndex].classList.remove("active");
            currentIndex = index;
            imageNodes[currentIndex].classList.add("active");
        });
    });

    slider.prevBtn.addEventListener("click", () => {
        imageNodes[currentIndex].classList.remove("active");
        currentIndex--;
        if (currentIndex < 0) currentIndex = images.length - 1;
        imageNodes[currentIndex].classList.add("active");
        thumbnailNodes[currentIndex].classList.remove("active");
        thumbnailNodes[currentIndex].classList.add("active");
    });

    slider.nextBtn.addEventListener("click", () => {
        imageNodes[currentIndex].classList.remove("active");
        thumbnailNodes[currentIndex].classList.remove("active");
        currentIndex = (currentIndex + 1) % images.length;
        imageNodes[currentIndex].classList.add("active");
        thumbnailNodes[currentIndex].classList.add("active");
    });
}
// ------------------------------------------------------지도------------------

// 지도를 표시할 div 요소
var lat = parseFloat(document.getElementById('latitude').value);
var lng = parseFloat(document.getElementById('longitude').value);

document.getElementById("test").addEventListener("click", function (){
    console.log(lng);
    console.log(lat);
})
// 좌표로 지도를 생성하고 마커 표시
let mapContainer = document.getElementById('maps'),
    mapOption = {
    center: new daum.maps.LatLng(lng,lat),
    level: 3 // 지도의 확대 레벨
};

let map = new daum.maps.Map(mapContainer, mapOption);

let markerPosition = new daum.maps.LatLng(lng,lat);

// 마커 생성
let marker = new daum.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정
marker.setMap(map);



//-----------------------------------------------------------------------
// 삭제버튼 클릭 알림창
function delOk() {
    if (confirm('삭제하시면 복구할 수 없습니다.\n정말로 삭제하시겠습니까?')) {
        return true;
    } else {
        return false;
    }
}
// 댓글  작성 기능
const commentCreateBtn = document.querySelector("#comment-save");

commentCreateBtn.addEventListener("click", function () {
    event.preventDefault();
    const comment = {
        nickname: document.querySelector("#client").value,
        body: document.querySelector("#comment").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value
    };

    console.log(comment);
    const url = "/api/gabowatdago/" + comment.gabowatdagoId + "/cmts";
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(comment)
    }).then(response => {
        if(comment.body.trim() === ""){
            alert("댓글 내용을 입력해주세요")
        }else if (response.ok) {
            alert("댓글 등록 완료");
            // 댓글이 성공적으로 등록되었을 때 페이지를 새로 고침
            window.location.reload();
        }else {
            alert("댓글 등록 실패");
        }
    });
});
const commentDeleteBtns = document.querySelectorAll("#deleteBtn")
//삭제 버튼 이벤트 처리
commentDeleteBtns.forEach(btn => {
    btn.addEventListener("click", (event) =>{ //이벤트 객체 받아와서
        // 이벤트 발생 요소 선택
        const commentDeleteBtn = event.target; //삭제 버튼 변수화
        //삭제 댓글 id 가져오기
        const commentId = commentDeleteBtn.getAttribute("data-comment-id");
        console.log(`삭제 버튼 클릭 : ${commentId}번 댓글`);
        //삭제 REST API 호출
        const url = `/api/cmts/${commentId}`
        if(confirm('삭제하시면 복구할 수 없습니다.\n정말로 삭제하시겠습니까?')) {
            fetch(url, {
                method: "DELETE"
            }).then(response => {
                //댓글 삭제 실패 처리
                if (!response.ok) {
                    alert("댓글 삭제 실패");
                    return;
                }
                const msg = "댓글 삭제 완료";
                alert(msg);
                window.location.reload();
            })
        } else{
            return false
        }
    });
});

