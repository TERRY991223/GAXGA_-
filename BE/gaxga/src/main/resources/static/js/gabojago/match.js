function match(link){
    const matchText = link.innerText;
    const matchList = document.querySelectorAll('.locationAreaList');

    matchList.forEach(function (item){
        if(item.innerText === matchText || item.innerText.includes(matchText)){
            item.style.display = 'flex';
        } else {
            item.style.display = 'none';
        }
    });
}