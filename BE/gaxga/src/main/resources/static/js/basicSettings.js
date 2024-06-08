// 핸드폰 번호 입력시 - 자동설정 기능
const AutoHyphen = (target) => {
  target.value = target.value
  .replace(/[^0-9]/g, "")
  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
}
