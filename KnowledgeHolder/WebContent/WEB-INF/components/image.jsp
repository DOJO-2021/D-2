<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
    .search_modal_popUp,
        input[name="search_modal_switch"],
        #search_modal_open + label ~ label {
            display: none;
        }
        #search_modal_open + label,
        #search_modal_close-button + label {
            cursor: pointer;
    }

    .search_modal_popUp {
        animation: fadeIn 1s ease 0s 1 normal;
        -webkit-animation: fadeIn 1s ease 0s 1 normal;
    }
    #search_modal_open:checked ~ #search_modal_close-button + label{
        animation: fadeIn 2s ease 0s 1 normal;
        -webkit-animation: fadeIn 2s ease 0s 1 normal;
    }
    @keyframes fadeIn {
        0% {opacity: 0;}
        100% {opacity: 1;}
    }
    @-webkit-keyframes fadeIn {
        0% {opacity: 0;}
        100% {opacity: 1;}
    }

    #search_modal_open:checked + label ~ .search_modal_popUp {
        background: #fff;
        display: block;
        width: 90%;
        height: 80%;
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        -webkit-transform: translate(-50%,-50%);
        -ms-transform: translate(-50%,-50%);
        z-index: 998;
    }

    #search_modal_open:checked + label ~ .search_modal_popUp > .search_modal_popUp-content {
        width: calc(100% - 40px);
        height: calc(100% - 20px - 44px );
        padding: 10px 20px;
        overflow-y: auto;
        -webkit-overflow-scrolling:touch;
    }

    #search_modal_open:checked + label + #search_modal_close-overlay + label {
        background: rgba(0, 0, 0, 0.70);
        display: block;
        width: 100%;
        height: 100%;
        position: fixed;
        top: 0;
        left: 0;
        overflow: hidden;
        white-space: nowrap;
        text-indent: 100%;
        z-index: 997;
    }

    #search_modal_open:checked ~ #search_modal_close-button + label {
        display: block;
        background: #fff;
        text-align: center;
        font-size: 25px;
        line-height: 44px;
        width: 90%;
        height: 44px;
        position: fixed;
        bottom: 10%;
        left: 5%;
        z-index: 999;
    }
    #search_modal_open:checked ~ #search_modal_close-button + label::before {
        content: '×';
    }
    #search_modal_open:checked ~ #search_modal_close-button + label::after {
        content: 'CLOSE';
        margin-left: 5px;
        font-size: 80%;
    }

    @media (min-width: 768px) {
    #search_modal_open:checked + label ~ .search_modal_popUp {
        width: 600px;
        height: 500px;
        border-radius:15px;
    }
    #search_modal_open:checked + label ~ .search_modal_popUp > .search_modal_popUp-content {
        height: calc(100% - 20px);
    }
    #search_modal_open:checked ~ #search_modal_close-button + label {
        width: 44px;
        height: 44px;
        left: 50%;
        top: 57%;
        margin-left: 240px;
        margin-top: -285px;
        overflow: hidden;
    }
    #search_modal_open:checked ~ #search_modal_close-button + label::after {
        display: none;
    }
}
</style>

<section class="search_modal">
    <input id="search_modal_open" type="radio" name="search_modal_switch" />
    <label for="search_modal_open">
        添付ファイル
    </label>
    <input id="search_modal_close-overlay" type="radio" name="search_modal_switch" />
    <label for="search_modal_close-overlay">オーバーレイで閉じる</label>
    <input id="search_modal_close-button" type="radio" name="search_modal_switch" />
    <label for="search_modal_close-button"></label>
    <div class="search_modal_popUp">
        <div class="search_modal_popUp-content col-10 offset-1">
        <img src = "images/test.png" width="600px" height="500px">
        </div>
    </div>
</section>