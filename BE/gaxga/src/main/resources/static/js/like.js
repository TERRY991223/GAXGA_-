var likeBefore = document.querySelector('#like_before')
var likeAfter = document.querySelector('#like_after')


window.addEventListener("load", function() {
    const userId = document.querySelector("#like_input").value;
    const gabowatdagoId = document.querySelector("#new-comment-gabowatdago_id").value;
    const likeStatus = localStorage.getItem(`likeStatus_${userId}_${gabowatdagoId}`);
    if (likeStatus === "liked") {
        likeBefore.style.display = "none";
        likeAfter.style.display = "inline-block";
    } else {
        likeBefore.style.display = "inline-block";
        likeAfter.style.display = "none";
    }
});

//좋아요 버튼 이벤트처리
likeBefore.addEventListener("click",function(){
    // 좋아요 상태를 로컬 스토리지에 저장
    const userId = document.querySelector("#like_input").value;
    const gabowatdagoId = document.querySelector("#new-comment-gabowatdago_id").value;
    localStorage.setItem(`likeStatus_${userId}_${gabowatdagoId}`, "liked");
    // 버튼 표시 변경
    likeBefore.style.display = "none";
    likeAfter.style.display = "inline-block";

    const like ={
        userId : document.querySelector("#like_input").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value,

};
    // 좋아요 수를 가져와서 1을 더한 후에 엘리먼트에 적용
    const likeCountElement = document.querySelector(".likeCount");
    const currentLikeCount = parseInt(likeCountElement.innerText.split('명')[0]);
    likeCountElement.innerText = (currentLikeCount + 1) + '명이 좋아요 한 게시글입니다';

    console.log(like);
    const url = "/api/gabowatdago/like"
    fetch(url, {
        method: "POST",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(like)
    }).then(response =>{
        const msg = (response.ok)? "좋아요 추가 성공" : "좋아요 추가 실패";
        alert(msg);
    })
})

likeAfter.addEventListener("click", function(){
    // 좋아요 상태를 로컬 스토리지에서 제거
    const userId = document.querySelector("#like_input").value;
    const gabowatdagoId = document.querySelector("#new-comment-gabowatdago_id").value;
    localStorage.removeItem(`likeStatus_${userId}_${gabowatdagoId}`);

    // 버튼 표시 변경
    likeBefore.style.display = "inline-block";
    likeAfter.style.display = "none";
    const like = {
        userId: document.querySelector("#like_input").value,
        gabowatdagoId: document.querySelector("#new-comment-gabowatdago_id").value
    };
    const likeCountElement = document.querySelector(".likeCount");
    const currentLikeCount = parseInt(likeCountElement.innerText.split('명')[0]);
    likeCountElement.innerText = (currentLikeCount - 1) + '명이 좋아요 한 게시글입니다';
    console.log(like);
    const url = "/api/gabowatdago/like"
    fetch(url, {
        method: "DELETE",
        headers :{
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(like)
    }).then(response =>{
        const msg = (response.ok)? "좋아요 삭제 성공" : "좋아요 삭제 실패";
        alert(msg);
    })

})

