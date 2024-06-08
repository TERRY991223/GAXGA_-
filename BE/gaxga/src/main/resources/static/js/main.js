// 스크롤 위치 감지로 페이지 로딩
document.addEventListener('DOMContentLoaded', () => {
    let observer = new IntersectionObserver((entries) => {
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = 1;
            } else {
                entry.target.style.opacity = 0;// Optional: hide again when not intersecting
                entry.target.style.transform = 'black';
            }
        });
    }, { threshold: 0.3 }); // 30% visibility

    const pages = document.querySelectorAll('.page');

    pages.forEach((page) => {
        observer.observe(page);
    });
});

// 부드러운 스크롤 적용 /됐는지 모르겠음 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
function smoothScroll(target, duration) {
    let targetPosition = target.getBoundingClientRect().top;
    let startPosition = window.scrollY;
    let distance = targetPosition - startPosition;
    let startTime = null;

    function animation(currentTime) {
        if (startTime === null) startTime = currentTime;
        let timeElapsed = currentTime - startTime;
        let run = ease(timeElapsed, startPosition, distance, duration);
        window.scrollTo(0, run);
        if (timeElapsed < duration) requestAnimationFrame(animation);
    }

    function ease(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return c / 2 * t * t + b;
        t--;
        return -c / 2 * (t * (t - 2) - 1) + b;
    }

    requestAnimationFrame(animation);
}

document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function(e) {
        e.preventDefault();
        let target = document.querySelector(this.getAttribute('href'));
        smoothScroll(target, 1000);
    });
});

//back to top 클릭시 스크롤 맨 위로 이동
const scrollTopButton = document.querySelector("#backTop");
scrollTopButton.addEventListener("click", event => {
    window.scrollTo({top:0, behavior: 'smooth'});
});
