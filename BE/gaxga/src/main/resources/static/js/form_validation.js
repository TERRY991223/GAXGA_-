function validateForm() {
    //게시글 작성 지역,테마 카테고리 제한
    var localSelect = document.querySelector('select[name="local"]');
    var themaSelect = document.querySelector('select[name="thema"]');
    var titleBox = document.querySelector('#title_box');

    if (localSelect.value === "지역" || themaSelect.value === "테마") {
        alert('지역과 테마를 선택해주세요.');
        return false; // 폼 제출 방지
    }

    if (titleBox.value.trim() ===""){
        alert('제목을 입력해주세요')
        return false;
    }

    return true // 폼 제출 허용
}
