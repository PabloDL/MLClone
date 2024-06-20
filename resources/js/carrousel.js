document.addEventListener('DOMContentLoaded', function() {
    const carouselContainer = document.querySelector('.carousel-container');
    const imgWidth = document.querySelector('.carousel img').clientWidth;
    const totalImages = document.querySelectorAll('.carousel img').length;
    let counter = 0;

    function moveNext() {
        counter++;
        if (counter >= totalImages) {
            counter = 0;
        }
        carouselContainer.style.transition = 'transform 0.5s ease';
        carouselContainer.style.transform = `translateX(${-imgWidth * counter}px)`;
    }

    function movePrev() {
        counter--;
        if (counter < 0) {
            counter = totalImages - 1;
        }
        carouselContainer.style.transition = 'transform 0.5s ease';
        carouselContainer.style.transform = `translateX(${-imgWidth * counter}px)`;
    }

    const autoMove = setInterval(moveNext, 3000); 

    carouselContainer.addEventListener('transitionend', function() {
        if (counter === totalImages) {
            counter = 0;
            carouselContainer.style.transition = 'none';
            carouselContainer.style.transform = `translateX(0px)`;
        }
    });
});
