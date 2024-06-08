let currentIndex = 0;
const categoryItems = document.querySelectorAll('.intro .center .list');
const locationItems = document.querySelectorAll('.subject .left .locationArea');
const totalItems = categoryItems.length;
const locateItems = locationItems.length;
function showCategory(index) {
    categoryItems.forEach(item => {
        item.style.display = 'none';
    });
    locationItems.forEach(locations => {
        locations.style.display = 'none';
    });
    categoryItems[index].style.display = 'inline-block';
    locationItems[index].style.display = 'inline-block';
}

function prevCategory() {
    currentIndex = (currentIndex - 1 + totalItems) % totalItems;
    showCategory(currentIndex);
    const listLeft= document.querySelectorAll('.locationAreaList');
    listLeft.forEach(function (item){
        item.style.display = 'flex';
    });
}

function nextCategory() {
    currentIndex = (currentIndex + 1) % totalItems;
    showCategory(currentIndex);
    const listRight= document.querySelectorAll('.locationAreaList');
    listRight.forEach(function (item){
        item.style.display = 'flex';
    });
}

// 페이지 로드 시 첫 번째 카테고리 항목 보이기
showCategory(currentIndex);