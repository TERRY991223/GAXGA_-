//마우스 오버 이미지 바꾸기
  const ing_event=document.querySelector('.ingEvent');
  const exit_event=document.querySelector('.exit_event');
  const change_image = document.querySelector("#change_image");
  const ing_box = document.querySelector('#ing_box');
  const exit_box = document.querySelector('#exit_box');
  const image_box1 = document.querySelector(".side_image1");
  const image_box2 = document.querySelector(".side_image2");
  const image_box3 = document.querySelector(".side_image3");
  const exit_image_box1 = document.querySelector(".side_exit_image1");
  const exit_image_box2 = document.querySelector(".side_exit_image2");
  const exit_image_box3 = document.querySelector(".side_exit_image3");
  const button1 = document.querySelector("#num1");
  const button2 = document.querySelector("#num2");
  const button3 = document.querySelector("#num3");
  const mydiv1 = document.querySelector('.text1');
  const mydiv2 = document.querySelector('.text2');
  const mydiv3 = document.querySelector('.text3');
  const exit_change = document.querySelector('#image_box2')
  const exit_change2 = document.querySelector('#image_box3')
  const exit_change3 = document.querySelector('#image_box4')



  
    ing_event.addEventListener("click", function(){
      ing_box.style.display="inline-block"
      exit_box.style.display = "none";
  })
    exit_event.addEventListener("click", function(){
      exit_box.style.display ="inline-block";
      ing_box.style.display ="none";
  })
// 종료된 이벤트에서 마우스 오버되면 이미지랑 내용 바꾸기
  exit_image_box1.addEventListener("mouseover", function(){
    exit_change.style.display="inline-block";
    exit_change2.style.display="none";
    exit_change3.style.display="none";
  })
  exit_image_box2.addEventListener("mouseover", function(){
    exit_change.style.display="none";
    exit_change2.style.display="inline-block";
    exit_change3.style.display="none";
  })
  exit_image_box3.addEventListener("mouseover", function(){
    exit_change.style.display="none";
    exit_change2.style.display="none";
    exit_change3.style.display="inline-block";
  })

// 마우스 오버되면 상세보기 끄기 / 이미지 바꾸기
  image_box1.addEventListener("mouseover", function(){
    change_image.src="../img/진행중 이벤트 최종1.png"
    mydiv2.style.visibility = "hidden"
    mydiv3.style.visibility = "hidden"
    //마우스 오버 시 div 클래스 변경
    button1.style.visibility ="visible"
    button2.style.visibility ="hidden"
    button3.style.visibility ="hidden"
    
  });
  image_box2.addEventListener("mouseover", function(){
    change_image.src="../img/진행중 이벤트 최종2.png"
    //마우스오버 상세정보 사라지기
    mydiv1.style.visibility = "hidden"
    mydiv3.style.visibility = "hidden"

    //마우스오버 버튼 남기기
    button1.style.visibility ="hidden"
    button2.style.visibility ="visible"
    button3.style.visibility ="hidden"
  });
  image_box3.addEventListener("mouseenter", function(){
    change_image.src="../img/진행중 이벤트 최종3.png"
    
    //마우스오버 상세정보 사라지기
    mydiv1.style.visibility = "hidden"
    mydiv2.style.visibility = "hidden"
    
    //마우스오버 버튼 남기기
    button1.style.visibility ="hidden"
    button2.style.visibility ="hidden"
    button3.style.visibility ="visible"
  });

//버튼으로 상세 정보 출력
  function btnClick1() {
    const mydiv = document.querySelector('.text1');

    if(mydiv.style.visibility === 'hidden') {
      mydiv.style.visibility = 'visible';
    }else {
      mydiv.style.visibility = 'hidden';
    }
  }
  function btnClick2() {
    const mydiv = document.querySelector('.text2');

    if(mydiv.style.visibility === 'hidden') {
      mydiv.style.visibility = 'visible';
    }else {
      mydiv.style.visibility = 'hidden';
    }
  }
  function btnClick3() {
    const mydiv = document.querySelector('.text3');

    if(mydiv.style.visibility === 'hidden') {
      mydiv.style.visibility = 'visible';
    }else {
      mydiv.style.visibility = 'hidden';
    }
  }






  //  image_box1.addEventListener("mouseleave", function(){
  //   change_image.src="images/왼쪽 이벤트1.png"
  //  })
