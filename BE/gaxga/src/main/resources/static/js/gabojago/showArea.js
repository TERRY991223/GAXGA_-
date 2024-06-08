function showArea(link) {
    const linkArea = link.innerText;
    const AreaItems = document.querySelectorAll('.locationAreaList');
    AreaItems.forEach(function (item){
        if(item.innerText === linkArea || item.innerText.includes(linkArea)) {
            item.style.display = 'flex';
        }
    });
}
