  // 當文檔加載完成時和當導航鏈接被點擊時執行
  function setActiveLink() {
    let scrollPosition = window.pageYOffset;

    // 獲取所有section元素
    let sections = document.querySelectorAll('section');

    // 獲取所有導航鏈接
    let navLinks = document.querySelectorAll('.navbar-nav .nav-link');

    // 移除所有導航鏈接的 'active' 類別
    navLinks.forEach(link => {
        link.classList.remove('active');
    });

    // 遍歷所有section
    sections.forEach(section => {
        // 獲取section元素的位置資訊
        let sectionTop = section.offsetTop;
        let sectionHeight = section.offsetHeight;

        // 檢查section元素是否在視窗範圍內
        if (scrollPosition >= sectionTop && scrollPosition <= sectionTop + sectionHeight) {
            // 找到對應的導航鏈接
            let activeLink = document.querySelector('.navbar-nav .nav-link[href*=' + section.getAttribute('id') + ']');
            // 給匹配的導航鏈接添加 'active' 類別
            activeLink.classList.add('active');
        }
    });
}

// 監聽文檔加載事件
document.addEventListener('DOMContentLoaded', setActiveLink);

// 監聽滾動事件
window.addEventListener('scroll', setActiveLink);