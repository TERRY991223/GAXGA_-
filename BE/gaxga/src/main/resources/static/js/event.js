//마우스 오버 이미지 바꾸기
const ing_event=document.querySelector('.ingEvent');
const exit_event=document.querySelector('.exit_event');
const change = document.querySelector(".image_box1 .change_image");

const ing_box = document.querySelector('#ing_box');
const exit_box = document.querySelector('#exit_box');

const image_box1 = document.querySelector(".side_image1");
const image_box2 = document.querySelector(".side_image2");
const image_box3 = document.querySelector(".side_image3");

const image_src1 = document.querySelector(".side_image1 img").src;
const image_src2 = document.querySelector(".side_image2 img").src;
const image_src3 = document.querySelector(".side_image3 img").src;

const button1 = document.querySelector("#num1");
const button2 = document.querySelector("#num2");
const button3 = document.querySelector("#num3");

const myDiv1 = document.querySelector('.text1');
const myDiv2 = document.querySelector('.text2');
const myDiv3 = document.querySelector('.text3');

ing_event.addEventListener("click", function(){
   ing_box.style.display="inline-block"
   exit_box.style.display = "none";
});
// event2.js 에서 가져온 변수들도 사용.
exit_event.addEventListener("click", function(){
  const changeImage2 = decodeURIComponent(new URL(exit_image1).pathname);
  const changeImage3 = decodeURIComponent(new URL(exit_image2).pathname);
  const changeImage4 = decodeURIComponent(new URL(exit_image3).pathname);
    exit_box.style.display ="inline-block";
    ing_box.style.display ="none";
  if(changeImage4.includes("img/이벤트디폴트배너L.png")){
    image3.src = "img/이벤트디폴트배너L.png";
    image3.style.display = "inline-block";
    exit_change1.style.display = "none";
    exit_change2.style.display = "none";
    exit_change3.style.display = "inline-block";
    exit_text3.style.display = "none";
  }else if(changeImage2.includes("img/이벤트진행중배너1L.png")){
    image1.src = "img/이벤트진행중배너1L.png";
    image1.style.display = "inline-block"
    exit_change1.style.display = "inline-block";
    exit_change2.style.display = "none";
    exit_change3.style.display = "none";
    exit_text1.style.display = "inline-block";
  }else if(changeImage3.includes("img/이벤트진행중배너2L.png")){
    image2.src = "img/이벤트진행중배너2L.png"
    image2.style.display = "inline-block";
    exit_text2.style.display = "inline-block";
    exit_change1.style.display = "none";
    exit_change2.style.display = "inline-block";
    exit_change3.style.display = "none";
  } else {
    image3.src = "img/이벤트진행중배너3L.png";
    image3.style.display = "inline-block";
    exit_text3.style.display = "inline-block";
    exit_change1.style.display = "none";
    exit_change2.style.display = "none";
    exit_change3.style.display = "inline-block";
  }
});

// 마우스 오버되면 상세보기 끄기 / 이미지 바꾸기
image_box1.addEventListener("mouseover", function(){
  let imageSrc = decodeURIComponent(new URL(image_src1).pathname);

    change.src="/img/이벤트진행중배너1L.png"
    myDiv2.style.display = "none"
    myDiv3.style.display = "none"
    //마우스 오버 시 div 클래스 변경
    button1.style.display ="inline-block"
    button2.style.display ="none"
    button3.style.display ="none"
  if(imageSrc.includes("/img/이벤트진행중배너1L.png")){
    change.src = "/img/이벤트진행중배너1L.png"
  }else{
    change.src = "/img/이벤트디폴트배너L.png"
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="none"
  }
});

image_box2.addEventListener("mouseover", function(){
  let imageSrc = decodeURIComponent(new URL(image_src2).pathname);

    change.src="/img/이벤트진행중배너2L.png"
    //마우스오버 상세정보 사라지기
    myDiv1.style.display = "none"
    myDiv3.style.display = "none"
    //마우스 오버 시 div 클래스 변경
    button1.style.display ="none"
    button2.style.display ="inline-block"
    button3.style.display ="none"
  if(imageSrc.includes("/img/이벤트진행중배너2L.png")){
    console.log(imageSrc)
    change.src = "/img/이벤트진행중배너2L.png"
  }else{
    console.log(imageSrc)
    change.src = "/img/이벤트디폴트배너L.png"
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="none"
  }
});
image_box3.addEventListener("mouseenter", function(){
  let imageSrc = decodeURIComponent(new URL(image_src3).pathname);

  change.src="/img/이벤트진행중배너3L.png"

    myDiv1.style.display = "none"
    myDiv2.style.display = "none"
    //마우스 오버 시 div 클래스 변경
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="inline-block"
  if(imageSrc.includes("/img/이벤트진행중배너3L.png")){
    change.src = "/img/이벤트진행중배너3L.png"
  }else{
    change.src = "/img/이벤트디폴트배너L.png"
    button1.style.display ="none"
    button2.style.display ="none"
    button3.style.display ="none"
  }
});

//버튼으로 상세 정보 출력
function btnClick1() {
  const myDiv = document.querySelector('.text1');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}

function btnClick2() {
  const myDiv = document.querySelector('.text2');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}

function btnClick3() {
  const myDiv = document.querySelector('.text3');

  const isVisible = window.getComputedStyle(myDiv).display === 'none';

  // 상세정보가 보이지 않는 경우에만 보이도록 설정
  if(!isVisible) {
    myDiv.style.display = 'none';
  }else {
    myDiv.style.display = 'inline-block';
  }
}