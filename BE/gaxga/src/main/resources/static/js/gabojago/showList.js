function showList(link) {
    const linkText = link.innerText;
    const listAll = document.querySelectorAll('.locationAreaList');

    listAll.forEach(function (item) {
        // 두 번째 span 태그의 텍스트 내용을 가져옴.
        const secondSpanText = item.querySelector('span:nth-child(2)').textContent.trim();

        // 두 번째 span 태그의 값과 linkText를 비교.
        if (secondSpanText === linkText) {
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}
