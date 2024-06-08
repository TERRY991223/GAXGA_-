document.getElementById("joinMembership").addEventListener("click", function() {
  window.location.href = "http://127.0.0.1:5500/joinMembership.html";
});

document.getElementById("find_Id").addEventListener("click", findInfo());
document.getElementById("find_Password").addEventListener("click", findInfo());

function findInfo(){
  window.location.href = "http://127.0.0.1:5500/findInfo.html";
}