document.addEventListener('DOMContentLoaded', function() {
    const deleteButtons = document.querySelectorAll('#BoardDeleteBtn');
    deleteButtons.forEach(button => {
        button.addEventListener('click', (event) => {
            const boardDeleteBtn = event.target;
            const board_Id = boardDeleteBtn.getAttribute("data-Board-Id");
            console.log(board_Id);
            const url = `/api/gabowatdago/${board_Id}`;

            if(confirm("정말 삭제하시겠습니까?")){
            fetch(url, {
                method: "DELETE"
            }).then(response => {
                const msg = (response.ok) ? "삭제 성공" : "삭제 실패";
                alert(msg);
                if (response.ok) {
                    window.location.reload();
                    }
                });
            }
        });
    });
});
