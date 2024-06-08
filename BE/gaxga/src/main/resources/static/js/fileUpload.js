const filesArray = [];
const validExtensions = ['jpg', 'jpeg', 'png', 'gif']; // 허용되는 파일 확장자 목록

document.getElementById('inputGroupFile03').addEventListener('change', function(event) {
    const uploadedImagesDiv = document.getElementById('uploadedImages');
    const fileInput = event.target;
    const newFiles = Array.from(event.target.files).filter(file => {
        const fileExtension = file.name.split('.').pop().toLowerCase();
        return validExtensions.includes(fileExtension);
    });

    if (newFiles.length === 0 && event.target.files.length > 0) {
        alert('이미지 파일만 업로드 가능합니다. (jpg, jpeg, png, gif)');
        fileInput.value = ''; // 파일 선택 초기화
        return; // 추가 처리 중단
    }

    newFiles.forEach((file, index) => {
        filesArray.push(file);
        const reader = new FileReader();

        reader.onload = function(e) {
            const imgContainer = document.createElement('div');
            imgContainer.style.display = 'inline-block';
            imgContainer.style.position = 'relative';
            imgContainer.style.margin = '10px';

            const img = document.createElement('img');
            img.src = e.target.result;
            img.style.maxWidth = '200px';

            const deleteButton = document.createElement('button');
            deleteButton.innerText = '삭제';
            deleteButton.style.position = 'absolute';
            deleteButton.style.top = '5px';
            deleteButton.style.right = '5px';
            deleteButton.style.backgroundColor = 'red';
            deleteButton.style.color = 'white';
            deleteButton.style.border = 'none';
            deleteButton.style.borderRadius = '3px';
            deleteButton.style.cursor = 'pointer';

            deleteButton.addEventListener('click', function() {
                uploadedImagesDiv.removeChild(imgContainer);
                const fileIndex = filesArray.indexOf(file);
                if (fileIndex > -1) {
                    filesArray.splice(fileIndex, 1);
                }
                updateFileInput(filesArray, fileInput);
            });

            imgContainer.appendChild(img);
            imgContainer.appendChild(deleteButton);
            uploadedImagesDiv.appendChild(imgContainer);
        };

        reader.readAsDataURL(file);
    });

    updateFileInput(filesArray, fileInput);
});

function updateFileInput(files, fileInput) {
    const dataTransfer = new DataTransfer();
    files.forEach(file => dataTransfer.items.add(file));
    fileInput.files = dataTransfer.files;
}