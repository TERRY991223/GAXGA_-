let currentIndex = 0;
let categoryItems = document.querySelectorAll('.intro .center .list a'); //지역카테고리 목록
let article = document.querySelectorAll('.subject .left a');// 분류할 게시글 목록

const totalItems = categoryItems.length;

function showCategory(index) {
    categoryItems.forEach((item) => {
        item.style.display = 'none';
    });
    categoryItems[index].style.display = 'inline-block';
}

// 지역 필터링 함수
function filterByLocal(filter) {
    article.forEach((locals) => {
        if (filter === "지역") {
            locals.style.display = 'flex'; // "지역"일 경우 모든 지역을 표시
        } else if (filter === "*" || filter === locals.getAttribute("data-type")) {
            locals.style.display = 'flex'; // 일치하는 경우 표시
        } else {
            locals.style.display = 'none'; // 일치하지 않는 경우 숨김
        }
    });
}

//테마 필터링 함수
function filterBythema(themaFilter, localFilter) { // 테마 클릭해도 지역 필터는 유지되기 위해 매개변수로 로컬필터 가져와서 조건걸기
    article.forEach((item) => {
        let displayThema = false;
        let displayLocal = false;

        // Thema 필터링
        if (themaFilter === "*" || themaFilter === item.getAttribute("data-type2")) {
            displayThema = true;
        }

        // Local 필터링
        if (localFilter === "지역") {
            displayLocal = true;
        } else if (localFilter === "*" || localFilter === item.getAttribute("data-type")) {
            displayLocal = true;
        }

        // 최종 표시 여부 결정
        if (displayThema && displayLocal) {
            item.style.display = "flex";
        } else {
            item.style.display = "none";
        }
    });
}


function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
    const filter = categoryItems[currentIndex].getAttribute("data-filter"); // 다음 카테고리의 data-filter 속성 값
    filterByLocal(filter); // 지역 필터링 함수 호출
}


function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
    const filter = categoryItems[currentIndex].getAttribute("data-filter"); // 다음 카테고리의 data-filter 속성 값
    console.log(filter);
    filterByLocal(filter); // 지역필터링 함수 호출
    }


function themaClick() {//테마 필터링 + 지역 필터링 함수 호출 메서드
    const filter2 = event.currentTarget.getAttribute("data-filter");
    const filter1 = categoryItems[currentIndex].getAttribute("data-filter");
    filterBythema(filter2, filter1); // 테마 필터링 함수와 지역 필터링 함수 연속 호출
}

//카테고리 클릭 시 전체 목록 다시 출력
categoryItems.forEach((item, index) => {
    item.addEventListener('click', () => {
        showCategory(index);
        const filter = item.getAttribute("data-filter");
        filterByLocal(filter);
    });
});

// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);