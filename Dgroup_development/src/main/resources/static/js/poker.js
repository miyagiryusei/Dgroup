let images = [];
let imageNo = 0;
let image = [];
let buttoncount = 0;
let cardREV = "css/tramp/back.png";
let firstword = [];
let imagenumber = [];
let hands;
let imgechangecnt = 0;

document.getElementById("betmaney").style.visibility = "hidden";
document.getElementById("betbutton").style.visibility = "hidden";
document.getElementById("changebutton").style.visibility = "hidden";
document.getElementById("nextbutton").style.visibility = "hidden";

for(let i = 1; i < 6; i++) {
    let img = document.createElement('img');
    img.src = cardREV;
    img.name = "card" + i;
    img.id = "card" + i;
    img.className = 'card-img';
    document.getElementById('img').appendChild(img);
}

function imgchangecoll() {
    let target = document.getElementsByClassName("card-img");
    for(let i = 0; i < target.length; i++) {
        target[i].addEventListener("click", imgchange, false);
    }
}

function imgchange(e) {
        imageNo = Math.floor(Math.random() * images.length);
        image.push(images[imageNo]);
        console.log(images[imageNo]);
        images.splice(imageNo, 1);
            if(e.target.classList.contains('hold')) {
                e.target.classList.remove("hold");
                document.getElementById("msg" + (e.target.id.substring(e.target.id.length - 1, 1))).remove();
            } else {
                e.target.classList.add("hold");
                let msg = document.createElement('span');
                msg.textContent = "CHANGE";
                msg.classList.add("msg");
                msg.id = "msg" + (e.target.id.substring(e.target.id.length - 1, 1));
                e.target.parentNode.insertBefore(msg, e.target.nextSibling);
            }
//        image = [];
}

function card_dsp() {
    for(let i = 1; i <= 13; i++ ){
        let num;
        if(i < 10 ){
            num = 0;
        }else {
            num = '';
        }
        let img = document.createElement('img');
        img.src = "css/tramp/c"+ num +[i]+".png";
        images.push(img);
    }
    for(let i = 1; i <= 13; i++ ){
        let num;
        if(i < 10 ){
            num = 0;
        }else {
            num = '';
        }
        let img = document.createElement('img');
        img.src = "css/tramp/d"+ num +[i]+".png";
        images.push(img);
    }
    for(let i = 1; i <= 13; i++ ){
        let num;
        if(i < 10 ){
            num = 0;
        }else {
            num = '';
        }
        let img = document.createElement('img');
        img.src = "css/tramp/h"+ num +[i]+".png";
        images.push(img);
    }
    for(let i = 1; i <= 13; i++ ){
        let num;
        if(i < 10 ){
            num = 0;
        }else {
            num = '';
        }
        let img = document.createElement('img');
        img.src = "css/tramp/s"+ num +[i]+".png";
        images.push(img);
    }

    let img = document.createElement('img');
    img.src = "css/tramp/joker.png";
    images.push(img);
}

function shuffle() {
    for(let i = 1; i < 6; i++) {
        imageNo = Math.floor(Math.random() * images.length);
        image.push(images[imageNo]);
        console.log(images[imageNo]);
        images.splice(imageNo, 1);
    }

    if(buttoncount === 0) {
        firstchangecard();
    } else {
        nextchangecard();
    }
//    image = [];
    document.getElementById('roledisplay').innerHTML = "交換するカードを選んでください";
    betmaney.style.visibility = "visible";
    betbutton.style.visibility = "visible";
    changebutton.style.visibility = "visible";
}

function firstchangecard() {
    if(document.card1.src !== cardREV.src) {
        document.card1.src = image[0]['src'];
    }
    if(document.card2.src !== cardREV.src) {
        document.card2.src = image[1]['src'];
    }
    if(document.card3.src !== cardREV.src) {
        document.card3.src = image[2]['src'];
    }
    if(document.card4.src !== cardREV.src) {
        document.card4.src = image[3]['src'];
    }
    if(document.card5.src !== cardREV.src) {
        document.card5.src = image[4]['src'];
    }
    buttoncount++;
    document.getElementById('roledisplay').innerHTML = "交換するカードを選んでください";
    document.getElementById('startbutton').style.visibility = "hidden";
    betmaney.style.visibility = "visible";
    betbutton.style.visibility = "visible";
    changebutton.style.visibility = "visible";
}

