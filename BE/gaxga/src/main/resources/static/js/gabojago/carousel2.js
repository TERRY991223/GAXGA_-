let currentIndex = 0;
const categoryItem = document.querySelectorAll('.intro .center .list');
const totalItems = categoryItem.length;
const locationNames = document.querySelectorAll('#loc_ga');
const locationArray = Array.from(locationNames); // NodeList를 배열로 변환
const locationString = locationArray.map(item => item.innerText).join(', '); // 각 요소의 텍스트 콘텐츠를 배열로 가져온 후 join 메서드를 사용하여 문자열로 결합
const locationItem = document.querySelectorAll('.locationAreaList');

function showCategory(index) {
    categoryItem.forEach((item, idx) => {
        item.style.display = 'none';
        if (idx === index) {
            item.style.display = 'inline-block';
            let currentName = item.innerText;
            if(locationString.includes(currentName)){
                // 해당 지역이 일치하는 article 요소 보여주기
                locationItem.forEach(locationItems => {
                    if (locationItems.innerText.includes(currentName)) {
                        locationItems.style.display = 'flex';
                    } else {
                        locationItems.style.display = 'none';
                    }
                });
            }else{
                console.log("지역이 일치하지 않는다, 출력하지 않는다")
                // 지역이 일치하지 않는 article 요소 숨기기
                locationItem.forEach(locationItems => {
                    locationItems.style.display = 'none';
                });
            }
        }

    });

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


