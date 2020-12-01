let search = document.getElementsByClassName("search-input-frame");
let view = document.getElementsByClassName("gs-inner");
let btnTop = document.getElementsByClassName("btn-frame-top");
let btnCall = document.getElementsByClassName("call-popup-frame");
let btnCallBack1 = document.getElementsByClassName("btn-close");
let btnCallBack2 = document.getElementsByTagName("button");
let btnDownMobile = document.getElementsByClassName("btn-frame");
let mpTab = document.querySelectorAll(".mp-tab-frame ul li");
let mpTab2 = document.getElementsByTagName(".mp-tab-frame ul li");

function clickSearch(){
    const headerFormSearch = document.querySelector("#header-form-search");
    const headerInputSearch = document.querySelector("#header-input-search");
    if( headerFormSearch.classList.contains('search-off') ){
        headerInputSearch.value = '';
        search[0].classList.toggle('search-off');
    }else{
        const searchText = headerInputSearch.value;
        if(searchText == null || searchText == undefined || searchText.length == 0){
            search[0].classList.toggle('search-off');
        }else{
            headerFormSearch.submit();
        }
    }
}
function clickView(){
    view[0].classList.toggle('view-flex-ch');
}
function clickTop(){
    window.scrollTo({top:0, behavior:'smooth'});
}
function clickCall(){
    btnCall[0].classList.toggle('popup');
}
function clickBtnDown(){
    for(i=0; i <= btnDownMobile.length-2; i++){
        btnDownMobile[i].classList.toggle('btn-down');
    }
}
function clickTab(){
    console.log(mpTab);
    console.log(mpTab2);
    console.log('작동중');
}


console.log("불러오기 완료");




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