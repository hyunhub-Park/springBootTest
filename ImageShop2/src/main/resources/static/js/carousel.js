function carousel ()
{
    let slideShow = document.querySelector(".slideShow");
    let slideShow_slides = document.querySelector(".slideShow_slides");
    let anchor_in_slides = document.querySelectorAll(".slideShow_slides a");
    let pre = document.querySelector(".pre");
    let next = document.querySelector(".next");

    let anchor_in_indicator = document.querySelectorAll(".slideShow_indicator a");

    // 현재 이미지인덱스, 인터벌 아이디, 슬라이드 개수 체크.
    let currentIndex = 0;   // 첫 시작.
    let timerId = null;
    let slideCount = anchor_in_slides.length;

    // 현재 이미지를 한 줄로 정렬.
    for (let i = 0; i < slideCount; i++)
    {
        // 🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️ viewPort 는 고정인거고 당연히!!!!!!!!!!!!
        // 🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️🤷‍♀️ z-index기능.
        let newLeft = `${i*100}%`;
        anchor_in_slides[i].style.left = newLeft;
    }

    // 화면 전환 함수.
    function gotoSlide (index)
    {
        currentIndex = index;
        let newLeft = `${index* -100}%`; // 왜 곱하는지 알지?? -100씩 인덱스만큼 왼쪽으로 이동!!!
        slideShow_slides.style.left = newLeft;

        // indicator 그 위치를 가리켜야 함.
        for (let i = 0; i < slideCount; i++)
        {
            // 하나의 태그 안에????? 클래스가 여러개 들어갈 수 있음. 그걸 관리하는게 classList.
            // 기존 것 모두 없애버리고!
            anchor_in_indicator[i].classList.remove('active');
        }
        anchor_in_indicator[index].classList.add('active');
    }   // end of gotoSlide.
    gotoSlide(1);

    // 3초마다 gotoSlide();호출
    // 불러주되, index 0, 1, 2, 3, 0, 1, 2....
    function startTimer ()
    {
        timerId = setInterval(() => {
            let index = (currentIndex + 1)%slideCount;
            currentIndex = index;
            gotoSlide(index);
        }, 3000);
    }
    startTimer();

    // 이벤트 등록 및 핸들러 기능.
    // slideShow_slides.addEventListener("mouseenter", function(){});
    slideShow_slides.addEventListener("mouseenter", (event) =>
    {   // 마우스 올렸을 때 멈추는.
        clearInterval(timerId);        
    });

    slideShow_slides.addEventListener("mouseleave", (event) =>
    {
        startTimer();        
    });

    pre.addEventListener("mouseenter", (event) =>
    {   // 마우스 올렸을 때 멈추는.
        clearInterval(timerId);        
    });

    pre.addEventListener("mouseleave", (event) =>
    {
        startTimer();        
    });

    next.addEventListener("mouseenter", (event) =>
    {   // 마우스 올렸을 때 멈추는.
        clearInterval(timerId);        
    });

    next.addEventListener("mouseleave", (event) =>
    {
        startTimer();        
    });

    pre.addEventListener("click", (event) =>
    {
        event.preventDefault(); // anchor태그가 가지고 있는 페이지 이동하는 기본 기능을 막음.
        currentIndex = currentIndex - 1;

        if (currentIndex < 0)
        {
            currentIndex = slideCount-1;

        }
        gotoSlide(currentIndex);
    });

    next.addEventListener("click", (event) =>
    {
        event.preventDefault(); // anchor태그가 가지고 있는 페이지 이동하는 기본 기능을 막음.
        currentIndex = currentIndex + 1;

        if (currentIndex > (slideCount - 1))
        {
            currentIndex = 0;
        }
        gotoSlide(currentIndex);
    });

    // indicator 클릭 -> 해당페이지로 이동.
    for (let i = 0; i < slideCount; i++)
    {
        anchor_in_indicator[i].addEventListener("mouseenter", (event) => 
        {
            clearInterval(timerId);
        });
    }

    for (let i = 0; i < slideCount; i++)
    {
        anchor_in_indicator[i].addEventListener("mouseleave", (event) => 
        {
            startTimer();
        });
    }


    for (let i = 0; i < slideCount; i++)
    {
        anchor_in_indicator[i].addEventListener("click", (event) => 
        {
            event.preventDefault();
            gotoSlide(i);   // 0~3.
        });
    }
}   // end of carousel.