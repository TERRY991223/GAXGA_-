const contents = ["modifyProfile","myWrited","saved","receiveLike"];
const profileInfos = ["showNickname", "showPhoneNumber","showPass","showEmail"];
const modifyType = ["nickname", "phoneNumber","pass","email"];
const modifyBtn =["modifyNickname","modifyPhoneNumber","modifyPass","modifyEmail"];
const saveBtn =["nicknameBtn","phoneNumberBtn","passBtn","emailBtn"];

function SelectedContent(selectNum){
  for(let i = 0; i < contents.length; i++){
    const element = document.getElementById(contents[i]);
    element.classList.remove("active");
  }
  const selectedElement = document.getElementById(contents[selectNum]);
  selectedElement.classList.add("active");
}

function ModifyProfileBtn(btnType) {
  for (let i = 0; i < profileInfos.length; i++) {
    const spanElement = document.getElementById(profileInfos[i]);
    const inputElement = document.getElementById(modifyType[i]);
    const saveElement = document.getElementById(saveBtn[i]);
    const modifyElement = document.getElementById(modifyBtn[i]);
    if (btnType === i) {
      if (spanElement.classList.contains("hidden")) {
        spanElement.classList.remove("hidden");
        inputElement.classList.add("hidden");
        saveElement.classList.add("hidden");
        modifyElement.classList.remove("hidden");
      } else {
        spanElement.classList.add("hidden");
        inputElement.classList.remove("hidden");
        saveElement.classList.remove("hidden");
        modifyElement.classList.add("hidden");
      }
    }
  }
}
//