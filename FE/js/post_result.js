// 댓글 스크립트 --------------
    //댓글 목록에 추가하기
    const comment = document.querySelector("#comment");
    const client = document.querySelector("#client");
    const comment_save= document.querySelector("#comment-save");
    const comment_list= document.querySelector(".comment-list");

    comment_save.addEventListener("click", function(e){
      e.preventDefault();

      const cmt = document.createElement("h1");
      cmt.innerHTML = `
      <pre>
      ${client.value}                           ${comment.value}
      <pre><button class="delButton">삭제</button>
      `;
      comment_list.appendChild(cmt);

      comment.value ="";
      client.value="";
      
      //댓글 삭제하기
      //삭제 버튼 가져오기
      const delButtons = document.querySelectorAll(".delButton"); // '삭제' 버튼 모두 가져오기

for (let delButton of delButtons) {
  delButton.addEventListener("click", function () {
    this.parentNode.parentNode.removeChild(this.parentNode);
    // 아래와 같이 변수를 사용할 수도 있음
    // let list = this.parentNode;
    // list.parentNode.removeChild(list);
  });
}
});
// 이미지 슬라이드

let images = [
  "../img/apsan.png",
  "../img/botanicgarden.png",
  "../img/tteokbokkitown.png",
  "../img/seongdangmos.png",
  "../img/sinposijang.png"
];

function imageSlider(parent, images){
  let currentIndex = 0;

  // 선택자
  let slider = {
      parent: parent,
      images: parent.querySelector(".slider__img"),
      thumbnails: parent.querySelector(".slider__thumb"),
      prevBtn: parent.querySelector(".slider__btn .prev"),
      nextBtn: parent.querySelector(".slider__btn .next")
  };

  // 이미지 출력하기
  slider.images.innerHTML = images.map((image, index) => {
      return `<img src="${image}" alt="이미지${index}">`;
  }).join("");

  // 이미지 활성화(active)하기
  let imageNodes = slider.images.querySelectorAll("img");
  imageNodes[currentIndex].classList.add("active");


  // 썸네일 이미지 출력하기
  slider.thumbnails.innerHTML = slider.images.innerHTML;

  // 썸네일 활성화(active)하기
  let thumnailNodes = slider.thumbnails.querySelectorAll("img");
  thumnailNodes[currentIndex].classList.add("active");

  // 썸네일 이미지 클릭하기_for문
  // for(let i=0; i<thumnailNodes.length; i++){
  //     thumnailNodes[i].addEventListener("click", function(){      //this값을 가져올 수 있음
  //         slider.thumbnails.querySelector("img.active").classList.remove("active");
  //         thumnailNodes[i].classList.add("active");

  //         imageNodes[currentIndex].classList.remove("active");
  //         currentIndex = i;
  //         imageNodes[currentIndex].classList.add("active");
  //     });
  // }
  
  // 썸네일 이미지 클릭하기_forEach()
  thumnailNodes.forEach((thumb, index) => {
      thumb.addEventListener("click", function(){
          thumnailNodes[currentIndex].classList.remove("active");
          thumnailNodes[index].classList.add("active");

          imageNodes[currentIndex].classList.remove("active");
          currentIndex = index;
          imageNodes[currentIndex].classList.add("active");
      });
  });

  // 왼쪽 버튼 클릭하기
  slider.prevBtn.addEventListener("click", () => {
      imageNodes[currentIndex].classList.remove("active");
      currentIndex--;
      
      // 0 4 3 2 1 0 4 3 2 1...
      if(currentIndex < 0) currentIndex = images.length - 1;

      imageNodes[currentIndex].classList.add("active");

      // 썸네일 버튼 클릭하기
      thumnailNodes[currentIndex].classList.remove("active");
      thumnailNodes[currentIndex].classList.add("active");
  });

  // 오른쪽 버튼 클릭하기
  slider.nextBtn.addEventListener("click", () => {
      imageNodes[currentIndex].classList.remove("active");
      thumnailNodes[currentIndex].classList.remove("active");

      // 1 2 3 4 0 1 2 3 4...
      currentIndex = (currentIndex + 1) % images.length;

      imageNodes[currentIndex].classList.add("active");
      thumnailNodes[currentIndex].classList.add("active");

      
  });

  
};

imageSlider(document.querySelector(".slider__wrap"), images);