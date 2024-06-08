const imageElement = document.getElementById("image");

const textElement1 = document.getElementById("text0");

textElement1.addEventListener("mouseover", function() {
  imageElement.src= "../img/seoulcafe1.png";
});

const textElement2 = document.getElementById("text2");

textElement2.addEventListener("mouseover", function() {
  imageElement.src = "../img/seoulcafe2.png";
});
const textElement3 = document.getElementById("text3");

textElement3.addEventListener("mouseover", function() {
  imageElement.src = "../img/seoulcafe3.png";
});
const textElement4 = document.getElementById("text4");

textElement4.addEventListener("mouseover", function() {
  imageElement.src = "../img/namsan.png";
});
const textElement5 = document.getElementById("text5");

textElement5.addEventListener("mouseover", function() {
  imageElement.src = "../img/wolmido.png";
});
const textElement6 = document.getElementById("text6");

textElement6.addEventListener("mouseover", function() {
  imageElement.src = "../img/Oworld.png";
});
const textElement7 = document.getElementById("text7");

textElement7.addEventListener("mouseover", function() {
  imageElement.src = "../img/kingsejong.png";
});
const textElement8 = document.getElementById("text8");

textElement8.addEventListener("mouseover", function() {
  imageElement.src = "../img/botanicgarden.png";
});
const textElement9 = document.getElementById("text9");

textElement9.addEventListener("mouseover", function() {
  imageElement.src = "../img/childgrandpark.png";
});
const textElement10 = document.getElementById("text10");

textElement10.addEventListener("mouseover", function() {
  imageElement.src = "../img/seoulcafe1.png";
});
const textElement11 = document.getElementById("text11");

textElement11.addEventListener("mouseover", function() {
  imageElement.src = "../img/seoulcafe2.png";
});
const textElement12 = document.getElementById("text12");

textElement12.addEventListener("mouseover", function() {
  imageElement.src = "../img/seoulcafe3.png";
});
const textElement13 = document.getElementById("text13");

textElement13.addEventListener("mouseover", function() {
  imageElement.src = "../img/pajeonstreet.png";
});
const textElement14 = document.getElementById("text14");

textElement14.addEventListener("mouseover", function() {
  imageElement.src = "../img/jokbalalley.png";
});
const textElement15 = document.getElementById("text15");

textElement15.addEventListener("mouseover", function() {
  imageElement.src = "../img/tteokbokkitown.png";
});
const textElement16 = document.getElementById("text16");

textElement16.addEventListener("mouseover", function() {
  imageElement.src = "../img/gamaksan.png";
});
const textElement17 = document.getElementById("text17");

textElement17.addEventListener("mouseover", function() {
  imageElement.src = "../img/gamaksan.png";
});
const textElement18 = document.getElementById("text18");

textElement18.addEventListener("mouseover", function() {
  imageElement.src = "../img/hangugminsogchon.png";
});
const textElement19 = document.getElementById("text19");

textElement19.addEventListener("mouseover", function() {
  imageElement.src = "../img/cafesoom.png";
});
const textElement20 = document.getElementById("text20");

textElement20.addEventListener("mouseover", function() {
  imageElement.src = "../img/jeilsijang.png";
});
const textElement21 = document.getElementById("text21");

textElement21.addEventListener("mouseover", function() {
  imageElement.src = "../img/cheonglyangsan2.png";
});
const textElement22 = document.getElementById("text22");

textElement22.addEventListener("mouseover", function() {
  imageElement.src = "../img/cheonglyangsan1.png";
});
const textElement23 = document.getElementById("text23");

textElement23.addEventListener("mouseover", function() {
  imageElement.src = "../img/incheonsanglyugjagjeon.png";
});
const textElement24 = document.getElementById("text24");

textElement24.addEventListener("mouseover", function() {
  imageElement.src = "../img/wolmido.png";
});
const textElement25 = document.getElementById("text25");

textElement25.addEventListener("mouseover", function() {
  imageElement.src = "../img/forestoutings.png";
});

// mouseover

let currentIndex = 0;
        const categoryItems = document.querySelectorAll('.intro .center .list');
        const totalItems = categoryItems.length;

        function showCategory(index) {
            categoryItems.forEach(item => {
                item.style.display = 'none';
            });
            categoryItems[index].style.display = 'inline-block';
        }

        function prevCategory() {
            currentIndex = (currentIndex - 1 + totalItems) % totalItems;
            showCategory(currentIndex);
        }

        function nextCategory() {
            currentIndex = (currentIndex + 1) % totalItems;
            showCategory(currentIndex);
        }

        // 페이지 로드 시 첫 번째 카테고리 항목 보이기
        showCategory(currentIndex);


// // search
// const search = document.querySelector("input");
// const ul = document.querySelector("ul");
// const result = document.getElementById("result");
// const fruits = [
//   "apple",
//   "banana",
//   "orange",
//   "lemon",
//   "lime",
//   "pure",
//   "peach",
//   "berry",
// ];

// fruits.forEach((fruit) => {
//   const li = document.createElement("li");
//   li.innerText = fruit;
//   ul.appendChild(li);
//   clickItem(ul, li);
// });

// function handleHidden() {
//   ul.hidden = ul.hidden ? false : true;
// }

// search.addEventListener("focusin", handleHidden);

// search.addEventListener("focusout", handleHidden);

// search.addEventListener("input", (e) => {
//   ul.childNodes.forEach((li) => {
//     clickItem(ul, li, search, e.target.value);
//   });
// });

// function clickItem(ul, li, input, searchItem) {
//   if (searchItem) {
//     li.hidden = li.textContent.includes(searchItem) ? false : true;
//   }
//   li.addEventListener("mouseover", () => {
//     search.removeEventListener("focusout", handleHidden);
//     li.style.cursor = "pointer";
//     li.style.background = "pink";
//     ul.hidden = false;
//     li.addEventListener("click", (e) => {
//       result.innerText = e.target.textContent;
//       ul.hidden = true;
//       if (input) {
//         input.value = "";
//       }
//       ul.childNodes.forEach((li) => li.removeAttribute("hidden"));
//     });
//   });
//   li.addEventListener("mouseleave", () => {
//     search.addEventListener("focusout", handleHidden);
//     li.style.background = "transparent";
//   });
// }