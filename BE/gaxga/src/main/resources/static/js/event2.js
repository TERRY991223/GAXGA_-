const exit_image_box1 = document.querySelector(".side_exit_image1");
const exit_image_box2 = document.querySelector(".side_exit_image2");
const exit_image_box3 = document.querySelector(".side_exit_image3");

const exit_image1 = document.querySelector(".side_exit_image1 img").src;
const exit_image2 = document.querySelector(".side_exit_image2 img").src;
const exit_image3 = document.querySelector(".side_exit_image3 img").src;

const exit_change1 = document.querySelector('#image_box2')
const exit_change2 = document.querySelector('#image_box3')
const exit_change3 = document.querySelector('#image_box4')

const image1 = document.querySelector('#image_box2 .change_image')
const image2 = document.querySelector('#image_box3 .change_image')
const image3 = document.querySelector('#image_box4 .change_image')

const exit_text1 = document.querySelector('#image_box2 .exit_text')
const exit_text2 = document.querySelector('#image_box3 .exit_text')
const exit_text3 = document.querySelector('#image_box4 .exit_text')

// 종료된 이벤트에서 마우스 오버되면 이미지랑 내용 바꾸기
exit_image_box1.addEventListener("mouseover", function(){
    const imageSrc1 = decodeURIComponent(new URL(exit_image1).pathname);
        image1.src = "/img/이벤트진행중배너1L.png";
        image1.style.display = "inline-block";
        image2.style.display = "none";
        image3.style.display = "none";

        exit_change1.style.display="inline-block";
        exit_change2.style.display="none";
        exit_change3.style.display="none";
    if(imageSrc1.includes("/img/이벤트진행중배너1L.png")){
        exit_text1.style.display = "inline-block";
        exit_text2.style.display="none"
        exit_text3.style.display="none"
    }else {
        image1.src = "/img/이벤트디폴트배너L.png"
        exit_text1.style.display = "none";
    }
})

exit_image_box2.addEventListener("mouseover", function(){
    const imageSrc2 = decodeURIComponent(new URL(exit_image2).pathname);
        image2.src = "/img/이벤트진행중배너2L.png";
        image1.style.display = "none";
        image2.style.display = "inline-block";
        image3.style.display = "none";

        exit_change2.style.display="inline-block";
        exit_change1.style.display="none";
        exit_change3.style.display="none";

    if(imageSrc2.includes("/img/이벤트진행중배너2L.png")){
        exit_text1.style.display="none"
        exit_text2.style.display = "inline-block";
        exit_text3.style.display="none"
    }else {
        exit_text2.style.display = "none";
        image2.src = "/img/이벤트디폴트배너L.png"
    }
})

exit_image_box3.addEventListener("mouseover", function(){
    const imageSrc3 = decodeURIComponent(new URL(exit_image3).pathname);
        image3.src = "/img/이벤트진행중배너3L.png";
        image1.style.display = "none";
        image2.style.display = "none";
        image3.style.display = "inline-block";

        exit_change3.style.display="inline-block";
        exit_change1.style.display="none";
        exit_change2.style.display="none";
    if(imageSrc3.includes("/img/이벤트진행중배너3L.png")){
        exit_text1.style.display="none"
        exit_text2.style.display="none"
        exit_text3.style.display="inline-block";
    }else {
        image3.src = "img/이벤트디폴트배너L.png"
        exit_text3.style.display="none";
    }
})