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




// 숫자 타입에서 쓸 수 있도록 format() 함수 추가
Number.prototype.format = function(){
    if(this==0) return 0;

    var reg = /(^[+-]?\d+)(\d{3})/;
    var n = (this + '');

    while (reg.test(n)) n = n.replace(reg, '$1' + ',' + '$2');

    return n;
};

// 문자열 타입에서 쓸 수 있도록 format() 함수 추가
String.prototype.format = function(){
    var num = parseFloat(this);
    if( isNaN(num) ) return "0";

    return num.format();
};

console.log("불러오기 완료");
var num = 1234;
console.log(num.format());