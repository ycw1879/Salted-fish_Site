let search = document.getElementsByClassName("search-input-frame");
let view = document.getElementsByClassName("gs-inner");
let btnTop = document.getElementsByClassName("btn-frame-top");
let questionTable = document.getElementsByClassName("question-table");
function clickSearch(){
    search[0].classList.toggle('search-off');
}
function clickView(){
    view[0].classList.toggle('view-flex-ch');
}
function clickTop(){
    window.scrollTo({top:0, behavior:'smooth'});
}



console.log("불러오기 완료");