function nextchangecard() {
     document.card1.src = image[0]['src'];
     document.card2.src = image[1]['src'];
     document.card3.src = image[2]['src'];
     document.card4.src = image[3]['src'];
     document.card5.src = image[4]['src'];

//    document.card1.src = "css/tramp/s10.png";
//    document.card2.src = "css/tramp/d10.png";
//    document.card3.src = "css/tramp/h10.png";
//    document.card4.src = "css/tramp/s02.png";
    // document.card5.src = "css/tramp/d02.png";
//    document.card5.src = "css/tramp/joker.png";
}

function chopcard() {
    //カード1をバラバラに取り出す
    let slashposition = document.card1.src.lastIndexOf("/");
    let slashword = document.card1.src.substring(slashposition);
    let slashlaterword = slashword.replace(/\//g, "");
    let pointpotision = slashlaterword.lastIndexOf(".");
    let pointlaterword = slashlaterword.substring(".", pointpotision);
    firstword.push(pointlaterword.charAt(0));
    imagenumber.push(pointlaterword.substring(1, 3));
    //カード2をバラバラに取り出す
    slashposition = document.card2.src.lastIndexOf("/");
    slashword = document.card2.src.substring(slashposition);
    slashlaterword = slashword.replace(/\//g, "");
    pointpotision = slashlaterword.lastIndexOf(".");
    pointlaterword = slashlaterword.substring(".", pointpotision);
    firstword.push(pointlaterword.charAt(0));
    imagenumber.push(pointlaterword.substring(1, 3));
    //カード3をバラバラに取り出す
    slashposition = document.card3.src.lastIndexOf("/");
    slashword = document.card3.src.substring(slashposition);
    slashlaterword = slashword.replace(/\//g, "");
    pointpotision = slashlaterword.lastIndexOf(".");
    pointlaterword = slashlaterword.substring(".", pointpotision);
    firstword.push(pointlaterword.charAt(0));
    imagenumber.push(pointlaterword.substring(1, 3));
    //カード4をバラバラに取り出す
    slashposition = document.card4.src.lastIndexOf("/");
    slashword = document.card4.src.substring(slashposition);
    slashlaterword = slashword.replace(/\//g, "");
    pointpotision = slashlaterword.lastIndexOf(".");
    pointlaterword = slashlaterword.substring(".", pointpotision);
    firstword.push(pointlaterword.charAt(0));
    imagenumber.push(pointlaterword.substring(1, 3));
    //カード5をバラバラに取り出す
    slashposition = document.card5.src.lastIndexOf("/");
    slashword = document.card5.src.substring(slashposition);
    slashlaterword = slashword.replace(/\//g, "");
    pointpotision = slashlaterword.lastIndexOf(".");
    pointlaterword = slashlaterword.substring(".", pointpotision);
    firstword.push(pointlaterword.charAt(0));
    imagenumber.push(pointlaterword.substring(1, 3));

    for(i = 0; i < 5; i++) {
        console.log(firstword[i]);
    }
    for(i = 0; i < 5; i++) {
        console.log(imagenumber[i]);
    }
    imagenumber.sort(function(a,b) {
        return (a < b ? -1 : 1);
    });
    console.log(imagenumber);
}

function judgerole() {
    let joker_flg = 0;
    let isFlush = 0;
    let isStraight = 0;
    let isRoyal = 0;

    if(imagenumber[4] === "ok") {
        joker_flg = 1;
    }

    let isFlushcnt = 0;
    for(let i = 0; i < firstword.length; i++) {
        if(firstword[i] == firstword[i + 1]) {
            isFlushcnt++;
        }
    }
    if(isFlushcnt == 4) {
        isFlush = 1;
    } else if(isFlushcnt == 3 && joker_flg == 1) {
        isFlush = 1;
    }
    console.log(isFlushcnt);
    console.log(joker_flg);

    let isStraightcnt = 0;
        for(let i = 0; i < firstword.length; i++) {
            if(imagenumber[i] == imagenumber[i + 1] - 1) {
                isStraightcnt++;
            }
        }
        console.log(isStraightcnt);
    if(isStraightcnt == 4) {
        isStraight = 1;
    } else if (isStraightcnt == 3 && joker_flg == 1) {
        isStraight = 1;
    }
    console.log(isStraight);

    if(imagenumber[0] == 1 && imagenumber[1] == 10 && imagenumber[2] == 11 && imagenumber[3] == 12 && imagenumber[4] == 13) {
        isRoyal = 1;
    } else if(imagenumber[0] == 10 && imagenumber[1] == 11 && imagenumber[2] == 12 && imagenumber[3] == 13 && imagenumber[4] == "ok") {
        isRoyal = 1;
    } else if(imagenumber[0] == 1 && imagenumber[1] == 10 && imagenumber[2] == 12 && imagenumber[3] == 13 && imagenumber[4] == "ok") {
        isRoyal = 1;
    } else if(imagenumber[0] == 1 && imagenumber[1] == 10 && imagenumber[2] == 11 && imagenumber[3] == 13 && imagenumber[4] == "ok") {
        isRoyal = 1;
    } else if(imagenumber[0] == 1 && imagenumber[1] == 10 && imagenumber[2] == 11 && imagenumber[3] == 12 && imagenumber[4] == "ok") {
        isRoyal = 1;
    } else if(imagenumber[0] == 1 && imagenumber[1] == 11 && imagenumber[2] == 12 && imagenumber[3] == 13 && imagenumber[4] == "ok") {
        isRoyal = 1;
    }
    console.log(isRoyal);

    if(isRoyal == 1 && isFlush == 1) {
        return hands = "RoyalStraightFlash";
    } else if(isStraight == 1 && isFlush == 1) {
        return hands = "StraightFlash";
    } else if(isStraight == 1) {
        return hands = "Straight";
    } else if(isRoyal == 1) {
        return hands = "Straight";
    } else if (isFlush == 1) {
        return hands = "Flash";
    } else {
        let cnt = 0;
        for(let max = 3; max >= 0; max--) {
            let i = 3 - max;
            for(let j = 1; j <= max + 1; j++) {
                if(imagenumber[i] == imagenumber[i + j]) {
                    cnt++;
                }
            }
        }
        switch(cnt) {
            case 6:
                if(joker_flg == 1) {
                    return hands = "ファイブカード";
                } else {
                    return hands= "フォーカード";
                }
            case 4:
                    return hands= "フルハウス";
            case 3:
                if(joker_flg == 1) {
                    return hands = "フォーカード";
                } else {
                    return hands= "スリーカード";
                }
            case 2:
                if(joker_flg == 1) {
                    return hands = "フルハウス";
                } else {
                    return hands= "ツーペア";
                }
            case 1:
                if(joker_flg == 1) {
                    return hands = "スリーカード";
                } else {
                    return hands= "ワンペア";
                }
            default:
                if(joker_flg == 1) {
                    return hands = "ワンペア";
            } else {
                    return hands = "ノーペア";
            }
        }
    }
}

function roledisplay() {
    document.getElementById('roledisplay').innerHTML = hands;
}

function change() {
    let target1 = document.getElementsByClassName('hold');
    for(let i = 0; i < target1.length; i++) {
        imageNo = Math.floor(Math.random() * images.length);
        image.push(images[imageNo]);
        console.log(images[imageNo]);
        document.getElementById("msgard").remove();
        target1[i].src = image[i]['src'];
        images.splice(imageNo, 1);
    }
    let target2 = document.getElementsByClassName('card-img');
    for(let i = 0; i < target2.length; i++) {
        target2[i].classList.remove("hold");
    }
    image = [];
    chopcard();
    judgerole();
    roledisplay();
//    imagenumber = [];
//    firstword = [];
    document.getElementById("betmaney").style.visibility = "hidden";
    document.getElementById("betbutton").style.visibility = "hidden";
    document.getElementById("changebutton").style.visibility = "hidden";
    nextbutton.style.visibility = "visible";
    let target = document.getElementsByClassName("card-img");
    for(let i = 0; i < target.length; i++) {
        target[i].removeEventListener("click", imgchange, false);
    }
}

function startgame() {
    card_dsp();
    shuffle();
    imgchangecoll();
    console.log(firstword);
//    image = [];
//    imagenumber = [];
//    firstword = [];
}

function nextgame() {
    card_dsp();
    shuffle();
    chopcard();
    judgerole();
    imgchangecoll();
    console.log(firstword);
    document.getElementById("nextbutton").style.visibility = "hidden";
    image = [];
    imagenumber = [];
    firstword = [];
}

//let ajax = new XMLHttpRequest();
//
//ajax.open('GET', '', true);
//ajax.onload == function(e) {
//    if (ajax.readyState == 4) {
//        if (ajax.readyState == 200) {
//            let json = ajax.responseText;
//            console.log(json);
//        }
//    }
//}
//ajax.send(null);

$.ajax({
	  type: "GET",
	  url: "", // リクエストURL
	  data: "hands",
	  dataType: "json",
	  cache: false,

	  //成功時
	  success: function (data, status, xhr) {

	  },
	  //失敗時
	  error: function (XMLHttpRequest, status, errorThrown) {
	    alert("fail:" + XMLHttpRequest);
	    alert("status:" + status);
	  }
	});