let currentIndex = 0;
const categoryItems = document.querySelectorAll('.intro .center .list a');
const totalItems = categoryItems.length;
const localNames = document.querySelectorAll('#ga_loc');
const localNamesArray = Array.from(localNames); // NodeList를 배열로 변환
const localNamesString = localNamesArray.map(item => item.innerText).join(', '); // 각 요소의 텍스트 콘텐츠를 배열로 가져온 후 join 메서드를 사용하여 문자열로 결합
const article = document.querySelectorAll('#article a');
const themeItems = document.querySelectorAll('.thema a'); // 테마를 나타내는 HTML 요소들을 선택합니다.
let currentLocationIndex = null; // 현재 선택된 지역의 인덱스를 저장할 변수입니다.

function showCategory(index) {
    categoryItems.forEach((item, idx) => {
        item.style.display = 'none';
        if (idx === index) {
            item.style.display = 'inline-block';
            let currentName = item.innerText;
            console.log(currentName)
            console.log(localNamesString)
            console.log(currentIndex)
            if (currentName === '지역') { // '지역' 항목일 경우 모든 article을 보여줌
                showTheme(currentLocationIndex); // 현재 선택된 지역에 맞게 테마를 표시합니다.
            } else if (localNamesString.includes(currentName)) {
                console.log(`${currentName}지역이 일치한다, 출력`)
                // 해당 지역이 일치하는 article 요소 보여주기
                article.forEach(articleItem => {
                    if (articleItem.innerText.includes(currentName)) {
                        articleItem.style.display = 'flex';
                    } else {
                        articleItem.style.display = 'none';
                    }
                });
                currentLocationIndex = idx; // 현재 선택된 지역의 인덱스를 업데이트합니다.
            } else {
                console.log("지역이 일치하지 않는다, 출력하지 않는다")
                // 지역이 일치하지 않는 article 요소 숨기기
                article.forEach(articleItem => {
                    articleItem.style.display = 'none';
                });
            }
        }
    });
}

// 테마에 맞는 내용을 보여주는 함수를 정의합니다.
function showTheme(locationIndex) {
    const selectedLocation = localNamesArray[locationIndex].innerText; // 선택된 지역의 이름을 가져옵니다.
    article.forEach(articleItem => {
        const articleLocation = articleItem.querySelector('#ga_loc').innerText; // 각 게시물의 지역을 가져옵니다.
        const articleTheme = articleItem.querySelector('span:nth-of-type(2)').innerText; // 각 게시물의 테마를 가져옵니다.
        if (articleLocation === selectedLocation) {
            // 선택된 지역에 해당하는 게시물 중 해당 테마에 해당하는 게시물만 보여줍니다.
            const currentTheme = themeItems[currentLocationIndex].querySelector('span').innerText;
            const filteredArticles = Array.from(article).filter(item => item.innerText.includes(currentTheme));
            filteredArticles.forEach(item => item.style.display = 'flex');
        } else {
            articleItem.style.display = 'none';
        }
    });
}

// 각 테마 항목에 대해 클릭 이벤트를 설정합니다.
themeItems.forEach((item, index) => {
    item.addEventListener('click', () => {
        // 클릭된 테마의 인덱스를 가져옵니다.
        const selectedThemeIndex = index;
        // 현재 선택된 지역에 맞게 테마를 표시하는 함수를 호출합니다.
        showTheme(selectedThemeIndex);
    });
});

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