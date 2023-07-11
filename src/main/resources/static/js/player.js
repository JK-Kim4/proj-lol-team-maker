let main = {
    init: function (){
        let _this = this;

        $("#playerInsertBtn").on("click", function (){
            _this.insert();
        });

        $("#movePlayerSavePage").on("click", function (){
           location.href = "/player/save";
        });

        $(".add-player-to-list").on("click", function (){
            _this.addPlyerToList(this);
        });
    },
    insert: function (){

        let data = {};

        data.name = $("#inputName").val();
        data.nickName = $("#inputNickName").val();
        data.mainPosition = $("#inputMainPosition").val();
        data.mainTier = $("#inputMainTier").val();
        data.subPosition = $("#inputSubPosition").val();
        data.subTier = $("#inputSubTier").val();

        $.ajax({
            url: "/player/insert",
            method: "POST",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            success: function (result, textStatus, xhr){
                console.log(xhr.status);
                if(xhr.status == 200 && result > 0){
                    alert("신규 플레이어가 등록되었습니다.")
                    location.href = "/player/list";
                }else{
                    alert("등록 요청이 정상적으로 처리되지않았습니다. [code:" +xhr.status+"]");
                    location.reload();
                }
            },
            error: function (x,h,r){
                console.log(x);
                alert("시스템 오류 발생");
                return;
            }
        });


    },
    getPlayerList: function (){
        $.ajax({
            url: "/player/players",
            method: "GET",
            success: function (result, textStatus, xhr){
                let html = "";
                if(xhr.status == 200){

                    $.each(result, function (index, element){
                        html += "<tr>" +
                                    "<td>"+element.id+"</td>" +
                                    "<td><a href='/player/detail/"+element.id+"'>"+element.nickname+"</a></td>" +
                                    "<td>"+element.mainPosition+"</td>" +
                                    "<td>"+element.subPosition+"</td>" +
                                    "<td>"+element.mainTier+"</td>" +
                                    "<td>"+element.badPlayerRating+"</td>" +
                                    "<td><button class='btn btn-success add-player-to-list' data-player-id='"+element.id+"'> 선택 </button></td>" +
                                "</tr>";

                        $(".add-player-to-list").on("click", function (){
                           main.addPlyerToList(this);
                        });
                    });

                    $("#playerListDiv").html(html);
                }
            },
            error: function (x,h,r){
                alert("시스템 오류 발생");
                return;
            }
        });
    },
    addPlyerToList:function (elem){
        console.log(elem);
    }
}

main.init();