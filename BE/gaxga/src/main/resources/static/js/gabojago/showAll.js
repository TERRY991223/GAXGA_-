function showAll(){
    const All_Area = document.querySelectorAll('#All_location');
    All_Area.forEach(function (item){
        item.style.display = 'flex';
    });
}