function activeTab(){
  const drop = document.getElementById('menuTapPage');
  const headerColor = document.getElementById('mainPColor');
  if(drop.style.display === 'none' || drop.style.display === '') {
      drop.style.display = 'block';
      headerColor.style.backgroundColor = '#063F3B';
  } else {
    drop.style.display = 'none';
    headerColor.style.backgroundColor = 'black';
  }
}